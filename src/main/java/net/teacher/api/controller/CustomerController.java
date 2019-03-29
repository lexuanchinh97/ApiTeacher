package net.teacher.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.teacher.api.model.request.BaseResponse;
import net.teacher.api.model.AuthToken;
import net.teacher.api.model.Customer;
import net.teacher.api.model.request.LoginUser;
import net.teacher.api.config.JwtTokenUtil;
import net.teacher.api.helper.ResponseStatusEnum;
import net.teacher.api.repository.CustomerRepository;
import net.teacher.api.service.CustomerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/api/customers")
public class CustomerController {
	@Autowired 
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> signin(@RequestBody LoginUser loginUser) throws AuthenticationException{
		  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
	      Customer user = customerRepository.findByUsername(loginUser.getUsername());
	      String token = jwtTokenUtil.generateToken(user.getUsername());
	      BaseResponse response=new BaseResponse();
	      response.setMessage(ResponseStatusEnum.SUCCESS);
	      response.setStatus(ResponseStatusEnum.SUCCESS);
	      response.setData(new AuthToken(token, user.getUsername()));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ResponseEntity<BaseResponse> signup(@RequestBody Customer customer){
		BaseResponse response=new BaseResponse();
		response.setMessage(ResponseStatusEnum.SUCCESS);
		response.setStatus(ResponseStatusEnum.SUCCESS);
		response.setData(null);
		Customer user=customerRepository.findByUsername(customer.getUsername());
		if(user!=null) {
			response.setStatus(ResponseStatusEnum.UNAUTHORIZED);
			response.setMessageError("Tài khoản đã tồn tại");
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}
		String password=bCryptPasswordEncoder.encode(customer.getPassword());
		customer.setPassword(password);
		customerService.create(customer);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);

	}
}

package net.teacher.api.controller;

import static net.teacher.api.model.Constants.TOKEN_PREFIX;
import static net.teacher.api.model.Constants.HEADER_STRING;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import net.teacher.api.model.request.ChangePassword;
import net.teacher.api.model.request.CustomerRequest;
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
	
	@RequestMapping(value="/profile",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<BaseResponse> profile(HttpServletRequest req){
		String header=req.getHeader(HEADER_STRING);
		String authToken = header.replace(TOKEN_PREFIX,"");
		String username = jwtTokenUtil.getUsernameFromToken(authToken);
		Customer customer=customerRepository.findByUsername(username);
		BaseResponse response=new BaseResponse();
		response.setMessage(ResponseStatusEnum.SUCCESS);
		response.setStatus(ResponseStatusEnum.SUCCESS);
		response.setData(customer);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity<BaseResponse>update(HttpServletRequest req,@RequestBody CustomerRequest request){
		String header=req.getHeader(HEADER_STRING);
		String authToken = header.replace(TOKEN_PREFIX,"");
		String username = jwtTokenUtil.getUsernameFromToken(authToken);
		Customer customer=customerRepository.findByUsername(username);
		customer.setAddress(request.getAddress());
		customer.setEmail(request.getEmail());
		customer.setPhone(request.getPhone());
		customer.setUsername(request.getUsername());
		customerService.update(customer);
		BaseResponse response=new BaseResponse();
		response.setMessage(ResponseStatusEnum.SUCCESS);
		response.setStatus(ResponseStatusEnum.SUCCESS);
		response.setData(customer);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		
	}
	@RequestMapping(value="/change-password",method=RequestMethod.POST)
	public ResponseEntity<BaseResponse> changePasswrod(HttpServletRequest req,@RequestBody ChangePassword changePassword) throws AuthenticationException{
		String header=req.getHeader(HEADER_STRING);
		String authToken = header.replace(TOKEN_PREFIX,"");
		String username = jwtTokenUtil.getUsernameFromToken(authToken);
		Customer customer=customerService.findByUsername(username);
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, changePassword.getOldPass()));
		customer.setPassword(bCryptPasswordEncoder.encode(changePassword.getNewPass()));
		customerService.update(customer);
		BaseResponse response=new BaseResponse();
		response.setMessage(ResponseStatusEnum.SUCCESS);
		response.setStatus(ResponseStatusEnum.SUCCESS);
		response.setData(null);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		
	}
}

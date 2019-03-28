package net.teacher.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.teacher.api.model.request.ApiResponse;
import net.teacher.api.model.AuthToken;
import net.teacher.api.model.Customer;
import net.teacher.api.model.request.LoginUser;
import net.teacher.api.config.JwtTokenUtil;
import net.teacher.api.repository.CustomerRepository;

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
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ApiResponse<AuthToken> signin(@RequestBody LoginUser loginUser) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
         Customer user = customerRepository.findByUsername(loginUser.getUsername());
         String token = jwtTokenUtil.generateToken(user.getUsername());
        return new ApiResponse<>(200, "success",new AuthToken(token, user.getUsername()));
    }
}

package net.teacher.api.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import net.teacher.api.model.Customer;
import net.teacher.api.repository.CustomerRepository;
/**
 * 
 * @author Liam Le
 *
 */
@Service(value = "userService")
public class AppUserDetailsService implements UserDetailsService{
	@Autowired private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
			Customer user=customerRepository.findByUsername(username);
			if (user == null) {
				throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
			}
			return new User(user.getUsername(),user.getPassword(),getAuthority("ROLE_CUSTOMER"));
	}
	private List<SimpleGrantedAuthority> getAuthority(String role) {
		
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}

}

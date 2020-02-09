package com.ebi.security;


import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author rahil
 *         UserService class implements UserDetailsService
 */
@Service
public class JwtUserDetailsService implements UserDetailsService
{
    
    /**
     * Loads the user with hard coded values
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    {
    	// Hard Coded user to signin
       return new User("rahil", "rahil", new ArrayList<>());

    }
}

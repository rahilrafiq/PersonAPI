package com.ebi.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@SuppressWarnings("serial")
public class JwtUserDetails extends User {

	public JwtUserDetails(com.ebi.dao.model.User user, List<GrantedAuthority> grantedAuthorityList)
    {
        super(user.getUser(),
                user.getPassword(), 
                user.isActive(),   //enabled
                user.isActive(),   //accountNonExpired 
                user.isActive(),   //credentialsNonExpired 
                user.isActive(),   //accountNonLocked
                grantedAuthorityList);    
    }

}

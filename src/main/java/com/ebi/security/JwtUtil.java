package com.ebi.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultJwtBuilder;

/**
 * @author rahil
 *         JwtUtil to generate the JWT
 */
@Component
public class JwtUtil
{
    private final String SECRET_KEY = "emblebi1";
    
    private JwtBuilder jwtBuilder = new DefaultJwtBuilder();

    public String generateToken(String userName)
    {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    public Date extractExpiration(String token)
    {
        return extractClaims(token, Claims::getExpiration);
    }
    
    private Boolean isTokenExpirated(String token)
    {
    	if(extractExpiration(token) == null) {
    		return false;
    	}
        return extractExpiration(token).before(new Date());
    }
    
    public Boolean validateToken(String token, UserDetails userDetails)
    {
        String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpirated(token));
    }
    
    private String createToken(Map<String, Object> claims, String subject)
    {
        return jwtBuilder.setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 *10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public JwtBuilder getJwtBuilder()
    {
        return jwtBuilder;
    }

    public void setJwtBuilder(JwtBuilder jwtBuilder)
    {
        this.jwtBuilder = jwtBuilder;
    }
    
    public String extractUsername(String token)
    {
        return extractClaims(token, Claims::getSubject);
    }
    
    public <T> T extractClaims(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    
}

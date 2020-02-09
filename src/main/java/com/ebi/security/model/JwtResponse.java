package com.ebi.security.model;

/**
 * @author rahil
 *         Reponse Class for the JWT token
 */
public class JwtResponse
{
    private String jwt;

    public JwtResponse()
    {
        //Default constructor
    }
  
    public JwtResponse(String jwt)
    {
        this.jwt = jwt;
    }

    public String getJwt()
    {
        return jwt;
    }

    public void setJwt(String jwt)
    {
        this.jwt = jwt;
    }

}
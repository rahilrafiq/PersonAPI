//package com.ebi.controller;
//
//import static org.mockito.ArgumentMatchers.isA;
//import static org.mockito.Mockito.when;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.ebi.controller.dto.UserDto;
//import com.ebi.security.JwtUtil;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SigninControllerTest
//{
//    private MockMvc mockMvc;
//
//    @Autowired
//    private SignInController signinController;
//
//    @MockBean
//    private AuthenticationManager mockAuthenticationManager;
//    
//    @MockBean
//    private JwtUtil mockJwtUtil;
//
//    private static final String PHONE_NUMBER = "rahil";
//    private static final String JWT_TOKEN = "Some Token";
//
//    @Before
//    public void setUp()
//    {
//        mockMvc = MockMvcBuilders.standaloneSetup(signinController).build();
//
//    }
//
//    @Test
//    public void signinWithUsernameNotFoundException() throws Exception
//    {   
//        // mock
//        when(mockAuthenticationManager.authenticate(isA(UsernamePasswordAuthenticationToken.class))).thenThrow(UsernameNotFoundException.class);
//    
//        // action
//        ResultActions resultActions = invokeSignInService();      
//
//        // expectations in Header
//        //assertThat(resultActions, );
//    }
//    
//    private ResultActions invokeSignInService() throws Exception, JsonProcessingException
//    {
//        ResultActions resultActions = mockMvc.perform(
//                MockMvcRequestBuilders.post("/signin").contentType(MediaType.APPLICATION_JSON).content(createSignInRequestJSON()));
//        return resultActions;
//    }
//          
//    private String createSignInRequestJSON() throws JsonProcessingException
//    {        
//        ObjectMapper mapper = new ObjectMapper();
//        UserDto userDto = new UserDto();
//        userDto.setPassword("abc");
//        userDto.setUser("abc");
//        return mapper.writeValueAsString(userDto);
//    }
//    
//}

package pe.edu.nh.demoFeign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.nh.demoFeign.login.AuthServiceFeignClient;
import pe.edu.nh.demoFeign.login.LoginRequest;
import pe.edu.nh.demoFeign.login.LoginResponse;

@RestController
public class AuthController {
    @Autowired
    private AuthServiceFeignClient authServiceFeignClient;

    @PostMapping("/auth/url")
    public String getUrl(@RequestBody AuthRequest authRequest) {
        LoginRequest loginRequest = new LoginRequest(authRequest.getUsername(), authRequest.getPassword());
        LoginResponse loginResponse = authServiceFeignClient.login(loginRequest);
        if(loginResponse.getRespuesta().equals("Login correcto")){
            return "Puede cargar la URL: " + authRequest.getUrl();
        }else{
            return "No puede cargar la URL: " + authRequest.getUrl();
        }
    }


}

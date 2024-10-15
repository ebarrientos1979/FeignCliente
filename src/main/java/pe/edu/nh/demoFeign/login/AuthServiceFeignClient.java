package pe.edu.nh.demoFeign.login;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="authService", url="http://localhost:8080/api/auth")
public interface AuthServiceFeignClient {
    @PostMapping("/login")
    LoginResponse login(@RequestBody LoginRequest loginRequest);
}

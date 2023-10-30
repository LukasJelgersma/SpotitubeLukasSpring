package dea.spotitube.spring.spotitubelukasspring.resourceLayer;


import com.fasterxml.jackson.annotation.JsonGetter;
import dea.spotitube.spring.spotitubelukasspring.SpotitubeLukasSpringApplication;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.request.UserRequestDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.UserResponseDTO;
import dea.spotitube.spring.spotitubelukasspring.serviceLayer.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class LoginResource {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.authUser(userRequestDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

}

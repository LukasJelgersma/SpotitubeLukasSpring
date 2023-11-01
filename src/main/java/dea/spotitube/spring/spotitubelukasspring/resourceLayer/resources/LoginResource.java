package dea.spotitube.spring.spotitubelukasspring.resourceLayer.resources;

import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.request.UserRequestDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.UserResponseDTO;
import dea.spotitube.spring.spotitubelukasspring.serviceLayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginResource {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.authUser(userRequestDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

}

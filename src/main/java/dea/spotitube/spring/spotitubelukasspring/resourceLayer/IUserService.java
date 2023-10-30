package dea.spotitube.spring.spotitubelukasspring.resourceLayer;


import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.UserDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.request.UserRequestDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.UserResponseDTO;

public interface IUserService {
    UserDTO getUserByToken(String token);

    UserResponseDTO authUser(UserRequestDTO userRequestDTO);
}

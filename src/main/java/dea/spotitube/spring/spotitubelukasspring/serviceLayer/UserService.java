package dea.spotitube.spring.spotitubelukasspring.serviceLayer;

import dea.spotitube.spring.spotitubelukasspring.datasourceLayer.UserDao;
import dea.spotitube.spring.spotitubelukasspring.exceptions.InvalidCredentialsException;
import dea.spotitube.spring.spotitubelukasspring.exceptions.UserNotAvailableException;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.IUserService;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.UserDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.request.UserRequestDTO;
import dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response.UserResponseDTO;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements IUserService {
    private UserDao userDao;

    public UserService() {

    }

    /**
     * Get user by token
     * @param token
     * @return UserDTO
     */
    @Override
    public UserDTO getUserByToken(String token) {
        return userDao.getUserByToken(token);
    }

    /**
     * Authenticate user
     * @param userRequestDTO
     * @return UserResponseDTO
     */
    @Override
    public UserResponseDTO authUser(UserRequestDTO userRequestDTO) {
        UserDTO user = userDao.getUserCredentials(userRequestDTO.getUser());
        if (user == null) {
            throw new UserNotAvailableException();
        } else if (user.getPassword().equals(DigestUtils.sha256Hex(userRequestDTO.getPassword()))) {
            String token = UUID.randomUUID().toString();
            user.setUsertoken(token);
            userDao.setUserToken(user);
            return new UserResponseDTO(userRequestDTO.getUser(), token);
        } else {
            throw new InvalidCredentialsException();
        }
    }


    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}

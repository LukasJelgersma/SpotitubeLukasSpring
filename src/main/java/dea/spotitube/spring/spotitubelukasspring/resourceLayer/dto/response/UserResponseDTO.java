package dea.spotitube.spring.spotitubelukasspring.resourceLayer.dto.response;

public class UserResponseDTO {
    private String user, token;

    public UserResponseDTO(String user, String token) {
        this.user = user;
        this.token = token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

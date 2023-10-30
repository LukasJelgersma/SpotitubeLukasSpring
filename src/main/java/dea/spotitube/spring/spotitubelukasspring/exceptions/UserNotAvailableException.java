package dea.spotitube.spring.spotitubelukasspring.exceptions;

public class UserNotAvailableException extends NullPointerException{
    public UserNotAvailableException() {
        super("User not available");
    }
}

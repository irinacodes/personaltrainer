package rs.personaltrainer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class PersonalTrainerUserNotFoundException extends RuntimeException {

    public PersonalTrainerUserNotFoundException(String userId) {
        super("could not find user '" + userId + "'.");
    }
}

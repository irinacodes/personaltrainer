package rs.personaltrainer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.personaltrainer.exceptions.UserAlreadyExistsException;
import rs.personaltrainer.model.User;
import rs.personaltrainer.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HelloResponse> hello(Principal principal) {

        return new ResponseEntity<HelloResponse>(
                new HelloResponse("Hello, " + principal.getName() + "!"), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody @Valid final User user, Principal principal) {
        LOGGER.debug("Received request to create the {}", user);
        return userService.save(user);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> listUsers() {
        LOGGER.debug("Received request to list all users");
        return userService.getList();
    }

    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        return null;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return e.getMessage();
    }

    public static class HelloResponse {
        private String message;
        public HelloResponse(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
    }

}




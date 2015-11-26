package rs.personaltrainer.service;

import rs.personaltrainer.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User getUserById(long id);
    User getUserByEmail(String email);
    User create(User user);
    Collection<User> getList();
    void delete(long id);
}

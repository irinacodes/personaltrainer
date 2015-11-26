package rs.personaltrainer.service;

import rs.personaltrainer.model.User;

import java.util.Collection;

public interface UserService {

    User getUserById(String id);
    User getUserByEmail(String email);
    User create(User user);
    Collection<User> getList();
    void delete(String id);
}

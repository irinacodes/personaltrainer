package rs.personaltrainer.service;

import rs.personaltrainer.model.User;
import java.util.List;

public interface UserService {

    User save(User user);
    List<User> getList();
    void delete(String id);
    User update(User user);
}

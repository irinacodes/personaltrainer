package rs.personaltrainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import rs.personaltrainer.exceptions.UserAlreadyExistsException;
import rs.personaltrainer.model.User;
import rs.personaltrainer.repository.UserRepository;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Validated
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserById(String id) {
        LOGGER.debug("Getting user={}", id);
        return repository.findOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        LOGGER.debug("Getting user by email={}", email.replaceFirst("@.*", "@***"));
        return repository.findOneByEmail(email);
    }

    @Override
    @Transactional
    public User create(@NotNull @Valid final User user) {
        LOGGER.debug("Creating {}", user);
//        User existing = repository.findOne(user.getId());
//        if (existing != null) {
//            throw new UserAlreadyExistsException(String.format("There already exists a user with id=%s", user.getId()));
//        }
        return repository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getList() {
        LOGGER.debug("Retrieving the list of all users");
        return repository.findAll(new Sort("email"));
    }

    @Override
    public void delete(String id) {
        LOGGER.debug("Deleting user");
        repository.delete(id);
    }

}

package rs.personaltrainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.personaltrainer.model.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findOneByLoginname(String loginname);
    User findOneByEmail(String email);

}

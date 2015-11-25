package rs.personaltrainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import rs.personaltrainer.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}

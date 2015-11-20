package rs.personaltrainer.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rs.personaltrainer.model.PersonalTrainerUser;

public interface PersonalTrainerUserRepository extends PagingAndSortingRepository<PersonalTrainerUser, Long> {

}

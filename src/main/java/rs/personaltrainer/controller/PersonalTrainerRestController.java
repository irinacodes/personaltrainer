package rs.personaltrainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import rs.personaltrainer.model.PersonalTrainerUser;
import rs.personaltrainer.repository.PersonalTrainerUserRepository;
import java.util.Date;

@RestController
@RequestMapping("/api")
class PersonalTrainerRestController {

    private final PersonalTrainerUserRepository personalTrainerUserRepository;

    @Autowired
    PersonalTrainerRestController(PersonalTrainerUserRepository personalTrainerUserRepository) {
        this.personalTrainerUserRepository = personalTrainerUserRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<PersonalTrainerUser> findAll() {
//        return personalTrainerUserRepository.findAll();
//    }

    @RequestMapping(method = RequestMethod.POST)
    public PersonalTrainerUser add(@RequestBody PersonalTrainerUser user) {
        PersonalTrainerUser model = new PersonalTrainerUser();
        model.setCreated(new Date());
        return personalTrainerUserRepository.save(model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PersonalTrainerUser update(@PathVariable long id, @Validated @RequestBody PersonalTrainerUser user) {
        PersonalTrainerUser model = personalTrainerUserRepository.findOne(id);
        if (model != null) {
            model.setLoginname(user.getLoginname());
            model.setName(user.getName());
            return personalTrainerUserRepository.save(model);
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        personalTrainerUserRepository.delete(id);
    }

}




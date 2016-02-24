package rs.personaltrainer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import rs.personaltrainer.restsecurity.ApplicationSecurity;

@SpringBootApplication
public class Application {

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new ApplicationSecurity();
    }

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    CommandLineRunner init(final UserRepository userRepository) {
//
//        return new CommandLineRunner() {
//
//            @Override
//            public void run(String... arg0) throws Exception {
//                userRepository.saveAndFlush(new User("lenny", "kravitz", "lenny@personaltrainer.rs"));
//            }
//
//        };
//
//    }

}

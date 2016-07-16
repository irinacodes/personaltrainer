package rs.personaltrainer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
//public class Application {
//
//    @Bean
//    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
//        return new ApplicationSecurity();
//    }
//
//    public static void main(final String[] args) {
//        SpringApplication.run(Application.class, args);
//    }

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

//}

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}

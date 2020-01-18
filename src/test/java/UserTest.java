import com.kovaliv.blog.config.SecurityConfig;
import com.kovaliv.blog.config.WebConfig;
import com.kovaliv.blog.hibernate.enams.Role;
import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.hibernate.repo.UserRepo;
import com.kovaliv.blog.hibernate.repo.UserRepoHibernate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(
        classes = {
                SecurityConfig.class,
                WebConfig.class
        }
)
public class UserTest {

    private final Logger logger = LogManager.getLogger(UserTest.class);

    private UserRepo userRepo;

    private PasswordEncoder passwordEncoder;

    private User user;

    @Test
    public void getPasswordEncoder() {
        passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("1111"));
    }

    @Test
    public void createUserTest() {
        passwordEncoder = new BCryptPasswordEncoder();
        user = new User();
        user.setLogin("taras");
        user.setId(0);
        user.setPassword(passwordEncoder.encode("1111"));
        user.setEmail("taras19041@gmail.com");
        user.setName("Taras");
        user.setSurname("Korol");
        user.setRole(Role.USER);
        logger.info(user.toString());
        userRepo = new UserRepoHibernate();
        logger.info(userRepo.getClass().toString());
        userRepo.add(user);
    }

//    @Test
//    public void deleteUserTest(){
//        User user1 = userRepo.get(1);
//        userRepo.delete(user1);
//    }


}

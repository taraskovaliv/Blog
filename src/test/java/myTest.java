import com.kovaliv.blog.exceptions.MessageException;
import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.services.AuthorizationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class myTest {

    private final Logger logger = LogManager.getLogger(myTest.class);

    @Test
    public void thisTest() {
        AuthorizationService.getUser();
        AuthorizationService.getLoginStatus();

        User user = new User();
        user.setLogin("taras");
        user.setPassword("111");

        try {
            AuthorizationService.login(user);
        } catch (MessageException e) {
            user.setPassword("1111");
            try {
                AuthorizationService.login(user);
            } catch (MessageException ex) {
                ex.printStackTrace();
            }
        }
    }
}

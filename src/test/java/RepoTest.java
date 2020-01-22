import com.kovaliv.blog.config.SecurityConfig;
import com.kovaliv.blog.config.WebConfig;
import com.kovaliv.blog.hibernate.models.Article;
import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.hibernate.repo.ArticleRepo;
import com.kovaliv.blog.hibernate.repo.ArticleRepoHibernate;
import com.kovaliv.blog.hibernate.repo.UserRepo;
import com.kovaliv.blog.hibernate.repo.UserRepoHibernate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Date;


@ContextConfiguration(
        classes = {
                SecurityConfig.class,
                WebConfig.class
        }
)
public class RepoTest {

    private final Logger logger = LogManager.getLogger(RepoTest.class);

    private UserRepo userRepo;

    private ArticleRepo articleRepo;

    private PasswordEncoder passwordEncoder;

    @Test
    public void userRepoTest() {
        passwordEncoder = new BCryptPasswordEncoder();
        userRepo = new UserRepoHibernate();

        User user = userRepo.get(1);
        user.setSurname(user.getSurname() + "v");
        userRepo.edit(user);

        user = getDefaultUser();
        userRepo.add(user);
        user = userRepo.getByEmail(user.getEmail());
        userRepo.delete(user);

        user = getDefaultUser();
        userRepo.add(user);
        userRepo.delete(userRepo.get(user.getLogin()).getUserId());
    }

    @Test
    public void articleRepoTest() {
        articleRepo = new ArticleRepoHibernate();

        articleRepo.get(1);

        Article article = getDefaultArticle();
        articleRepo.add(article);
        articleRepo.delete(article);

        article = getDefaultArticle();
        articleRepo.add(article);
        article = articleRepo.get("Article2");
        articleRepo.delete(article.getId());
    }

    private User getDefaultUser() {
        User user = new User();
        user.setLogin("taras111");
        user.setPassword(passwordEncoder.encode("1111"));
        user.setEmail("taras1904@gmail.com");
        user.setName("Taras");
        user.setSurname("Korol");
        user.setRole("USER");
        return user;
    }

    private Article getDefaultArticle() {
        Article article = new Article();
        article.setDate(new Date(System.currentTimeMillis()));
        article.setName("Article2");
        article.setText("Some text and some thinks. Some text and some thinks. Some text and some thinks. Some text and some thinks.\n" +
                "Some text and some thinks. Some text and some thinks. Some text and some thinks. Some text and some thinks.\n" +
                "Some text and some thinks. Some text and some thinks. Some text and some thinks. Some text and some thinks.");
        return article;
    }
}

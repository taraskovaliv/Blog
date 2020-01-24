import com.kovaliv.blog.hibernate.enams.Role;
import com.kovaliv.blog.hibernate.models.Article;
import com.kovaliv.blog.hibernate.models.User;
import com.kovaliv.blog.hibernate.repo.ArticleRepo;
import com.kovaliv.blog.hibernate.repo.Repos;
import com.kovaliv.blog.hibernate.repo.UserRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

public class RepoTest {

    private final Logger logger = LogManager.getLogger(RepoTest.class);

    @Test
    public void userRepoTest() {
        UserRepo userRepo = Repos.getUserRepo();

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
        ArticleRepo articleRepo = Repos.getArticleRepo();

        articleRepo.get(1);

        Article article = getDefaultArticle();
        articleRepo.add(article);
        articleRepo.delete(article);

        article = getDefaultArticle();
        articleRepo.add(article);
        article = articleRepo.get("Article2");
        articleRepo.delete(article.getId());

        List<Article> articles = articleRepo.getArticles("taras");
        for (Article article1 : articles) {
            logger.info(article1.toString());
        }

        articles = articleRepo.getLast(2);
        for (Article article1 : articles) {
            logger.info(article1.toString());
        }
    }

    public User getDefaultUser() {
        User user = new User();
        user.setLogin("taras111");
        user.setPassword("1111");
        user.setEmail("taras1904@gmail.com");
        user.setName("Taras");
        user.setSurname("Korol");
        user.setRole(Role.USER.name());
        return user;
    }

    private Article getDefaultArticle() {
        Article article = new Article();
        article.setDate(new Date(System.currentTimeMillis()));
        article.setName("Article2");
        article.setAuthor("taras");
        article.setText("Some text and some thinks. Some text and some thinks. Some text and some thinks. Some text and some thinks.\n" +
                "Some text and some thinks. Some text and some thinks. Some text and some thinks. Some text and some thinks.\n" +
                "Some text and some thinks. Some text and some thinks. Some text and some thinks. Some text and some thinks.");
        return article;
    }
}

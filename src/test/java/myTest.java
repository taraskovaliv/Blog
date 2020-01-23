import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class myTest {

    private final Logger logger = LogManager.getLogger(myTest.class);

    public void thisTest() {
        logger.info("start");
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();

        root.scan("com.kovaliv.blog");
        root.refresh();
    }
}

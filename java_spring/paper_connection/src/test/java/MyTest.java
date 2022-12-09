import com.paper.connection.dao.PaperDao;
import com.paper.connection.dao.UserDao;
import com.paper.connection.pojo.Paper;
import com.paper.connection.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        PaperDao paperDao = (PaperDao) context.getBean("paperDao");

        for (Paper sim : paperDao.queryPaperBySearch("sim")) {
            System.out.println(sim);
        }


    }
}

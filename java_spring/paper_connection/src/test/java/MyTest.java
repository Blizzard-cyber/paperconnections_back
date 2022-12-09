import com.paper.connection.dao.UserDao;
import com.paper.connection.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        User user = new User(1,"admin","123456");

        //userDao.addUser(user);

        for (User user1 : userDao.allUser()) {
            System.out.println(user1);
        }
    }
}

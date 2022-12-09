import com.paper.connection.dao.UserDao;
import com.paper.connection.pojo.Paper;
import com.paper.connection.pojo.User;
import com.paper.connection.service.PaperService;
import com.paper.connection.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        UserDao userDao = (UserDao) context.getBean("userDao");
//        User user = new User(1,"admin","123456");
//        UserService userService =  (UserService) context.getBean("userService");
        PaperService paperService =  (PaperService) context.getBean("paperServiceImpl");
//        User user = userDao.queryUserById(1);
        List<Paper> list = paperService.queryPaperByConnection(1);
        list = list.subList(0,9);
        for(Paper paper: list){
            System.out.println(paper);
        }
    }

}

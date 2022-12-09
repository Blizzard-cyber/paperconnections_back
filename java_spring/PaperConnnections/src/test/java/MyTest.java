import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    //junit测试类
    @Test
    public void test(){
        System.out.println("test");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");

        //System.out.println(userMapper.checkLogin("aaa","789"));
        //System.out.println(userMapper.queryUserByEmail("aaa"));
        //System.out.println(userMapper.queryUserBySearch("a"));


        for (User user : userMapper.allUser()) {
            System.out.println(user);
        }
    }
}

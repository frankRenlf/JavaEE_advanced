import com.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : spring-1
 * @Package : PACKAGE_NAME
 * @createTime : 2022/11/3 17:37
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        User user1 = context.getBean("user1", User.class);
//        user1.sayHi();
        System.out.println(user1.id);
        user1.id = 2;
        User user2 = context.getBean("user1", User.class);
        System.out.println(user1 == user2);
    }
}

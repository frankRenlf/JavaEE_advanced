import com.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;
import static java.time.LocalTime.now;

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
    private static void createThreadPool() {
        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(() -> {
                // 获取线程名称,默认格式:pool-1-thread-1
                System.out.println(now() + " " + Thread.currentThread().getName() + " " + index);
                // 等待2秒
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public static void main(String[] args) {
        createThreadPool();
    }

    public static void main1(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        User user1 = context.getBean("user1", User.class);
//        user1.sayHi();
        System.out.println(user1.id);
        user1.id = 2;
        User user2 = context.getBean("user1", User.class);
        System.out.println(user1 == user2);
    }
}

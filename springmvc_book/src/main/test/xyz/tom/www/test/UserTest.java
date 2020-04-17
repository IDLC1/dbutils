package xyz.tom.www.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xyz.tom.www.domain.R;
import xyz.tom.www.domain.User;
import xyz.tom.www.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmvc.xml")
@WebAppConfiguration("src/main/resources")
public class UserTest {

    @Autowired
    private UserService userService = null;

    @Test
    public void regTest() {
        User user = new User();
        user.setAccount("haha");
        user.setPassword("123");

        R r = userService.register(user);
        System.out.println(r);
    }
}

package xyz.tom.www.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xyz.tom.www.dao.UserDao;
import xyz.tom.www.domain.User;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmvc.xml")
@WebAppConfiguration("src/main/resources")
public class DbUtilsTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void save() {
        User user = new User();
        user.setAccount("admin");
        user.setPassword("111");
        userDao.save(user);
    }

    @Test
    public void getAllUser() {
        List<User> lists = userDao.getAll();
        for (User user: lists) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserByAcc() {
        User user = userDao.getObjectByAcc("admin");
        System.out.println(user);
    }

    @Test
    public void delete(){
        User user = new User();
        user.setAccount("admin");
        int count = userDao.remove(user);
        System.out.println(count);
    }

    @Test
    public void modifyPwd() {
        User user = new User();
        user.setAccount("admin");
        user.setPassword("123456");
        int count = userDao.update(user);
        System.out.println(count);
    }
}

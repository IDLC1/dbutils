package xyz.tom.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.tom.www.dao.UserDao;
import xyz.tom.www.domain.R;
import xyz.tom.www.domain.User;
import xyz.tom.www.service.UserService;

import javax.servlet.http.HttpServletResponse;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public R register(User user) {
        System.out.println("业务层 注册");
        System.out.println(user);
        User sUser = userDao.getObjectByAcc(user.getAccount());
        if(sUser != null) {
            return R.error("用户已注册");
        }
        int count = userDao.save(user);
        if(count == 0) return R.error("注册失败");
        return R.success("注册成功");
    }

    @Override
    public R login(User user) {
        System.out.println("业务层 登录");
        User u  = userDao.getObjectByAcc(user.getAccount());
        if(u != null && u.getPassword().equals(user.getPassword())) {
            return R.success("登录成功！");
        }
        return R.error("登录失败！");
    }

    @Override
    public User findByName(String acc) {
        return userDao.getObjectByAcc(acc);
    }
}

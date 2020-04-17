package xyz.tom.www.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xyz.tom.www.domain.R;
import xyz.tom.www.domain.User;
import xyz.tom.www.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
//    @ResponseBody // 代表返回的是数据，而不是页面
    public ModelAndView login(@RequestBody User user, HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("控制层 登录");
        R r = userService.login(user);
        System.out.println(r);
        ModelAndView mv = new ModelAndView();
        if(Integer.parseInt(r.get("code").toString()) == 0) {
            System.out.println(req.getContextPath());
            mv.setViewName("mainLayout");
        } else {
            mv.setViewName("error");
        }
        return mv;
    }

    @RequestMapping("reg")
    public ModelAndView reg() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping("/register")
    @ResponseBody
    public R register(@RequestBody User user) {
        if(user.getAccount()==null || user.getAccount() =="" || user.getPassword()==null || user.getPassword()=="") R.error("账号不能为空");
        System.out.println("控制层 注册");
        return userService.register(user);
    }
}

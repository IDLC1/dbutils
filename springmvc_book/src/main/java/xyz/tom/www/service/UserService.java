package xyz.tom.www.service;

import xyz.tom.www.domain.R;
import xyz.tom.www.domain.User;

import javax.servlet.http.HttpServletResponse;

public interface UserService {

    public R register(User user);

    public R login(User user);

    public User findByName(String acc);
}

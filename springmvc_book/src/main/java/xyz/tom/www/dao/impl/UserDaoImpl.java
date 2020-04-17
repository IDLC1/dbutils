package xyz.tom.www.dao.impl;

import com.mchange.v1.db.sql.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.tom.www.dao.UserDao;
import xyz.tom.www.domain.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private QueryRunner runner;

//    @Autowired
//    private ConnectionUtils connectionUtils;

    @Override
    public int save(User user) {
        try {
            System.out.println("持久层 注册账户");
            return runner.update("insert into user(account,password) values(?,?)",user.getAccount(), user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public User getObjectById(int id) {
        try {
            List<User> lists = runner.query("select * from user where id = ?", new BeanListHandler<User>(User.class), id);
            if (lists == null || lists.size() == 0) {
                return null;
            }
            if(lists.size() > 0) {
                throw new RuntimeException("结果集不唯一！");
            }
            return lists.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public User getObjectByAcc(String acc) {
        System.out.println("持久层 查找用户");
        try {
            List<User> lists = runner.query("select * from user where account = ?", new BeanListHandler<User>(User.class), acc);
            if (lists == null || lists.size() == 0) {
                return null;
            }
            if(lists.size() > 1) {
                throw new RuntimeException("结果集不唯一！");
            }
            return lists.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public int update(User user) {
        System.out.println("持久层 更新用户");
        try {
            return runner.update("update user set password=? where account = ?", user.getPassword(), user.getAccount());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return runner.query("select * from user", new BeanListHandler<User>(User.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public int remove(User user) {
        try {
            return runner.update("delete from user where account = ?", user.getAccount());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

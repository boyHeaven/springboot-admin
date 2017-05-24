package cn.com.yxb.springboot.user.impl;

import cn.com.yxb.springboot.bean.UserBean;
import cn.com.yxb.springboot.user.UserDao;
import cn.com.yxb.springboot.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created on 2017/5/24.
 *
 * @author bin
 */
@Service("loginService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public boolean userLogin(String loginName, String password) throws Exception {
        UserBean userBean = userDao.findOneByUserLoginName(loginName, password);
        if (userBean != null) {
            return true;
        }
        return false;
    }
}

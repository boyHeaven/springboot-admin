package cn.com.yxb.springboot.user.impl;

import cn.com.yxb.springboot.bean.UserBean;
import cn.com.yxb.springboot.mapper1.UserDao;
import cn.com.yxb.springboot.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2017/5/24.
 *
 * @author bin
 */
@Service("loginService")
@Transactional
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Override
    public boolean userLogin(String loginName, String password) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");

        logger.info("enter login controller date --> [{}] name --> [{}]  password ---> [{}]",
                simpleDateFormat.format(new Date()), loginName, password);

        UserBean userBean = userDao.findOneByUserLoginName(loginName, password);
        if (userBean != null) {
            return true;
        }
        return false;
    }
}

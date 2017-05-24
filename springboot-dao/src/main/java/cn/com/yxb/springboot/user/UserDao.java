package cn.com.yxb.springboot.user;

import cn.com.yxb.springboot.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created on 2017/5/24.
 *
 * @author bin
 */
@Mapper
public interface UserDao {

    @Select("select * from users u where u.loginName=#{loginUser} and u.password=#{password}  ")
    UserBean findOneByUserLoginName(@Param("loginUser") String loginUser, @Param("password") String password);

}

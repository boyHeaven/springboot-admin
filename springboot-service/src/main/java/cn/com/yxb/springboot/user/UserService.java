package cn.com.yxb.springboot.user;

/**
 * Created on 2017/5/24.
 *
 * @author bin
 */
public interface UserService {


    /**
     * User login boolean.
     *
     * @param loginName the login name
     * @param password  the password
     * @return the boolean
     * @throws Exception the exception
     */
    boolean userLogin(String loginName, String password) throws Exception;
}

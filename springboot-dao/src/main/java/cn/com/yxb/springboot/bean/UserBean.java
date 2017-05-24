package cn.com.yxb.springboot.bean;

import java.util.UUID;

/**
 * Created on 2017/5/24.
 *
 * @author bin
 */
public class UserBean extends BaseBean<UUID> {

    /**
     * 姓名.
     */
    private String userName;

    /**
     * 登录名.
     */
    private String loginName;

    /**
     * 密码.
     */
    private String password;

    /**
     * 邮箱.
     */
    private String email;

    /**
     * 住址.
     */
    private String address;

    /**
     * 年龄.
     */
    private int age;

    /**
     * 性别：0 男,1女.
     */
    private int sex;

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets login name.
     *
     * @return the login name
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * Sets login name.
     *
     * @param loginName the login name
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets emial.
     *
     * @return the emial
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets emial.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets sex.
     *
     * @return the sex
     */
    public int getSex() {
        return sex;
    }

    /**
     * Sets sex.
     *
     * @param sex the sex
     */
    public void setSex(int sex) {
        this.sex = sex;
    }
}

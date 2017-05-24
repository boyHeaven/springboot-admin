package cn.com.yxb.springboot.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2017/5/24.
 *
 * @param <T> the type parameter
 * @author bin
 */
public class BaseBean<T> implements Serializable {

    /**
     * 序列化ID.
     */
    private static final long serialVersionUID = -5901355242682333084L;

    /**
     * Id.
     */
    private String id;

    /**
     * 创建时间.
     */
    private Date createdTime;

    /**
     * 最后修改时间.
     */
    private Date lastModifyTime;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets created time.
     *
     * @return the created time
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * Sets created time.
     *
     * @param createdTime the created time
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * Gets last modify time.
     *
     * @return the last modify time
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * Sets last modify time.
     *
     * @param lastModifyTime the last modify time
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}

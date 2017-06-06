package cn.com.yxb.springboot.utils;

/**
 * Created on 2017/6/6.
 *
 * @author bin
 */
public enum ResponseStatus implements Status {

    /**
     * The SUCCEED.
     */
    SUCCEED(0),

    /**
     * The NOT_FOUND.
     */
    NOT_FOUND(-1),

    /**
     * The UNKNOWN_ERROR.
     */
    UNKNOWN_ERROR(-9);

    private final int code;

    /**
     * Instantiates a new Response code.
     *
     * @param code the code
     */
    ResponseStatus(int code) {
        this.code = code;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    @Override
    public int getCode() {
        return code;
    }
}


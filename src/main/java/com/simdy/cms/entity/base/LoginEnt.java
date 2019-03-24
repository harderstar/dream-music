package com.simdy.cms.entity.base;

/**
 * @ClassName LoginEnt
 * @Description TODO
 * @Author simdy
 * @Date 2019/3/24 14:14
 * @Version 1.0
 **/
public class LoginEnt {

    private String name;
    private String password;
    private String VAPTCHA;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVAPTCHA() {
        return VAPTCHA;
    }

    public void setVAPTCHA(String VAPTCHA) {
        this.VAPTCHA = VAPTCHA;
    }
}

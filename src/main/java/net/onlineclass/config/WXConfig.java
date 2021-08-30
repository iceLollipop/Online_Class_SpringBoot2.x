package net.onlineclass.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

@Configuration
@PropertySource({"classpath:pay.properties"})
public class WXConfig implements Serializable {
    @Value("${wxpay.appid}")
    private String payAppid;

    @Value("${wxpay.security}")
    private String paySecurity;

    @Value("${wxpay.mechid}")
    private String payMechid;


    public String getPayAppid() {
        return payAppid;
    }

    public void setPayAppid(String payAppid) {
        this.payAppid = payAppid;
    }

    public String getPaySecurity() {
        return paySecurity;
    }

    public void setPaySecurity(String paySecurity) {
        this.paySecurity = paySecurity;
    }

    public String getPayMechid() {
        return payMechid;
    }

    public void setPayMechid(String payMechid) {
        this.payMechid = payMechid;
    }
}

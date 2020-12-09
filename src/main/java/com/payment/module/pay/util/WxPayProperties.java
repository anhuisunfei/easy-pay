package com.payment.module.pay.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "wx.pay")
public class WxPayProperties {

    private String mchId;
    private String key;
    private String notifyUrl;

}

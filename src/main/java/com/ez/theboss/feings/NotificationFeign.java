package com.ez.theboss.feings;

import com.ez.theboss.models.SmsRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification-api")
public interface NotificationFeign {

    @PostMapping("/notification/sms")
    void sendSmsNotify(SmsRequest smsRequest);

}

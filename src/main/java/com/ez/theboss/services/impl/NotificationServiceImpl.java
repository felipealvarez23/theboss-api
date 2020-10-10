package com.ez.theboss.services.impl;

import com.ez.theboss.feings.NotificationFeign;
import com.ez.theboss.models.SmsRequest;
import com.ez.theboss.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private NotificationFeign notificationFeign;

    @Autowired
    public NotificationServiceImpl(NotificationFeign notificationFeign) {
        this.notificationFeign = notificationFeign;
    }

    @Override
    public void sendSmsNotify(SmsRequest smsRequest) {
        notificationFeign.sendSmsNotify(smsRequest);
    }
}

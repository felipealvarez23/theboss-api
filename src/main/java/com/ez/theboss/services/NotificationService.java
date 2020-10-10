package com.ez.theboss.services;

import com.ez.theboss.models.SmsRequest;

public interface NotificationService {

    void sendSmsNotify(SmsRequest smsRequest);

}

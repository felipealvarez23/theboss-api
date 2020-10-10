package com.ez.theboss.delegates;

import com.ez.theboss.models.SmsRequest;
import com.ez.theboss.models.delivery.ClassRoomDelivery;
import com.ez.theboss.models.delivery.SchedulingDelivery;
import com.ez.theboss.models.delivery.VirtualRoomDelivery;
import com.ez.theboss.services.ClassRoomService;
import com.ez.theboss.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClassRoomDelegate {

    private ClassRoomService classRoomService;
    private NotificationService notificationService;
    private final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm";

    @Autowired
    public ClassRoomDelegate(ClassRoomService classRoomService, NotificationService notificationService) {
        this.classRoomService = classRoomService;
        this.notificationService = notificationService;
    }

    public void handleScheduling(){
        LocalDateTime currentDay = LocalDateTime.now();
        List<SchedulingDelivery> schedulingForCurrentDay = classRoomService
                .querySchedulingByDayOfWeek(currentDay.getDayOfWeek());
        schedulingForCurrentDay.stream()
                .filter(schedulingDelivery -> validateNextHour(schedulingDelivery,currentDay))
                .findFirst()
                .ifPresent(schedulingDelivery -> {
                    String message = buildMessage(schedulingDelivery.getClassRoom());
                    notificationService.sendSmsNotify(SmsRequest.builder()
                            .phoneNumber("+573058507458")
                            .message(message)
                            .build());
                });

    }

    private boolean validateNextHour(SchedulingDelivery schedulingDelivery, LocalDateTime currentDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE_TIME);
        LocalDateTime schedulingDate = LocalDateTime.parse(schedulingDelivery.getHour(),formatter);
        return schedulingDate.getHour() == currentDate.plusHours(1).getHour();
    }


    private String buildMessage(ClassRoomDelivery classRoomDelivery){
        VirtualRoomDelivery virtualRoom = classRoomDelivery.getVirtualRooms().stream()
                .filter(VirtualRoomDelivery::isActive)
                .findFirst()
                .orElse(new VirtualRoomDelivery());
        return String.format("Preparate para la siguiente clase de [%s]:\nId: [%s]\nPassword: [%s]", classRoomDelivery.getDescription(),
                virtualRoom.getUrl(),
                virtualRoom.getPassword());
    }


}

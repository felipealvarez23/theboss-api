package com.ez.theboss.models.delivery;

import lombok.Data;

import java.time.DayOfWeek;

@Data
public class SchedulingDelivery {
    private Long id;
    private DayOfWeek dayOfWeek;
    private String hour;
    private ClassRoomDelivery classRoom;
}

package com.ez.theboss.services;

import com.ez.theboss.models.delivery.ClassRoomDelivery;
import com.ez.theboss.models.delivery.SchedulingDelivery;

import java.time.DayOfWeek;
import java.util.List;

public interface ClassRoomService {

    List<ClassRoomDelivery> getClassRoomList();

    List<SchedulingDelivery> querySchedulingByDayOfWeek(DayOfWeek dayOfWeek);

}

package com.ez.theboss.models.delivery;

import lombok.Data;

import java.util.List;

@Data
public class ClassRoomDelivery {

    private Long id;
    private String description;
    private String teacherName;
    private List<VirtualRoomDelivery> virtualRooms;
    private List<SchedulingDelivery> schedulingList;

}



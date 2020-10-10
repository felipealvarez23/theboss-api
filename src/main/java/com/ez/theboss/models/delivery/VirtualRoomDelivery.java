package com.ez.theboss.models.delivery;

import lombok.Data;

@Data
public class VirtualRoomDelivery {
    private Long id;
    private String url;
    private String password;
    private boolean active;
    private ClassRoomDelivery classRoom;
}

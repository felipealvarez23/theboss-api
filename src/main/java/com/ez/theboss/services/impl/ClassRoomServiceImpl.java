package com.ez.theboss.services.impl;

import com.ez.theboss.exceptions.ClassRoomException;
import com.ez.theboss.feings.ClassRoomFeign;
import com.ez.theboss.models.delivery.ClassRoomDelivery;
import com.ez.theboss.models.delivery.SchedulingDelivery;
import com.ez.theboss.services.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    private ClassRoomFeign classRoomFeign;

    @Autowired
    public ClassRoomServiceImpl(ClassRoomFeign classRoomFeign) {
        this.classRoomFeign = classRoomFeign;
    }

    @Override
    public List<ClassRoomDelivery> getClassRoomList() {
        return classRoomFeign.queryClassRoomList().getData();
    }

    @Override
    public List<SchedulingDelivery> querySchedulingByDayOfWeek(DayOfWeek dayOfWeek) {
        try{
            return classRoomFeign.querySchedulingByDayOfWeek(dayOfWeek).getData();
        } catch (Exception e){
            throw new ClassRoomException(
                    String.format("Error querying scheduling in classroom-api for weekday [%s]",dayOfWeek));
        }
    }
}

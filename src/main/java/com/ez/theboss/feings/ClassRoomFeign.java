package com.ez.theboss.feings;

import com.ez.theboss.models.delivery.ClassRoomDelivery;
import com.ez.theboss.models.Response;
import com.ez.theboss.models.delivery.SchedulingDelivery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.DayOfWeek;
import java.util.List;

@FeignClient(name = "classroom-api")
public interface ClassRoomFeign {

    @GetMapping("/class-room")
    Response<List<ClassRoomDelivery>> queryClassRoomList();

    @GetMapping("/scheduling/{dayOfWeek}")
    Response<List<SchedulingDelivery>> querySchedulingByDayOfWeek(@PathVariable("dayOfWeek") DayOfWeek dayOfWeek);

}

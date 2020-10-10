package com.ez.theboss.jobs;

import com.ez.theboss.delegates.ClassRoomDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NextClassJob {

    private ClassRoomDelegate classRoomDelegate;

    @Autowired
    public NextClassJob(ClassRoomDelegate classRoomDelegate) {
        this.classRoomDelegate = classRoomDelegate;
    }

    @Scheduled(cron = "${jobs.classroom.next}")
    public void validateNextClass(){
        classRoomDelegate.handleScheduling();
    }
}

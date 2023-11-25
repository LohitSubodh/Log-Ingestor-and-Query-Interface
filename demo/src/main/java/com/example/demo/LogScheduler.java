package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Component
public class LogScheduler {
    @Autowired
    private LogRepository logRepository;

    @Scheduled(fixedRate = 10000)
    public void scheduleLogIngest() {
        // generate sample logs
        int randomNum = new Random().nextInt(100);

        Log log = new Log();
        log.setId(UUID.randomUUID().toString());
        log.setTimestamp(new Date().toInstant());
        log.setLevel(randomNum < 5 ? "ERROR" : "INFO");
        log.setMessage("This is a sample log message");
        log.setResourceId("server-" + randomNum);
        log.setTraceId(UUID.randomUUID().toString());
        log.setSpanId(UUID.randomUUID().toString());
        log.setCommit("abc123");

        Metadata metadata = new Metadata();
        metadata.setParentResourceId("server-" + randomNum);
        log.setMetadata(metadata);

        logRepository.save(log);
    }


}

package com.example.lib;

import java.time.Duration;
import java.time.LocalDateTime;

public interface Schedulable {
    void schedule(Duration estimatedDuration, LocalDateTime deadline);
    void unschedule();
}
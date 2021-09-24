package com.example.lib;
import java.time.Duration;

public interface ITask {
    String         getName();
    String         getDescription() ;
    Duration       getEstimatedDuration();

    Iterable<Task> getSubTasks() ;
    void           addSubTask(Task t) throws AlreadyExistsException;
    void           removeSubTask(Task t) throws NotFoundException;

}

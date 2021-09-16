import java.time.Duration;

interface ITask {

    String         getName();
    String         getDescription() ;
    Duration       getExpectedDuration();

    Iterable<Task> getSubTasks() ;
    void           addSubTask(Task t) throws AlreadyExistsException;
    void           removeSubTask(Task t) throws NotFoundException;

}
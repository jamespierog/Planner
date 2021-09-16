import java.time.LocalDateTime;

public interface SchedulableProject {
    void schedule(String name, String description, LocalDateTime deadline);
    void unschedule();
}
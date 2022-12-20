import java.time.LocalDate;
import java.time.LocalDateTime;

public interface NextTask {
    LocalDateTime getNextDay();
    LocalDateTime getNextWeek();
    LocalDateTime getNextMonth();
    LocalDateTime getNextYear();
}

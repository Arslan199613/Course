import java.time.LocalDate;
import java.time.LocalDateTime;

public interface NextTask {
    LocalDateTime getNextDate();
    LocalDateTime getTime();
    void setDate(LocalDateTime time);
}

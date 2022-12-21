import java.time.LocalDateTime;
import java.util.Objects;

public class DailyTask extends Task implements NextTask {
    private LocalDateTime time;
    private final static String exception = "Время выполнения задачи выбрано некорректно";
    private final static String daily = "<ежедневная> ";

    public DailyTask(String heading, String description, TypeOfTask typeOfTask, LocalDateTime time) {
        super(heading, description, typeOfTask);
        this.time = time;
    }


    @Override
    public void setDate(LocalDateTime time) {
        if (time.isBefore(LocalDateTime.now())) throw new RuntimeException(exception);
        else this.time = time;
    }

    @Override
    public LocalDateTime getNextDate() {
        return time.plusDays(1);
    }

    @Override
    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return daily + getHeading() + " " + getDescription() + " " + time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DailyTask daily = (DailyTask) o;
        return Objects.equals(time, daily.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time);
    }
}

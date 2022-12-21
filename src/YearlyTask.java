import java.time.LocalDateTime;
import java.util.Objects;

public class YearlyTask extends Task implements NextTask{
    private LocalDateTime time;
    private final static String yearly = " <ежегодная>";
    private final static String exception = "Время выполнения задачи выбрано некорректно";

    public YearlyTask(String heading, String description, TypeOfTask typeOfTask, LocalDateTime time) {
        super(heading, description, typeOfTask);
        this.time = time;
    }

    public void setDate(LocalDateTime time) {
        if (time.isBefore(LocalDateTime.now())) throw new RuntimeException(exception);
        else this.time = time;
    }

    @Override
    public LocalDateTime getNextDate() {
        return time.plusYears(1);
    }
    @Override
    public LocalDateTime getTime(){
        return time;
    }
    @Override
    public String toString() {
        return yearly + getHeading() + " " + getDescription() + " " + time;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        YearlyTask yearly = (YearlyTask) o;
        return Objects.equals(time, yearly.time);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time);
    }
}


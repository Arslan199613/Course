import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class WeeklyTask extends Task implements NextTask {
    private LocalDateTime time;
    private LocalDate time1;
    private final static String exception = "Время выполнения задачи выбрано некорректно";
    private final static String weekly = "<еженедельная> ";

    public WeeklyTask(String heading, String description, TypeOfTask typeOfTask, LocalDate time1) {
        super(heading, description, typeOfTask);
        this.time1 = time1;
    }

    public WeeklyTask(String heading, String description, TypeOfTask typeOfTask, LocalDateTime time) {
        super(heading, description, typeOfTask);
        this.time = time;
    }

    @Override
    public void setDate(LocalDateTime time){
        if (time.isBefore(LocalDateTime.now())) throw new RuntimeException(exception); else this.time = time;
    }
    @Override
    public LocalDateTime getNextDate() {
        return time.plusWeeks(1);
    }
    @Override
    public LocalDateTime getTime(){
        return time;
    }
    @Override
    public String toString() {
        return weekly + getHeading() + " " + getDescription() + " " + time;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WeeklyTask weekly = (WeeklyTask) o;
        return Objects.equals(time, weekly.time);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time);
    }
}

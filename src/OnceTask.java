import java.time.LocalDate;
import java.time.LocalDateTime;

public class OnceTask extends Task{
    private LocalDateTime time;
    private LocalDate time1;
    private final static String exception = "Время выполнения задачи выбрано некорректно";
    private final static String once = "<одноразовая> ";

    public OnceTask(String heading, String description, TypeOfTask typeOfTask, LocalDate time1) {
        super(heading, description, typeOfTask);
        this.time1 = time1;
    }

    public OnceTask(String heading, String description, TypeOfTask typeOfTask, LocalDateTime time) {
        super(heading, description, typeOfTask);
        this.time = time;
    }

    @Override
    public void setDate(LocalDateTime time){
        if (time.isBefore(LocalDateTime.now())) throw new RuntimeException(exception);else this.time = time;

    }

    @Override
    public LocalDateTime getNextDate() {
        return null;
    }

    public LocalDateTime getTime(){
        return time;
    }
    @Override
    public String toString() {
        return once + getHeading()+ " " + getDescription() + " " + time;

    }
}

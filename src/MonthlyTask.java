import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task implements NextTask{
    private LocalDateTime time;
    private LocalDate time1;
    private final static String monthly = "<ежемесячная> ";
    private final static String exception = "Время выполнения задачи выбрано некорректно";

    public MonthlyTask(String heading, String description, TypeOfTask typeOfTask, LocalDate time1) {
        super(heading, description, typeOfTask);
        this.time1 = time1;
    }

    public MonthlyTask(String heading, String description, TypeOfTask typeOfTask, LocalDateTime time) {
        super(heading, description, typeOfTask);
        this.time = time;
    }


    @Override
    public void setDate(LocalDateTime time){
        if (time.isBefore(LocalDateTime.now())) throw new RuntimeException(exception);else this.time = time;
    }
    @Override
    public LocalDateTime getNextDate() {
        return time.plusMonths(1);
    }
    @Override
    public LocalDateTime getTime(){
        return time;
    }
    @Override
    public String toString() {
        return monthly  + getHeading()+ " " + getDescription() + " " + time;
    }
}


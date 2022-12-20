import java.time.LocalDateTime;
import java.util.Objects;

public class Task implements NextTask{



    public enum TypeOfTask {WORKTASK, PERSONALTASK}

    public enum NumberOfTasks {ONETIME, DAILY, WEEKLY, MONTHLY, ANNUAL}

    private String heading;
    private String description;
    private TypeOfTask typeOfTask;
    private NumberOfTasks numberOfTasks;
    private LocalDateTime localDateTime;
    private static int id;




    public Task(String heading, String description, TypeOfTask typeOfTask, NumberOfTasks numberOfTasks, LocalDateTime localDateTime) {
        if (heading == null && !heading.isEmpty() && !heading.isBlank()) {
            throw new RuntimeException("Поле пустое");
        } else {
            this.heading = heading;
        }
        if (description == null && !heading.isEmpty() && !heading.isBlank()) {
            throw new RuntimeException("Поле пустое");
        } else {
            this.description = description;
        }
        if (typeOfTask == null && !heading.isEmpty() && !heading.isBlank()) {
            throw new RuntimeException("Поле пустое");
        } else {
            this.typeOfTask = typeOfTask;
        }
        if (numberOfTasks == null && !heading.isEmpty() && !heading.isBlank()) {
            throw new RuntimeException("Поле пустое");
        } else {
            this.numberOfTasks = numberOfTasks;
        }
        if (localDateTime == null && !heading.isEmpty() && !heading.isBlank()) {
            throw new RuntimeException("Поле пустое");
        } else {
            this.localDateTime = localDateTime;
            this.id = id;
        }
    }
    public Task() {
    }
    @Override
    public LocalDateTime getNextDay() {
        return localDateTime.plusDays(1);
    }

    @Override
    public LocalDateTime getNextWeek() {
        return localDateTime.plusWeeks(1);
    }

    @Override
    public LocalDateTime getNextMonth() {
        return localDateTime.plusMonths(1);
    }

    @Override
    public LocalDateTime getNextYear() {
        return localDateTime.plusYears(1);
    }

    public String getHeading() {
        return heading;
    }

    public int getId() {
        return id++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }


    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }

    public void setTypeOfTask(TypeOfTask typeOfTask) {
        this.typeOfTask = typeOfTask;
    }

    public NumberOfTasks getNumberOfTasks() {
        return numberOfTasks;
    }

    public void setNumberOfTasks(NumberOfTasks numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(heading, task.heading) && Objects.equals(description, task.description) && typeOfTask == task.typeOfTask && numberOfTasks == task.numberOfTasks && Objects.equals(localDateTime, task.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heading, description, typeOfTask, numberOfTasks, localDateTime);
    }

    @Override
    public String toString() {
        return "Задачи{" +
                "Заголовок='" + heading + '\'' +
                "Описание ='" + description + '\'' +
                ",Тип задачи =" + typeOfTask +
                ", Повторяемость " + numberOfTasks +
                ", Дата и время " + localDateTime;
    }
}


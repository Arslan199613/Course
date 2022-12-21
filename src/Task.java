import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task implements NextTask{



    public enum TypeOfTask {WORKTASK, PERSONALTASK}

    public enum NumberOfTasks {ONETIME, DAILY, WEEKLY, MONTHLY, ANNUAL}

    private String heading;
    private String description;
    private TypeOfTask typeOfTask;
    private NumberOfTasks numberOfTasks;
    private LocalDateTime localDateTime;
    private static int id;
    private static int count = 1;
    private boolean deleted;
    

    public Task(String heading, String description, TypeOfTask typeOfTask) {
        setHeading(heading);
        setDescription(description);
        this.numberOfTasks = getNumberOfTasks();
        this.typeOfTask = typeOfTask;
        setDeleted(false);
        this.id = count++;
        }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public LocalDateTime getTime() {
        return localDateTime;
    }
    public Task() {
    }

    public String getHeading() {
        return heading;
    }

    public int getId() {
        return id;
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
    public String getInfo() {
        return getHeading() + " " + getDescription();
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

    public abstract void setDate(LocalDateTime time);

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


import java.time.LocalDateTime;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Task task = new Task("Матч", "Посмотреть матч", Task.TypeOfTask.PERSONALTASK, Task.NumberOfTasks.ONETIME, LocalDateTime.of(2022, 12, 18, 18, 00));
        Task task1 = new Task("Зарядка", "Каждое утро нужно делать зарядку", Task.TypeOfTask.PERSONALTASK, Task.NumberOfTasks.DAILY, LocalDateTime.of(2022, 12, 18, 18, 00));
        Task task2 = new Task("Отчёт", "Сдавать отчёт начальству", Task.TypeOfTask.WORKTASK, Task.NumberOfTasks.WEEKLY, LocalDateTime.of(2022, 12, 18, 18, 00));
        Task task3 = new Task("Кино", "Сходить в кино", Task.TypeOfTask.PERSONALTASK, Task.NumberOfTasks.MONTHLY, LocalDateTime.of(2022, 12, 18, 18, 00));
        Task task4 = new Task("День рождение", "Отправздновать свой день рождения", Task.TypeOfTask.PERSONALTASK, Task.NumberOfTasks.ANNUAL, LocalDateTime.of(2022, 12, 18, 18, 00));


        ServisClass servisClass = new ServisClass();
        servisClass.task.put(task.getId(), task);
        servisClass.task.put(task1.getId(), task1);
        servisClass.task.put(task2.getId(), task2);
        servisClass.task.put(task3.getId(), task3);
        servisClass.task.put(task4.getId(), task4);

        System.out.print(servisClass.task);

        servisClass.addTask();
        servisClass.getTask();
        servisClass.removeTask();

        servisClass.nextTime(LocalDateTime.of(2022, 12, 19, 9, 00));

    }
}
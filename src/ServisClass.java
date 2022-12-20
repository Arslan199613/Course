import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class ServisClass extends Task implements NextTask {
    Map<Integer, Task> nextDayMap = new HashMap<>();
    Map<Integer, Task> task = new HashMap<>();


    public void addTask() {
        task.put(getId(), new Task("Планерка", "Планерка по понедельникам",
                Task.TypeOfTask.WORKTASK, Task.NumberOfTasks.WEEKLY,
                LocalDateTime.of(2022, 12, 18, 9, 00)));
        System.out.println(task);

    }

    public void getTask() {
        System.out.println(task.get(5));
    }

    public void removeTask() {
        System.out.println(task.remove(5));
    }

    public void nextTime(LocalDateTime localDateTime) {
        for (Map.Entry<Integer, Task> map1 : task.entrySet()) {
            if (map1.getValue().getLocalDateTime().equals(localDateTime)) {
                nextDayMap.put(map1.getKey(), map1.getValue());
                System.out.println(map1);
                if (map1.getValue().getNumberOfTasks().equals(NumberOfTasks.DAILY)) {
                    map1.getValue().setLocalDateTime(map1.getValue().getNextDay());
                }
                if (map1.getValue().getNumberOfTasks().equals(NumberOfTasks.WEEKLY)) {
                    map1.getValue().setLocalDateTime(map1.getValue().getNextDay());
                }
                if (map1.getValue().getNumberOfTasks().equals(NumberOfTasks.MONTHLY)) {
                    map1.getValue().setLocalDateTime(map1.getValue().getNextDay());
                }
                if (map1.getValue().getNumberOfTasks().equals(NumberOfTasks.ANNUAL)) {
                    map1.getValue().setLocalDateTime(map1.getValue().getNextDay());

                }
            }
        }
    }
}

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class NewTaskBook {
    private final Map<Integer, Task> newTaskBook;
    private static final String personal = "<личная>";
    private static final String working = "<рабочая>";

    public NewTaskBook() {
        this.newTaskBook = new HashMap<>();
    }

    private static Scanner scanner() {
        return new Scanner(System.in);
    }

    private Task newTask() {
        try {
            try {
                Scanner scanner = scanner();
                System.out.println("Выберите тип задачи: 1." + personal + "; или будет выбран тип " + working);
                int typeTask = scanner.nextInt();
                Task.TypeOfTask typeOfTask;
                if (typeTask != 1) typeOfTask = Task.TypeOfTask.WORKTASK;
                else typeOfTask = Task.TypeOfTask.PERSONALTASK;
                System.out.println("Как часто задача будет выполняться: 1. ежедневно; 2. еженедельно; 3. ежемесячно; 4. ежегодично. Или задача выполнится всего один раз.");
                int frequency = scanner.nextInt();
                System.out.println("Введите заголовок");
                String heading = scanner().nextLine();
                System.out.println("Введите описание");
                String description = scanner().nextLine();
                System.out.println("Введите дату выполнения");
                int date = scanner.nextInt();
                if (date > 0) {
                    System.out.println("Задача добавлена!");
                }else {
                    System.out.println("Задача не добавлена");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } finally {
        }
        return null;
    }

    public void createNewTask() {
        Task task = newTask();
        if (task != null) newTaskBook.put((task.getId()), task);

    }

    public void findTasksForDay() {
        System.out.println("Введите дату");
        try {
            try {
                Scanner scanner = scanner();
                LocalDate time = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                Map<Integer, Task> tasksForDay = new HashMap<>();
                for (Map.Entry<Integer, Task> pair : newTaskBook.entrySet()) {
                    if (pair.getValue().getTime().toLocalDate().isAfter(time)) continue;
                    if (pair.getValue().getClass().equals(DailyTask.class)) {
                        for (int i = 0; i < tasksForDay.size(); i++) {
                            if (pair.getValue().getTime().toLocalDate().isEqual(pair.getValue().getTime().toLocalDate().plusDays(i))) {
                                tasksForDay.put(pair.getKey(), pair.getValue());
                            }
                        }
                    } else if (pair.getValue().getClass().equals(WeeklyTask.class)) {
                        for (int i = 0; i < tasksForDay.size(); i++) {
                            if (time.isEqual(pair.getValue().getTime().toLocalDate().plusWeeks(i))) {
                                tasksForDay.put(pair.getKey(), pair.getValue());
                            }
                        }
                    } else if (pair.getValue().getClass().equals(MonthlyTask.class)) {
                        for (int i = 0; i < tasksForDay.size(); i++) {
                            if (time.isEqual(pair.getValue().getTime().toLocalDate().plusMonths(i))) {
                                tasksForDay.put(pair.getKey(), pair.getValue());
                            }
                        }
                    } else if (pair.getValue().getClass().equals(YearlyTask.class)) {
                        for (int i = 0; i < tasksForDay.size(); i++) {
                            if (time.isEqual(pair.getValue().getTime().toLocalDate().plusYears(i))) {
                                tasksForDay.put(pair.getKey(), pair.getValue());
                            }
                        }
                    } else if (pair.getValue().getClass().equals(OnceTask.class)) {
                        if (time.isEqual(pair.getValue().getTime().toLocalDate())) {
                            tasksForDay.put(pair.getKey(), pair.getValue());
                        }
                    }
                }
                for (Map.Entry<Integer, Task> pair : tasksForDay.entrySet())
                    System.out.println(pair.getValue().getInfo());
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели некорректное значение даты");
            }
        } catch (DateTimeException e) {
            System.out.println("Вы ввели некорректное значение даты");
        }
    }


    private Task findTask(Integer id) {
        return newTaskBook.get(id);
    }

    public Task taskForDelete() {
        try {
            System.out.println("Введите id задачи, которую вы хотите удалить");
            return findTask(scanner().nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели некорректное значение, попробуйте ввести повторно");
        }
        return taskForDelete();
    }

    public void removeTask(Integer id) {
        newTaskBook.remove(id);
    }
}




import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Diary();
    }
        public static void Diary(){

        NewTaskBook newTaskBook = new NewTaskBook();
        RemoveTaskBook removeTaskBook = new RemoveTaskBook();
            try (Scanner scanner = new Scanner(System.in)) {
                label:
                while (true) {
                    printMenu();
                    System.out.print("Выберите пункт меню: ");
                    if (scanner.hasNextInt()) {
                        int menu = scanner.nextInt();
                        switch (menu) {
                            case 1:
                                newTaskBook.createNewTask();
                                break;
                            case 2:
                                removeTaskBook.removeFromNewTaskBook(newTaskBook);
                                break;
                            case 3:
                                newTaskBook.findTasksForDay();
                                break;
                            case 0:
                                break label;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        private static void inputTask(Scanner scanner) {
            System.out.print("Введите название задачи: ");
            String taskName = scanner.next();


        }

        private static void printMenu() {
            System.out.println(

                    "1. Добавить задачу \n" +
                            "2. Удалить задачу \n" +
                            "3. Получить задачу на указанный день \n" +
                            "0.Выход \n");

        }
    }

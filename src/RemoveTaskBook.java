import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RemoveTaskBook {
    private final Map<Integer, Task> removeTaskBook;
    public RemoveTaskBook() {
        this.removeTaskBook = new HashMap<>();
    }
    public void removeFromNewTaskBook(NewTaskBook newTaskBook){
        try {
            Task task = newTaskBook.taskForDelete();
            task.setHeading("Задача удалена! " + task.getHeading());
            removeTaskBook.put(task.getId(), task);
            newTaskBook.removeTask(task.getId());
            System.out.println("Задача удалена");
        }catch (NullPointerException e){
            System.out.println("Выбрали несуществующий id");
        }
    }
    @Override
    public String toString() {
        return removeTaskBook.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoveTaskBook removeTaskBook1 = (RemoveTaskBook) o;
        return Objects.equals(removeTaskBook, removeTaskBook1.removeTaskBook);
    }
    @Override
    public int hashCode() {
        return Objects.hash(removeTaskBook);
    }
}


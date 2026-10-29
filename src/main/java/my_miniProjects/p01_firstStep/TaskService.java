package my_miniProjects.p01_firstStep;

import java.util.List;

//Сервис — это «мозг» нашего приложения. Здесь живет бизнес-логика.
public class TaskService {
    // 1. Зависимость (Dependency Injection)
    // Сервису нужен Репозиторий для работы, поэтому мы передаем его через конструктор.

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    // 2. Метод добавления задачи (с проверкой!)
    public void addTask(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Ошибка: название задачи не может быть пустым!");
            return;
        }

        Task createdTask = repository.save(title);
        System.out.println("Задача успешно добавлена: " +  createdTask.getTitle());
    }

    // 3. Метод вывода всех задач
    public void showAllTasks() {
        List<Task> tasks = repository.findAll();

        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст! Необходимо что-то запланировать!");
            return;
        }

        System.out.println("Ваши задачи:");
        for (Task task : tasks) {
            System.out.println(task); // Тут сработает наш красивый toString() из класса Task
        }
    }

    // 4. Метод выполнения задачи
    public void completeTask(int id) {
        Task task = repository.findById(id);

        if (task == null) {
            System.out.println("Ошибка: задача с ID: " + id + " не найдена!");
            return;
        }

        task.markAsCompleted();
        System.out.println("Задача выполнена: " + task.getTitle());
    }

    // 5. Метод удаления задачи
    public void deleteTask(int id) {
        boolean isDeleted = repository.deleteById(id);

        if (isDeleted) {
            System.out.println("Задача с ID: " + id + "успешна удалена");
        } else {
            System.out.println("❌ Ошибка: Задача с ID " + id + " не найдена.");
        }
    }
}

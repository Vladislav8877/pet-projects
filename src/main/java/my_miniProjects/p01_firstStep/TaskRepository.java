package my_miniProjects.p01_firstStep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Репозиторий — это единственный класс, который имеет право «трогать» базу данных.
public class TaskRepository {
    // 1. Наша "база данных".
    // Она private, чтобы никто не мог удалить данные в обход правил Репозитория.
    private Map<Integer, Task> database = new HashMap<>();

    // 2. Автоматический генератор ID (имитация AUTO_INCREMENT из баз данных).
    private int sequenceId = 1;

    // 3. Метод для сохранения новой задачи
    public Task save(String title) {
        // Создаем новую задачу, выдаем ей текущий свободный ID
        Task newTask = new Task(sequenceId, title);
        // Кладем в нашу мапу (ключ = ID, значение = объект задачи)
        database.put(sequenceId, newTask);
        // Увеличиваем счетчик, чтобы следующая задача получила ID на 1 больше
        sequenceId++;
        // Возвращаем созданную задачу обратно (чтобы показать её пользователю)
        return newTask;
    }

    // 4. Метод получения всех задач
    public List<Task> findAll() {
        // Берем все значения (values) из Map и упаковываем их в удобный List
        return new ArrayList<>(database.values());
    }

    // 5. Метод поиска конкретной задачи по её ID
    public Task findById(int id) {
        // Метод get() у Map работает мгновенно.
        // Если задачи с таким ID нет, он просто вернет null.
        return database.get(id);
    }

    // 6. Метод удаления задачи по ID
    public boolean deleteById(int id) {
        // Метод remove() возвращает удаленный объект, если он был, или null, если такого ключа не было.
        // Мы возвращаем true, если удаление прошло успешно (объект был).
        return database.remove(id) != null;
    }
}

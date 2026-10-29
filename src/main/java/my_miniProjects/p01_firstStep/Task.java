package my_miniProjects.p01_firstStep;

import java.time.LocalDateTime;

//Этот класс — просто контейнер для описания одной-единственной задачи.
public class Task {
    // 1. Поля (характеристики) задачи.
    private int id; // Уникальный номер задачи (как номер паспорта)
    private String title; // Текст самой задачи
    private boolean isCompleted; // Статус: выполнена (true) или в процессе (false)
    private LocalDateTime createAt; // Точная дата и время создания задачи

    // 2. Конструктор.
    // Сюда мы передаем только то, что реально нужно при СОЗДАНИИ новой задачи.
    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.isCompleted = false;
        this.createAt = LocalDateTime.now();
    }

    // 3. Геттеры. Позволяют другим классам безопасно ПРОЧИТАТЬ данные задачи.
    public int getId() {return id;}
    public String getTitle() {return title;}
    public boolean isCompleted() {return isCompleted;}

    // 4. Сеттеры / Методы логики.
    public void markAsCompleted() {this.isCompleted = true;}

    // 5. Переопределяем toString()
    @Override
    public String toString() {
        String status = isCompleted ? "[X]" : "[ ]";
        return String.format("%s %d. %s (создано: %s)",status, id, title, createAt);
    }
}
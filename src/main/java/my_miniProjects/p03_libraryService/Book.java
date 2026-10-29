package my_miniProjects.p03_libraryService;

public class Book {
    private final int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        Validator.checkNumber(id, "ID книги");
        Validator.checkString(title, "название книги");
        Validator.checkString(author, "автор книги");

        this.id = id;
        this.title = title;
        this.author = author;
        isAvailable = true;
    }

    public void borrowBook() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        String status = isAvailable ? "В наличии" : "Выдан читателю";

        return String.format("ID книги: %d || Название книги: %s || Автор книги: %s || Статус: %s",
                id, title, author, status);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
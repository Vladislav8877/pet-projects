package my_miniProjects.p03_libraryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryRepository {
    private final Map<Integer, Book> books = new HashMap<>();
    private int sequenceId = 1;

    public Book save(String title, String author) {
        Book book = new Book(sequenceId++, title, author);
        books.put(book.getId(), book);
        return book;
    }

    public Book findBookById(int id) {
        return books.get(id);
    }

    public List<Book> findAllBooks() {
        return new ArrayList<>(books.values());
    }
}
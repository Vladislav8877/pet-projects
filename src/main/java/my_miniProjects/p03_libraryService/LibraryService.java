package my_miniProjects.p03_libraryService;

import java.util.List;

public class LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void addNewBook(String title, String author) {
        Validator.checkString(title,"название книги");
        Validator.checkString(author,"автор книги");

        Book newBook = libraryRepository.save(title, author);
        System.out.println("Книга успешна добавлена в библиотеку!");
    }

    public void showAllAvailableBooks() {
        List<Book> allAvailableBooks = libraryRepository.findAllBooks();

        if (allAvailableBooks.isEmpty()) {
            System.out.println("В библиотеки пока нету ни одной книги!");
            return;
        }

        System.out.println("Доступные книги для выдачи:");
        boolean foundAvailable = false;

        for (Book book : allAvailableBooks) {
            if (book.isAvailable()) {
                System.out.println(book);
                foundAvailable = true;
            }
        }

        if(!foundAvailable) {
            System.out.println("В сожалению сейчас все книги выданы читателям!");
        }
    }

    public void borrowBook(int id) {
        Validator.checkNumber(id, "ID книги");

        Book book = libraryRepository.findBookById(id);
        if (book == null) {
            throw new ItemNotFoundException("Ошибка: книга с ID:" + id + " не найдена!");
        } else if (!book.isAvailable()) {
            throw new IllegalArgumentException("Ошибка: данная книга сейчас находится у другого читателя");
        } else {
            book.borrowBook();
            System.out.println(book + " -> забронирована вами!");
        }
    }

    public void returnBook(int id) {
        Validator.checkNumber(id,"ID книги");

        Book book = libraryRepository.findBookById(id);
        if (book == null) {
            throw new ItemNotFoundException("Ошибка: книга с ID:" + id + " не найдена!");
        } else if (book.isAvailable()) {
            throw new IllegalArgumentException("Ошибка: книга не была выдана, вы не можете её вернуть!");
        } else {
            book.returnBook();
            System.out.println(book + " -> спасибо что вы с нами! До новых встреч!");
        }
    }
}
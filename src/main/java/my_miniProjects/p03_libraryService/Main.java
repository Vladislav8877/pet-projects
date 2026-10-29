package my_miniProjects.p03_libraryService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryRepository repository = new LibraryRepository();
        LibraryService service = new LibraryService(repository);
        Scanner sc = new Scanner(System.in);

        System.out.println("Добро пожаловать!");

        while (true) {
            System.out.println("\n=================================");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Показать доступные книги");
            System.out.println("3. Взять книгу");
            System.out.println("4. Вернуть книгу");
            System.out.println("0. Выход");
            System.out.println("=================================");
            System.out.print("👉 Выберите действие (введите цифру): ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Введите название книги: ");
                        String title = sc.nextLine();
                        System.out.print("Введите автора книги: ");
                        String author = sc.nextLine();
                        service.addNewBook(title, author);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    service.showAllAvailableBooks();
                    break;
                case "3":
                    try {
                        System.out.print("Введите ID книги: ");
                        int bookId = Integer.parseInt(sc.nextLine());
                        service.borrowBook(bookId);
                    } catch (NumberFormatException e) {
                        System.out.print("Ошибка: неверный ввод, попробуйте еще раз!");
                    } catch (ItemNotFoundException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    try {
                        System.out.print("Введите ID книги: ");
                        int bookId = Integer.parseInt(sc.nextLine());
                        service.returnBook(bookId);
                    } catch (NumberFormatException e) {
                        System.err.println("Ошибка: неверный ввод, попробуйте еще раз!");
                    } catch (ItemNotFoundException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "0":
                    System.out.println("До свидания!");
                    sc.close();
                    return;
                default:
                    System.out.println("Некорректный ввод! Попробуйте еще раз!");
            }
        }
    }
}
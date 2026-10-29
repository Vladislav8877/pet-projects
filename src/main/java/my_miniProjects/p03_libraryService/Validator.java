package my_miniProjects.p03_libraryService;

public class Validator {
    public static void checkString(String name, String fieldName) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ошибка: поле \"" + fieldName + "\" не может быть пустым!");
        }
    }

    public static void checkNumber(int number, String fieldName) {
        if (number <= 0) {
            throw new IllegalArgumentException("Ошибка: поле \"" + fieldName + "\" не может быть отрицательным");
        }
    }
}
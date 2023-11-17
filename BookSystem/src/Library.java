import java.util.ArrayList;

public class Library {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void AddBook(Book book) {
        books.add(book);
    }

    public static void RemoveBook(Book book) {
        books.remove(book);
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }
}

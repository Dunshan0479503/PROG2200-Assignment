import java.util.Date;

public interface LibraryUser {
    void borrowBook(Book book);
    void returnBook(Book book);
    void setDueDate(Book book, Date dueDate);
    void checkDueDatesAndNotify();
}

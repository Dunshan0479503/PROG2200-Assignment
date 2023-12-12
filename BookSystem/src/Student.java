import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student implements LibraryUser {
    private List<Book> borrowedBooks = new ArrayList<>();

    private NotificationService notificationService;

    public Student(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println("Student borrow book name: " + book.getTitle());

    }

    @Override
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public void setDueDate(Book book, Date dueDate) {
        book.setDueDate(dueDate);
        System.out.println("Due date: " + dueDate + "\n");
    }

    public void checkDueDatesAndNotify() {
        Date today = new Date();
        for (Book book : borrowedBooks) {
            if (book.getDueDate().compareTo(today) < 0) {
                String message = book.getTitle() + "\n" + "Dou Date:" + book.getDueDate();
                notificationService.sendNotification("\n" + message);
            }
        }
    }
}

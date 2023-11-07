import java.util.Date;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Create several book categories
        Category.Generic technical = new Category.Generic("Technical");
        Category.Generic biographies = new Category.Generic("Biographies");
        Category.Generic memoirs = new Category.Generic("Memoirs");

        // Create some books
        Book steveJobs = new Book("Steve Jobs", "Simon & Schuster; First Edition", "9780747532699", new Date(2011, 10, 12));
        Book elonMusk  = new Book("Elon Musk", " Simon & Schuster", "9780618640157", new Date(2023,12,12));

        // Add categories to books
        steveJobs.addCategory(technical);
        steveJobs.addCategory(biographies);

        elonMusk.addCategory(biographies);
        elonMusk.addCategory(memoirs);

        // Adding books to the library
        Library.AddBook(steveJobs);
        Library.AddBook(elonMusk);

        // Print the books in the library and their classification
        printBooksInLibrary();

        // Remove a book from the library
        Library.RemoveBook(elonMusk);

        // Print books from the library again
        printBooksInLibrary();

        // Create students and teachers and assign them notification services
        Student student = new Student(new SMSPushNotificationService());
        Teacher teacher = new Teacher(new EmailNotificationService());

        // Student: borrowed Steve Jobs book, overdue
        student.borrowBook(steveJobs);
        student.setDueDate(steveJobs, getDate(2023, 10, 17));  // assuming current year is 2023

        // Teacher: Check Out Book Elon Musk, No Due Date
        teacher.borrowBook(elonMusk);
        teacher.setDueDate(elonMusk, getDate(2023, 11, 30)); // assuming current year is 2023

        // Check for overdue books and send notifications when they are overdue
        student.checkDueDatesAndNotify();
        teacher.checkDueDatesAndNotify();
    }

    public static void printBooksInLibrary() {
        System.out.println("Books in the library:");
        for (Book book : Library.getBooks()) {
            System.out.println("- " + book.getTitle());
            for (Category category : book.getCategory()) {
                System.out.println("  - Category: " + category.getCategoryName());
            }
        }
    }

    public static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day); // Note: month is 0-based in Calendar
        return cal.getTime();
    }
}
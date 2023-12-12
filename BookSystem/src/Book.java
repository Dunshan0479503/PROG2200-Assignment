import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Book {
    private final String title;
    private final String author;
    private final String ISBN;
    private Date dueDate;
    private List<Category> categoryList;

    public Book(String title, String author, String ISBN, Date dueDate) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.dueDate = new Date(dueDate.getTime());
        this.categoryList = new ArrayList<>();
    }

    public void addCategory(Category category) {
        this.categoryList.add(category);
    }

    public List<Category> getCategory() {
        return categoryList;
    }

    public void checkDownloads() {
        System.out.println("Reading " + title);
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = new Date(dueDate.getTime());
    }

    public String getTitle() {
        return title;
    }
}

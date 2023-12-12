import java.util.Date;

public class eBook extends Book {
    private String downloadLink;

    public eBook(String title, String author, String ISBN, Date dueDate, String downloadLink) {
        super(title, author, ISBN,dueDate);
        this.downloadLink = downloadLink;
    }

    public void download() {
        System.out.println("Downloading eBook from: " + downloadLink);
    }

    @Override
    public void checkDownloads() { // Requirements to confirm if the book is downloaded
        download();
        super.checkDownloads();
    }
}

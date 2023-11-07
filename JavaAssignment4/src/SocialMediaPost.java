import java.util.Date;

public class SocialMediaPost {
    private final User author;
    private final String content;
    private  Date timestamp;

    public SocialMediaPost(User author, String content, Date timestamp) {
        this.author = author;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Add getters here
    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Post by " + author.getUsername() + " at " + timestamp + ": " + content;
    }
}

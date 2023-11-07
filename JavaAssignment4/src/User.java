import java.util.Date;
import java.util.Observable;

public class User extends Observable {
    private final String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void postUpdate(String content, Date timestamp) {
        SocialMediaPost post = new SocialMediaPost(this, content, timestamp);
        setChanged();
        notifyObservers(post);
    }
}

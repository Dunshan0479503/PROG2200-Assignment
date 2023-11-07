import java.util.Observable;
import java.util.Observer;

public class UserFollower implements Observer {
    private final String username;

    public UserFollower(String username) {
        this.username = username;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof SocialMediaPost) {
            SocialMediaPost post = (SocialMediaPost) arg;
            System.out.println(username + " Received notification of updates to. " + post);
        }
    }
}

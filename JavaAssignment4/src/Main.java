import java.util.Date;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Aaron");
        UserFollower follower1 = new UserFollower("follower1");
        UserFollower follower2 = new UserFollower("follower2");

        // User1 gets new followers
        user1.addObserver(follower1);
        user1.addObserver(follower2);

        // User1 posts an update, and both followers get notified
        user1.postUpdate("This is my new post.", new Date());
    }
}

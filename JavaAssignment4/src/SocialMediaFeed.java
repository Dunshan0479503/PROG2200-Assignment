import java.util.Date;

public class SocialMediaFeed {

    public static void main(String[] args) {
        User user1 = new User("Aaron");
        UserFollower follower1 = new UserFollower("follower1");
        user1.addObserver(follower1);

        user1.postUpdate("this is my new post", new Date());
    }

}

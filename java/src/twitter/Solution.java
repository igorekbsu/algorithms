package twitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.postTweet(1, 5);
        t.unfollow(1, 1);
        System.out.println(t.getNewsFeed(1));
    }

    static class Twitter {
        static int TIME = 0;
        Map<Integer, User> users = new HashMap<>();

        public void postTweet(int userId, int tweetId) {
            users.putIfAbsent(userId, new User(userId));
            User user = users.get(userId);
            Tweet tweet = new Tweet(tweetId);
            tweet.next = user.head;
            user.head = tweet;
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> tweets = new LinkedList<>();
            User u = users.get(userId);
            if (u != null && !u.users.isEmpty()) {
                PriorityQueue<Tweet> q = new PriorityQueue<>(u.users.size(), (o1, o2) -> Integer.compare(o2.time, o1.time));
                for (int id : u.users)
                    if (users.get(id).head != null)
                        q.add(users.get(id).head);
                for (int i = 0; i < 10 && !q.isEmpty(); i++) {
                    Tweet t = q.poll();
                    tweets.add(t.id);
                    if (t.next != null)
                        q.add(t.next);
                }
            }
            return tweets;
        }

        public void follow(int followerId, int followeeId) {
            users.putIfAbsent(followerId, new User(followerId));
            users.putIfAbsent(followeeId, new User(followeeId));
            users.get(followerId).users.add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
                if (followerId != followeeId && users.containsKey(followerId))
                users.get(followerId).users.remove(followeeId);
        }

        class User {
            int id;
            Set<Integer> users = new HashSet<>();
            Tweet head;

            public User(int userId) {
                id = userId;
                users.add(id);
            }
        }

        class Tweet {
            int time, id;
            Tweet next;

            public Tweet(int id) {
                this.id = id;
                time = TIME++;
            }
        }
    }
}

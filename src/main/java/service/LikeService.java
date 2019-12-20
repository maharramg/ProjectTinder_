package service;

import additional.Like;
import additional.User;
import dao.LikesDAO;
import dao.UsersDAO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LikeService {
    private UsersDAO users;
    private LikesDAO likes;
    private List<Integer> userIds;
    private boolean liked;
    private int id;

    public int getLocalId() {
        return id;
    }

    public LikeService() {
        liked = false;
        likes = new LikesDAO();
        users = new UsersDAO();
        userIds = users.getAllId();
    }

    public void like(int user_liked) {
        liked = true;
        Like like = new Like(id, user_liked);
        if (!likes.getDatabase().contains(like))
            likes.add(like);
    }

    public User getFirst() {
        return getUserNotMe().collect(Collectors.toList()).get(0);
    }

    public Stream<User> getUserNotMe() {
        return users.stream()
                .filter(oneUser -> oneUser.getId() != id);
    }

    public boolean isLast() {
        return userIds.isEmpty();
    }

    public boolean isLiked() {
        return liked;
    }

    public User getNext(int user_liked) throws IndexOutOfBoundsException {
        userIds.remove(Integer.valueOf(user_liked));
        if (!isLast())
            return users.get(userIds.get(0));
        else if (isLiked())
            throw new IndexOutOfBoundsException();
        else userIds = users.getAllId();
        return null;
    }

    public void setLocalId(int id) {
        this.id = id;
    }
}


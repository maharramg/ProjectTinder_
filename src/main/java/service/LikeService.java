package service;

import additional.Like;
import additional.User;
import dao.LikeDAO;
import dao.UserDAO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LikeService {
    private UserDAO users;
    private LikeDAO likes;
    private List<Integer> userIds;
    private boolean liked;
    private int id;

    public int getLocalId() {
        return id;
    }

    public LikeService() {
        liked = false;
        likes = new LikeDAO();
        users = new UserDAO();
        userIds = users.getAllId();
    }

    public void like(int user_to) {
        liked = true;
        Like like = new Like(id, user_to);
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

    public User getNext(int user_to) throws IndexOutOfBoundsException {
        userIds.remove(Integer.valueOf(user_to));
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


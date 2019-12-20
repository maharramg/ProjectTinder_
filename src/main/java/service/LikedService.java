package service;

import additional.Like;
import additional.User;
import dao.LikesDAO;
import dao.UsersDAO;

import java.util.List;
import java.util.stream.Collectors;

public class LikedService {
    private LikesDAO likes;
    private UsersDAO users;

    public LikedService() {
        users = new UsersDAO();
        likes = new LikesDAO();
    }

    public List<User> getLikedUsers(int localId) {
        List<Like> likedUserIds = getLikedUserIds(localId);
        return users.stream()
                .filter(oneUser -> likedUserIds.contains(new Like(localId, oneUser.getId())))
                .collect(Collectors.toList());
    }

    public List<Like> getLikedUserIds(int localId) {
        likes.read();
        return likes.stream()
                .filter(oneLike -> oneLike.getUser_likes() == localId)
                .collect(Collectors.toList());
    }

}

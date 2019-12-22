package service;

import additional.Like;
import additional.User;
import dao.LikeDAO;
import dao.UserDAO;

import java.util.List;
import java.util.stream.Collectors;

public class LikedService {
    private LikeDAO likes;
    private UserDAO users;

    public LikedService() {
        users = new UserDAO();
        likes = new LikeDAO();
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
                .filter(oneLike -> oneLike.getUser_from() == localId)
                .collect(Collectors.toList());
    }

}

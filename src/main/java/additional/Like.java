package additional;

import java.util.Objects;

public class Like {
    private int id;
    private int user_from;
    private int user_to;

    public Like(int user_from, int user_to) {
        this.user_from = user_from;
        this.user_to = user_to;
    }

    public Like(int id, int user_from, int user_to) {
        this.id = id;
        this.user_from = user_from;
        this.user_to = user_to;
    }

    public int getUser_from() {
        return user_from;
    }

    public int getUser_to() {
        return user_to;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Like)) return false;
        Like like = (Like) o;
        return user_from == like.user_from &&
                user_to == like.user_to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_from, user_to);
    }

    @Override
    public String toString() {
        return "Like{" +
                "user_from=" + user_from +
                ", user_to=" + user_to +
                '}';
    }
}

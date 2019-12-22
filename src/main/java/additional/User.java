package additional;

import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String gender;
    private String imgURL;

    public User(int id, String username, String name, String surname, String password, String email, String gender, String imgURL) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.imgURL = imgURL;
    }

    public User(String username, String name, String surname, String password, String email, String gender, String imgURL) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.imgURL = imgURL;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public String getImgURL() {
        return imgURL;
    }

    public boolean checkEqual(User user) {
        return username.equals(user.getUsername()) &&
                password.equals(user.getPassword());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(imgURL, user.imgURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, surname, password, email, gender, imgURL);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}

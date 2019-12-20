package additional;

import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String name;
    private String surname;
    private String password;
    private String gender;
    private String imgURL;

    public User(int id, String username, String name, String surname, String password, String gender, String imgURL) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.gender = gender;
        this.imgURL = imgURL;
    }

    public User(String username, String name, String surname, String password, String gender, String imgURL) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.gender = gender;
        this.imgURL = imgURL;
    }

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getImgURL() {
        return imgURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                username.equals(user.username) &&
                name.equals(user.name) &&
                surname.equals(user.surname) &&
                password.equals(user.password) &&
                gender.equals(user.gender) &&
                imgURL.equals(user.imgURL);
    }

    public boolean checkEqual(User user)
    {
        return username.equals(user.getUsername()) &&
                password.equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, surname, password, gender, imgURL);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}

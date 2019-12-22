package service;

import additional.DbConnection;
import additional.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterService {
    public void register(User user) {
        try {
            final String SQLQ = "INSERT INTO users(email, password, gender, imgurl, name, surname, username) VALUES (?,?,?,?,?,?,?)";
            Connection connection = DbConnection.getConnection();
            PreparedStatement insertUser = connection.prepareStatement(SQLQ);
            insertUser.setString(1, user.getEmail());
            insertUser.setString(2, user.getPassword());
            insertUser.setString(3, user.getGender());
            if (user.getImgURL().equals(""))
                insertUser.setString(4, "https://i7.pngguru.com/preview/178/419/741/computer-icons-avatar-login-user-avatar.jpg");
            else
                insertUser.setString(4, user.getImgURL());
            insertUser.setString(5, user.getName());
            insertUser.setString(6, user.getSurname());
            insertUser.setString(7, user.getUsername());
            insertUser.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}

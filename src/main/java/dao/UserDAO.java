package dao;

import additional.DbConnection;
import additional.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserDAO implements DAO<User> {
    private List<User> users;

    public UserDAO() {
        read();
    }

    @Override
    public void read() {
        users = new LinkedList<>();
        try {
            Connection conn = DbConnection.getConnection();
            final String SQLQ = "SELECT * FROM users";
            PreparedStatement preparedStatement = conn.prepareStatement(SQLQ);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("name"), resultSet.getString("surname"),
                        resultSet.getString("password"), resultSet.getString("email"),
                        resultSet.getString("gender"), resultSet.getString("imgurl")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getDatabase() {
        return users;
    }


    @Override
    public List<Integer> getAllId() {
        read();
        List<Integer> result = new LinkedList<>();
        users.forEach(user -> result.add(user.getId()));
        return result;
    }

    @Override
    public void clear() throws SQLException {
        Connection connection = DbConnection.getConnection();
        final String SQLQ = "DELETE FROM users";
        PreparedStatement preparedStatement = connection.prepareStatement(SQLQ);
        preparedStatement.executeUpdate();
        users = new LinkedList<>();
    }

    @Override
    public Integer size() {
        return users.size();
    }

    @Override
    public void add(User user) {
        try {
            Connection conn = DbConnection.getConnection();
            final String SQLQ = "INSERT INTO users (email, password, gender, imgurl, name, surname, username) values (?,?,?,?,?,?,?,?)";
            PreparedStatement insertUser = conn.prepareStatement(SQLQ);
            insertUser.setString(1, user.getEmail());
            insertUser.setString(2, user.getPassword());
            insertUser.setString(3, user.getGender());
            if (user.getImgURL().equals(""))
                insertUser.setString(4, "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=401&q=80 401w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=701&q=80 701w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=802&q=80 802w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1001&q=80 1001w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1301&q=80 1301w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1402&q=80 1402w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1601&q=80 1601w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1901&q=80 1901w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2002&q=80 2002w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2201&q=80 2201w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2501&q=80 2501w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2602&q=80 2602w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2801&q=80 2801w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2866&q=80 2866w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2866&q=80 2866w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2866&q=80 2866w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2866&q=80 2866w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2866&q=80 2866w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2866&q=80 2866w, https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2866&q=80 2866w");
            else
                insertUser.setString(4, user.getImgURL());
            insertUser.setString(5, user.getName());
            insertUser.setString(5, user.getSurname());
            insertUser.setString(6, user.getUsername());

            insertUser.executeUpdate();
            users.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(int id) {
        return stream().filter(oneUser -> oneUser.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public Stream<User> stream() {
        return users.stream();
    }

    @Override
    public Iterator<User> iterator() {
        return users.iterator();
    }
}

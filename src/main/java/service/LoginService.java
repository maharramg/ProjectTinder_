package service;

import additional.User;
import dao.UserDAO;

public class LoginService {
    private UserDAO users;
    private boolean isLogged;
    public LoginService() {
        isLogged = false;
        users = new UserDAO();
    }

    public int check(User user) throws Exception {
        users.read();
        for (User us : users) {
            if (us.checkEqual(user)) {
                isLogged = true;
                return us.getId();
            }

        }
        throw new Exception("Login failed");
    }

    public boolean isLogged() {
        return isLogged;
    }
}

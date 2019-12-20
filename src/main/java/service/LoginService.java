package service;

import additional.User;
import dao.UsersDAO;

public class LoginService {
    private UsersDAO users;
    private boolean isLogged;
    public LoginService() {
        isLogged = false;
        users = new UsersDAO();
    }

    public int check(User user) throws Exception {
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

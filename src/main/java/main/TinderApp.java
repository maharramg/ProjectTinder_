package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import service.*;
import servlet.*;

public class TinderApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        MessageService messageService = new MessageService();
        LikedService likedService = new LikedService();
        LoginService loginService = new LoginService();
        LikeService likeService = new LikeService();
        RegisterService registerService = new RegisterService();

        handler.addServlet(new ServletHolder(new RegisterServlet(registerService)), "/*");
        handler.addServlet(new ServletHolder(new CssServlet()), "/static/*");
        handler.addServlet(new ServletHolder(new LikeServlet(likeService)), "/like/*");
        handler.addServlet(new ServletHolder(new LoginServlet(loginService)), "/login/*");
        handler.addServlet(new ServletHolder(new MessagesServlet(messageService)), "/messages/*");
        handler.addServlet(new ServletHolder(new LikedServlet(likedService)), "/liked/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}

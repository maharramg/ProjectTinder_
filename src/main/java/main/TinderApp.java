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

        RegisterService registerService = new RegisterService();
        LoginService loginService = new LoginService();
        LikeService likeService = new LikeService();
        MessageService messageService = new MessageService();
        LikedService likedService = new LikedService();


        handler.addServlet(new ServletHolder(new RegisterServlet(registerService)), "/*");
        handler.addServlet(new ServletHolder(new LoginServlet(loginService)), "/login/*");
        handler.addServlet(new ServletHolder(new LikeServlet(likeService)), "/like/*");
        handler.addServlet(new ServletHolder(new MessageServlet(messageService)), "/messages/*");
        handler.addServlet(new ServletHolder(new LikedServlet(likedService)), "/liked/*");
        handler.addServlet(new ServletHolder(new StyleServlet()), "/static/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}

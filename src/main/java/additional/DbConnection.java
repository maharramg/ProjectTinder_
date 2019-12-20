package additional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

//  private static final String DB_URL = "jdbc:postgres://raja.db.elephantsql.com:5432/rqacvejn ";
//  private static final String DB_URL = "jdbc:postgresql://localhost:5432/ibatech";
  private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
  private static final String USERNAME = "postgres";
  private static final String USER_PASS = "fenerbahce1907";
/*
* Created!
* You have successfully created a new database. The details are below.
* Username: 3N1ZmnuWJM
* Database name: 3N1ZmnuWJM
* Password: 3G4FBViDOx
* Server: remotemysql.com
* Port: 3306
* These are the username and password to log in to your database and phpMyAdmin
*/
  private static Connection connection;

  private DbConnection() {}

  public static Connection getConnection() {
    if (connection == null) {
      try {
        connection = DriverManager.getConnection(DB_URL, USERNAME, USER_PASS);
      } catch (SQLException e) {
        throw new RuntimeException("Something went wrong during connection", e);
      }
    }
    return connection;
  }
}

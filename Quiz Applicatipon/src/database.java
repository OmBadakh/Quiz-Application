import java.sql.*;

public class database {
    String url = "jdbc:mysql://localhost:3306/quiz";
    String name = "root";
    String pass = "1212";
    Statement st;
  database() {
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection(url, name, pass);
          st = con.createStatement();

      } catch (Exception e) {
          e.printStackTrace();
      }



  }


}

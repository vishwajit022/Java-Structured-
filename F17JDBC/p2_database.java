package F17JDBC;

import java.sql.*;

public class p2_database {
    public static void main(String arg[]) throws Exception {
        Class.forName("org.sqlite.JDBC");

        Connection con = DriverManager
                .getConnection("jdbc:sqlite:C:\\Users\\vishw\\Documents\\GitHub\\Java_Bari\\F7_JDBC\\univ.db");

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from student");

        while (rs.next()) {
            System.out.print(rs.getInt("roll") + " ");
        }

    }
}

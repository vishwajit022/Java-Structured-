package F17JDBC;

import java.sql.*;

public class p1_database {
    public static void main(String arg[]) throws Exception {
        // Load the SQLite JDBC driver class
        Class.forName("org.sqlite.JDBC");
        // This step registers the SQLite JDBC driver, making it available for use.

        // Establish a connection to the SQLite database
        Connection con = DriverManager
                .getConnection("jdbc:sqlite:C:\\Users\\vishw\\Documents\\GitHub\\Java_Bari\\F7_JDBC\\univ.db");
        // DriverManager.getConnection establishes a connection to the specified
        // database URL.

        // Create a statement for executing SQL queries
        Statement st = con.createStatement();
        // The statement object allows us to send SQL queries to the database.

        // Execute the SQL query and retrieve the result set
        ResultSet rs = st.executeQuery("SELECT * FROM dept");
        // st.executeQuery sends the query to the database and returns a result set
        // containing the query results.

        int dno;
        String dname;

        // Iterate through the result set and print department information
        while (rs.next()) {
            // rs.next() moves the cursor to the next row in the result set.
            dno = rs.getInt("deptno");
            // Retrieve the integer value from the "deptno" column of the current row.
            dname = rs.getString("dname");
            // Retrieve the string value from the "dname" column of the current row.

            // Print the department information
            System.out.println(dno + " " + dname);
        }

        // Close the resources to release memory and database connections
        rs.close();
        // Close the result set to free up resources.
        st.close();
        // Close the statement to prevent resource leaks.
        con.close();
        // Close the connection to the database when done using it.
    }
}

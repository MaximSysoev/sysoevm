package ru.job4j.tracker;
import java.sql.*;

public class SQLStorage implements AutoCloseable {

    @Override
    public void connect() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "password";

        Connection conn = null;

        try {
            Class.forName("org.postrgesql.Driver");
            System.out.println("ok");
            conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(String.format("%s", rs.getInt("id")));
            }

            rs.close();
            st.close();

        } catch (Exception e) {
            new Error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                     new Error(e.getMessage(), e);
                }
            }
        }
    }

    public static void main(String[] args) {
        new SQLStorage().connect();
    }
}

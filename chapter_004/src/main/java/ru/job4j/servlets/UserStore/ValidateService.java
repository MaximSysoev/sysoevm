package ru.job4j.servlets.userstore;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


public final class ValidateService {

    private static ValidateService instance = null;
    // public MemoryStore store = MemoryStore.getInstance();
    private final Store store = DbStore.getInstance();
    private static final Connect conn = new Connect();


    private ValidateService() {

    }

    public static synchronized ValidateService getInstance() {
        if (instance == null) {
            instance = new ValidateService();
        }
        return instance;
    }

    public boolean contain(User user) {
        try {
            Connection connection = conn.getSOURCE().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select login, email from users");
            while (rs.next()) {
                String login = rs.getString("login").trim();
                String email = rs.getString("email").trim();
                if (login.equals(user.getLogin()) || email.equals(user.getEmail()) || user.getName().isEmpty() || user.getEmail().isEmpty() || user.getLogin().isEmpty() ) {
                    return true;
                }
            }
            st.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void add(User user) {
        store.add(user);
    }

    public void update(int id, User user) {
        store.update(id, user);
    }

    public void delete(int key) {
        store.delete(key);
    }

    public List<User> findAll() {
        return  store.findAll();
    }

    public User findById(int id) {
        return store.findById(id);
    }
}
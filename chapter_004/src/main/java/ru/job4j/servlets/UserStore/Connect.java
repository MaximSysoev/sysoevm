package ru.job4j.servlets.userstore;
import org.apache.commons.dbcp2.BasicDataSource;

public class Connect {
    private static final BasicDataSource SOURCE = new BasicDataSource();


    public Connect() {
        SOURCE.setDriverClassName("org.postgresql.Driver");
        SOURCE.setUrl("jdbc:postgresql://localhost:5432/postgres");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("password");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public BasicDataSource getSOURCE() {
        return SOURCE;
    }
}

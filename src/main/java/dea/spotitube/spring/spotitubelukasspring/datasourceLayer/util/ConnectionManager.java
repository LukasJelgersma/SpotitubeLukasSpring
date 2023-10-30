package dea.spotitube.spring.spotitubelukasspring.datasourceLayer.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class ConnectionManager {

    private Connection connection;
    private DatabaseProperties databaseProperties;

    public Connection ConnectionStart() {
        try {
            connection = DriverManager.getConnection(databaseProperties.connectionString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Autowired
    public void setDatabaseProperties(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }
}

package connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import static connection.ConnectionManager.processSQLException;

public class H2ConnectionPool implements ConnectionPool {

    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private static H2ConnectionPool instance;

    /**
     * The {@code Properties} that allows to get connection credentials
     */
    private static final Properties PROPERTIES = new Properties();

    /**
     * {@code org.apache.logging.log4j.Logger} is used for logging
     * information about events.
     */

    private static final Logger LOG = LogManager
            .getLogger(ConnectionManager.class);

    private H2ConnectionPool(List<Connection> pool) {
        this.connectionPool = pool;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    static H2ConnectionPool getInstance() {
        if (instance == null) {
            List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                pool.add(createConnection());
            }
            instance = new H2ConnectionPool(pool);
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool
                .remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    private static Connection createConnection() {
        loadProperties();
        Connection connection = null;
        try {
            Class.forName(PROPERTIES.getProperty(DRIVER));
            connection = DriverManager
                    .getConnection(PROPERTIES.getProperty(URL),
                            PROPERTIES.getProperty(USER),
                            PROPERTIES.getProperty(PASSWORD));
        } catch (SQLException e) {
            processSQLException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();/*TODO*/
        }
        return connection;
    }

    public boolean closeConnections() {
        try {
            for (Connection connection : connectionPool) {
                connection.close();
            }
            for (Connection connection : usedConnections) {
                connection.close();
            }
            connectionPool.clear();
            usedConnections.clear();
            return true;
        } catch (SQLException e) {
            processSQLException(e);
        }
        return false;
    }

    /**
     * Loads properties from the specified file.
     */
    private static void loadProperties() {
        try {
            PROPERTIES.load(new FileInputStream(Objects.requireNonNull(
                    H2ConnectionPool.class.getClassLoader()
                           // .getResource("./jdbc.properties"))
                            //.getResource("/tmp/JDBC2/src/main/resource/jdbc.properties"))
                            .getResource("/home/anna/IdeaProjects/Book_Store/src/main/resources/jdbc.properties"))
                    .getFile()));
        } catch (IOException e) {
            e.printStackTrace();/*TODO*/
        }
    }
}
//"./JDBC2/src/main/resources/jdbc.properties"


//    private static void loadProperties() {
//        InputStream inputStream = ConnectionPool.class.getClassLoader().getResourceAsStream("./jdbc.properties");
//        try {
//            PROPERTIES.load(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

//./jdbc.properties

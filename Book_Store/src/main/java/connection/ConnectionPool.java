package connection;

import java.sql.Connection;

/**
 * The interface Connection pool.
 */
public interface ConnectionPool {

    /**
     * The constant INITIAL_POOL_SIZE.
     */
    int INITIAL_POOL_SIZE = 8;
    /**
     * The constant DRIVER.
     */
    String DRIVER = "H2.name";
    /**
     * The constant URL.
     */
    String URL = "H2.url";
    /**
     * The constant USER.
     */
    String USER = "H2.user";
    /**
     * The constant PASSWORD.
     */
    String PASSWORD = "H2.password";

    /**
     * Gets connection.
     *
     * @return the connection
     */
    Connection getConnection();

    /**
     * Release connection boolean.
     *
     * @param connection the connection
     * @return the boolean
     */
    boolean releaseConnection( Connection connection);

    /**
     * Close connections boolean.
     *
     * @return the boolean
     */
    boolean closeConnections();
}

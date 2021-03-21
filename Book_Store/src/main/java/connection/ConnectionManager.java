package connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {
    /**
     * {@code ConnectionManager} instance
     */

    private static ConnectionManager instance;

    /**
     * {@code org.apache.logging.log4j.Logger} is used for logging
     * information about events.
     */
    private static final Logger LOG = LogManager
            .getLogger(ConnectionManager.class);

    private final ConnectionPool connectPool = H2ConnectionPool.getInstance();

    /**
     * Private constructor to prevent direct creation of the {@code
     * ConnectionManager}.
     */
    private ConnectionManager() {
    }

    /**
     * Returns instance of the {@code ConnectionManager}.
     *
     * @return instance of the {@code ConnectionManager}
     */
    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    /**
     * Returns established {@code Connection} instance.
     *
     * @return established {@code Connection} instance or {@code null} if {@code ConnectionManager} could not establish connection with specified parameters.
     */
    public Connection getConnection() {
        return connectPool.getConnection();
    }

    /**
     * Release connection boolean.
     *
     * @param connection the connection
     * @return the boolean
     */
    public boolean releaseConnection(Connection connection) {
        return connectPool.releaseConnection(connection);
    }

    /**
     * Closes established connections.
     *
     * @return {@code true} if the connection has been closed successfully.
     */
    public boolean closeConnections() {
        return connectPool.closeConnections();
    }

    /**
     * Logs detailed info about occurred {@code SQLException}.
     *
     * @param sqlException instance of the occurred exception.
     */
    public static void processSQLException(SQLException sqlException) {
        LOG.error("Error message: " + sqlException.getMessage(), sqlException);
        LOG.error("Error code: " + sqlException.getErrorCode(), sqlException);
        LOG.error("SQL state: " + sqlException.getSQLState(), sqlException);
    }
}

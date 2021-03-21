package com.solution.goncharova;

import java.sql.SQLException;

public class Domain {
    public static void main( String[] args ) throws SQLException {
        Util util = new Util();
        util.getConnection();
    }
}

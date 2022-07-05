package org.scriptobi.openschool_swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private Connection cnx;
    private String dbName;

    public Connection getCnx() { return cnx; }
    public String getDbName() { return dbName; }

    public MySQLConnection() {
        this("localhost", "openschooldb", "root", "");
    }
    public MySQLConnection(String hostName, String dbName, String usr, String pwd) {
        String url = "jdbc:mysql://" + hostName + "/" + dbName;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, usr, pwd);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        } catch (SQLException e) {
            System.out.println(e);
            System.exit(0);
        }
    }
}

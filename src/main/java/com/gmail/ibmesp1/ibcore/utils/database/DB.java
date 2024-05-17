package com.gmail.ibmesp1.ibcore.utils.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Abstract class to make a database on MySQL or SQLite
 *
 * @since 1.2.0
 * @author IB
 * @version 1.0
 */
public abstract class DB {
    private final String url;
    private final String host;
    private final String user;
    private final String password;

    /**
     * Constructor for a MySQL database
     *
     * @param host Host name
     * @param port MySQL port
     * @param user User name
     * @param password Password
     * @param db Database name
     *
     * @since 1.2.0
     * @author IB
     */
    public DB(String host, String port, String user, String password, String db) {
        this.host = host;
        this.user = user;
        this.password = password;

        url = "jdbc:mysql://"+ host + ":" + port + "/" + db;
    }

    /**
     * Constructor for a SQLite database
     *
     * @param file Path to the SQLite file
     * @since 1.2.0
     * @author IB
     */
    public DB(File file){
        url = "jdbc:sqlite:" + file.getAbsolutePath();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.host = null;
        this.user = null;
        this.password = null;
    }

    /**
     * Method that returns a connection to the database
     *
     * @return The connection to the database
     *
     * @since 1.2.0
     * @author IB
     */
    public Connection getConnection(){
        Connection connection = null;

        try {
            if(host == null)
                connection = DriverManager.getConnection(url);
            else
                connection = DriverManager.getConnection(url,user,password);
        }catch (SQLException ex){
            System.out.println("There was a problem connecting to the database.");
        }

        return connection;
    }

    /**
     * Abstract class to create tables
     *
     * @since 1.2.0
     * @author IB
     */
    public abstract void initializeDatabase();
}

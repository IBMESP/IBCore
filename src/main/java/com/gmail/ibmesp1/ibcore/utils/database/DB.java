package com.gmail.ibmesp1.ibcore.utils.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DB {
    private final String url;
    private final String host;
    private final String user;
    private final String password;

    public DB(String host, String port, String user, String password, String db) {
        this.host = host;
        this.user = user;
        this.password = password;

        url = "jdbc:mysql://"+ host + ":" + port + "/" + db;
    }

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

    public abstract void initializeDatabase();
}

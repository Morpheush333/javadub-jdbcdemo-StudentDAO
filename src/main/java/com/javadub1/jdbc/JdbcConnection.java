package com.javadub1.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcConnection {
    private JdbcSettings jdbcSettings;

    public JdbcConnection() throws IOException {
        this.jdbcSettings = new JdbcSettings();
    }

    private MysqlDataSource getDataSource(){
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName(jdbcSettings.getJdbcHost());
        mysqlDataSource.setPort(Integer.parseInt(jdbcSettings.getJdbcPort()));
        mysqlDataSource.setUser(jdbcSettings.getJdbcUsername());
        mysqlDataSource.setPassword(jdbcSettings.getJdbcPassword());
        mysqlDataSource.setDatabaseName(jdbcSettings.getJdbcDatabaseName());

        try {
            mysqlDataSource.setUseSSL(false); //code. off
            mysqlDataSource.setServerTimezone("UTC"); // time part.
        } catch (SQLException e) {
            System.err.println("Error, unable to set ssl/timezone.!");
            JOptionPane.showMessageDialog(null, "Unable to connect.");
            System.exit(1);
        }
        return mysqlDataSource;
    }

    public Connection getConnection() throws SQLException {
        Connection mysqlConnection = getDataSource().getConnection();
        return mysqlConnection;
    }
}

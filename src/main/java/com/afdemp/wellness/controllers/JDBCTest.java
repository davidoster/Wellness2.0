
package com.afdemp.wellness.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author davidoster
 */
public class JDBCTest {
    private static final String DB_URL = "ra1.anystream.eu:3012";
    private static final String FULL_DB_URL = "jdbc:mysql://" + DB_URL + "/wellness2.0?serverTimezone=Europe/Athens";
    private static final String DB_USER = "root";
    private static final String DB_PASSWD = "AFDEmp_MySQL1";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(FULL_DB_URL, DB_USER, DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM products;");
            //if(resultSet.first()) return true;
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Sorry, problems with the database connection!");
            System.out.println(ex.toString());
            System.exit(0);
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
            }
        }
    }
}



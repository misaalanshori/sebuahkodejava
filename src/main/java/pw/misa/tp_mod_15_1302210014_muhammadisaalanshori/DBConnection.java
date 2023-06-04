/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pw.misa.tp_mod_15_1302210014_muhammadisaalanshori;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Isabu
 */
public class DBConnection {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://mysql-punya.misa.pw:6603/modul15";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password@mysql-punya.misa.pw";

    private static Connection connection;

    private DBConnection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, 
                                                        USERNAME, 
                                                        PASSWORD);
                connection.setTransactionIsolation(
                        Connection.TRANSACTION_SERIALIZABLE);
                connection.setAutoCommit(false);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Terjadi Kesalahan Koneksi MySQL: " + 
                                    e.getMessage());
            }
        }
        return connection;
    }
}

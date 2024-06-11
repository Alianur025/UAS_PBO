/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

/**
 *
 * @author USER
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conn {

    public static Connection BukaKoneksi() {
        Connection cn = null;
        if (cn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost/ujian", "root", "");
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Driver tidak ditemukan: " + e.getMessage());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage());
            }
        }
        return cn;
    }

    public static void TutupKoneksi(Connection cn) {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pw.misa.tp_mod_15_1302210014_muhammadisaalanshori;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Isabu
 */
public class MahasiswaDAO {
    private Connection conn;

    public MahasiswaDAO() {
        this.conn = DBConnection.getConnection();
    }
    
    public List<Mahasiswa> selectAll() {
        String sql = "SELECT * FROM mahasiswa";
        List<Mahasiswa> semuaMhs = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nim = rs.getString("nim");
                String nama = rs.getString("nama");
                double nilai = rs.getDouble("nilai");
                semuaMhs.add(new Mahasiswa(nim, nama, nilai));
            }
            
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan SQL: " + e.getMessage());
        }
        return semuaMhs;
    }
    
    public void insert(Mahasiswa mhs) {
        String sql = "INSERT INTO mahasiswa (nim, nama, nilai) VALUES(?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, mhs.getNim());
            stmt.setString(2, mhs.getNama());
            stmt.setDouble(3, mhs.getNilai());
            stmt.executeUpdate();
            conn.commit();
            System.out.println("Mahasiswa Ditambahkan");
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan SQL: " + e.getMessage());
        }
    }
    
    public void update(Mahasiswa mhs) {
        String sql = "UPDATE mahasiswa SET nama=?, nilai=? WHERE nim=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(3, mhs.getNim());
            stmt.setString(1, mhs.getNama());
            stmt.setDouble(2, mhs.getNilai());
            stmt.executeUpdate();
            conn.commit();
            System.out.println("Mahasiswa Diupdate");
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan SQL: " + e.getMessage());
        }
    }
    
    public void deleteAll() {
        String sql = "DELETE FROM mahasiswa";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.commit();
            System.out.println("Semua Mahasiswa Dihapus");
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan SQL: " + e.getMessage());
        }
    }
}

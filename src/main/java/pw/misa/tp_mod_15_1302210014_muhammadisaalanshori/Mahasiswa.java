/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pw.misa.tp_mod_15_1302210014_muhammadisaalanshori;

/**
 *
 * @author Isabu
 */
public class Mahasiswa {
    private String nim;
    private String nama;
    private double nilai;
    
    public Mahasiswa() {
    }
    
    public Mahasiswa(String nim, String nama, double nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    @Override
    public String toString() {
        return "" + nim + " - " + nama + " - " + nilai;
    }
}

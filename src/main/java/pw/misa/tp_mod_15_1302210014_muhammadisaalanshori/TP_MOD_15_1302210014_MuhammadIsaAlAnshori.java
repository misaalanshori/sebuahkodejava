/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pw.misa.tp_mod_15_1302210014_muhammadisaalanshori;

import java.util.List;

/**
 *
 * @author Isabu
 */
public class TP_MOD_15_1302210014_MuhammadIsaAlAnshori {

    public static void main(String[] args) {
        MahasiswaDAO mhsdao = new MahasiswaDAO();
        mhsdao.deleteAll();
        mhsdao.insert(new Mahasiswa("1303209991", "Neo", 100.0));
        mhsdao.insert(new Mahasiswa("1303209992", "Morpheus", 87.5));
        mhsdao.insert(new Mahasiswa("1303209993", "Smith", 75));
        MahasiswaController mhsControl = new MahasiswaController();
    }
}

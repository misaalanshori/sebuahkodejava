/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pw.misa.tp_mod_15_1302210014_muhammadisaalanshori;

import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Isabu
 */
public class MahasiswaController {
    MahasiswaDAO mhsdao;
    List<Mahasiswa> listMhs;
    MahasiswaView viewMhs;

    public MahasiswaController() {
        mhsdao = new MahasiswaDAO();
        viewMhs = new MahasiswaView(this);
        refresh();
        viewMhs.setVisible(true);
    }
    
    public void refresh() {
        listMhs = mhsdao.selectAll();
        viewMhs.getListModel().removeAllElements();
        for (Mahasiswa mhs : listMhs) {
            viewMhs.getListModel().addElement(mhs.getNama());
        }
        updateForm();
    }
    
    public void updateForm() {
        int selectedIndex = viewMhs.getMahasiswaList().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < listMhs.size()) {
            Mahasiswa mhs = listMhs.get(selectedIndex);
            viewMhs.getNimBox().setText(mhs.getNim());
            viewMhs.getNamaBox().setText(mhs.getNama());
            viewMhs.getNilaiBox().setText("" + mhs.getNilai());
        } else {
            viewMhs.getNimBox().setText("");
            viewMhs.getNamaBox().setText("");
            viewMhs.getNilaiBox().setText("");
        }
        
    }
    
    public void update() {
        int selectedIndex = viewMhs.getMahasiswaList().getSelectedIndex();
        JDialog dialog = new JDialog(viewMhs, "Status");
        dialog.setSize(240, 96);
        
        if (selectedIndex >= 0 && selectedIndex < listMhs.size()) {
            if (viewMhs.getNimBox().getText().isBlank() || 
                viewMhs.getNamaBox().getText().isBlank() ||
                viewMhs.getNilaiBox().getText().isBlank()) {
                dialog.add(new JLabel("Error! Isi semua data!",SwingConstants.CENTER));
                dialog.setVisible(true);
            } else {
                Mahasiswa mhs = new Mahasiswa(viewMhs.getNimBox().getText(), 
                                            viewMhs.getNamaBox().getText(), 
                                            Double.parseDouble(viewMhs.getNilaiBox().getText()));
                mhsdao.update(mhs);
                refresh();
                dialog.add(new JLabel("Data berhasil di-update di database",SwingConstants.CENTER));
                dialog.setVisible(true);
            }
            
        } else {
            dialog.add(new JLabel("Error! Pilih mahasiswa terlebih dahulu!",SwingConstants.CENTER));
            dialog.setVisible(true);
        }
    } 
}

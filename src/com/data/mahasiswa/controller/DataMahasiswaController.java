/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.mahasiswa.controller;

import com.data.mahasiswa.config.HibernateUtil;
import com.data.mahasiswa.dao.DataMahasiswaDao;
import com.data.mahasiswa.model.DataMahasiswa;
import com.data.mahasiswa.model.DataMahasiswaTableModel;
import com.data.mahasiswa.view.DataMahasiswaView;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DataMahasiswaController {
    private DataMahasiswaView dataMahasiswaView;
    private List<DataMahasiswa> listDataMahasiswa;
    private DataMahasiswaTableModel dataMahasiswaTableModel;
    private final DataMahasiswaDao dataMahasiswaDao = HibernateUtil.getDataMahasiswaDao();
    
      public DataMahasiswaController(DataMahasiswaView dataMahasiswaView) {
        this.dataMahasiswaView = dataMahasiswaView;
    }
     
     public void clear(){
        this.dataMahasiswaView.getTxtNpm().setText("");
        this.dataMahasiswaView.getTxtNama().setText("");
        this.dataMahasiswaView.getTxtKelas().setText("");
        this.dataMahasiswaView.getTxtJurusan().setText("");
    }
     public void saveMahasiswa(){
         DataMahasiswa dataMahasiswa = new DataMahasiswa();
         dataMahasiswa.setNpm(this.dataMahasiswaView.getTxtNpm().getText());
         dataMahasiswa.setNama(this.dataMahasiswaView.getTxtNama().getText());
         dataMahasiswa.setKelas(this.dataMahasiswaView.getTxtKelas().getText());
         dataMahasiswa.setJurusan(this.dataMahasiswaView.getTxtJurusan().getText());
         
         try{
           dataMahasiswaDao.save(dataMahasiswa);
           JOptionPane.showMessageDialog(null, "Berhasil menyimpan data", "Success", JOptionPane.INFORMATION_MESSAGE);
           clear();
           getAllData();
           
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Gagal menyimpan data", "Error", JOptionPane.INFORMATION_MESSAGE);
     }
}
     public void updateMahasiswa(){
         DataMahasiswa dataMahasiswa = new DataMahasiswa();
         dataMahasiswa.setNpm(this.dataMahasiswaView.getTxtNpm().getText());
         dataMahasiswa.setNama(this.dataMahasiswaView.getTxtNama().getText());
         dataMahasiswa.setKelas(this.dataMahasiswaView.getTxtKelas().getText());
         dataMahasiswa.setJurusan(this.dataMahasiswaView.getTxtJurusan().getText());
         
         try{
             dataMahasiswaDao.update(dataMahasiswa);
             JOptionPane.showMessageDialog(null, "Berhasil mengubah data", "Success", JOptionPane.INFORMATION_MESSAGE);
           clear();
           getAllData();
         } catch(Exception e){
             JOptionPane.showMessageDialog(null, "Gagal mengubah data", "Error", JOptionPane.INFORMATION_MESSAGE);
         }
     }

     public void deleteMahasiswa(){
         if(this.dataMahasiswaView.getTxtNpm().getText() == null){
             JOptionPane.showMessageDialog(null,"Data Belum Dipilih", "Error", JOptionPane.INFORMATION_MESSAGE);
         }else{
             DataMahasiswa dataMahasiswa = new DataMahasiswa();
             dataMahasiswa.setNpm(this.dataMahasiswaView.getTxtNpm().getText());
            
             int option = JOptionPane.showConfirmDialog(null, "Apakah ingin menghapus ini?", "Warning", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
             if(option == JOptionPane.YES_OPTION){
                 try{
                     dataMahasiswaDao.delete(dataMahasiswa);
                     JOptionPane.showMessageDialog(null, "Berhasil menghapus Data", "Success", JOptionPane.INFORMATION_MESSAGE);
                     clear();
                    getAllData();
                 }catch(Exception e){
                     JOptionPane.showMessageDialog(null, "Gagal mengubah Data", "Error", JOptionPane.INFORMATION_MESSAGE);
                 }
             }
         }
     }
    public void getAllData() {
        listDataMahasiswa = dataMahasiswaDao.getList();
        dataMahasiswaTableModel = new DataMahasiswaTableModel(listDataMahasiswa);
        this.dataMahasiswaView.getTblMahasiswa().setModel(dataMahasiswaTableModel);
    }
    public void getdata(){
        int rowIndex = this.dataMahasiswaView.getTblMahasiswa().getSelectedRow();
        this.dataMahasiswaView.getTxtNpm().setText(String.valueOf(this.dataMahasiswaView.getTblMahasiswa().getValueAt(rowIndex, 0)));
        this.dataMahasiswaView.getTxtNama().setText(String.valueOf(this.dataMahasiswaView.getTblMahasiswa().getValueAt(rowIndex, 1)));
        this.dataMahasiswaView.getTxtKelas().setText(String.valueOf(this.dataMahasiswaView.getTblMahasiswa().getValueAt(rowIndex, 2)));
        this.dataMahasiswaView.getTxtJurusan().setText(String.valueOf(this.dataMahasiswaView.getTblMahasiswa().getValueAt(rowIndex, 3)));
    }

    
}

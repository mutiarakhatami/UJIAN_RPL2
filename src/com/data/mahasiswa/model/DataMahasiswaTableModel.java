/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.mahasiswa.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class DataMahasiswaTableModel extends AbstractTableModel{
    
    private List<DataMahasiswa> listDataMahasiswa = new ArrayList();
    private final String HEADER[] = {"NPM", "Nama", "Kelas", "Jurusan"};

    public DataMahasiswaTableModel(List<DataMahasiswa> listDataMahasiswa) {
        this.listDataMahasiswa = listDataMahasiswa;
    }

    
    @Override
    public int getRowCount() {
        return listDataMahasiswa.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DataMahasiswa dataMahasiswa = listDataMahasiswa.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return dataMahasiswa.getNpm();
            case 1:
                return dataMahasiswa.getNama();
            case 2:
                return dataMahasiswa.getKelas();
            case 3:
                return dataMahasiswa.getJurusan();
            default:
                return null;
        }
    }
    public String getColumnName(int index){
        return HEADER[index];
    }
}

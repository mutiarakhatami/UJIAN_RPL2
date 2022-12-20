/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.mahasiswa.dao;

import com.data.mahasiswa.model.DataMahasiswa;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface DataMahasiswaDao {
    public void save(DataMahasiswa dataMahasiswa);
    public void update (DataMahasiswa dataMahasiswa);
    public void delete (DataMahasiswa dataMahasiswa);
    public DataMahasiswa get(String npm);
    public List<DataMahasiswa> getList();
}

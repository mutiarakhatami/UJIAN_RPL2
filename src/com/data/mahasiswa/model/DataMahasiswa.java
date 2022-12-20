/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.mahasiswa.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ASUS
 */

@Entity
@Table (name = "data_mahasiswa")
public class DataMahasiswa implements Serializable {
    @Id
    @Column(name = "npm", length = 8)
    private String npm;
    @Column(name = "nama", length = 30)
    private String nama;
    @Column(name = "kelas", length = 6)
    private String kelas;
    @Column(name = "jurusan", length = 30)
    private String jurusan;

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    
    
    
}
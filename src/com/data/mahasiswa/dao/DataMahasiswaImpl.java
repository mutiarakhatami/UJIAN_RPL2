/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.mahasiswa.dao;

import com.data.mahasiswa.model.DataMahasiswa;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ASUS
 */
public class DataMahasiswaImpl implements DataMahasiswaDao{
    private final SessionFactory sessionFactory;

    public DataMahasiswaImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(DataMahasiswa datamahasiswa) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(datamahasiswa);
            session.getTransaction().commit();
        }catch(Exception e){
            System.err.print("Tidak dapat menyimpan data mahasiswa");
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DataMahasiswa datamahasiswa) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(datamahasiswa);
            session.getTransaction().commit();
        }catch(Exception e){
            System.err.print("Tidak dapat mengupdate data mahasiswa");
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DataMahasiswa datamahasiswa) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(datamahasiswa);
            session.getTransaction().commit();
        }catch(Exception e){
            System.err.print("Tidak dapat menghapus data mahasiswa");
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataMahasiswa get(String npm) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            DataMahasiswa datamahasiswa = (DataMahasiswa) session.get(DataMahasiswa.class, npm);
            session.getTransaction().commit();
            return datamahasiswa;
        }catch(Exception e){
            System.err.print("Tidak dapat menampilkan data mahasiswa");
            session.getTransaction().rollback();
            return null;
        }
        finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DataMahasiswa> getList() {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            List<DataMahasiswa> listmahasiswa = session.createCriteria(DataMahasiswa.class).list();
            session.getTransaction().commit();
            return listmahasiswa;
        }catch(Exception e){
            System.err.print("Tidak ada list mahasiswa");
            session.getTransaction().rollback();
            return null;
        }
        finally{
            session.close();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

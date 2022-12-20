/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data.mahasiswa.config;

import com.data.mahasiswa.dao.DataMahasiswaDao;
import com.data.mahasiswa.dao.DataMahasiswaImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ASUS
 */
public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;
    private static final DataMahasiswaDao DataMahasiswa_DAO;
    
    static{
        try{
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
            DataMahasiswa_DAO = new DataMahasiswaImpl(SESSION_FACTORY);
        }catch(Throwable e){
            System.err.println("Initial SessionFactory Creation Failed : " + e);
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
    public static DataMahasiswaDao getDataMahasiswaDao(){
        return DataMahasiswa_DAO;
    }
}

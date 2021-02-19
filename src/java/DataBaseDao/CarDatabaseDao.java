/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseDao;

import Domain.Car;
import Domain.NewHibernateUtil;
import Domain.PassengerCar;
import Domain.Truck;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bitwayiki
 */
public class CarDatabaseDao {
    private static Session s;
    
    public static Car createCar(Car cr){
        
        s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(cr);
        s.getTransaction().commit();
        s.close();
        return cr;
    }
      public static Car carUpdate(Car cr){
        
        s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(cr);
        s.getTransaction().commit();
        s.close();
        return cr;
    }
      
        public static Car carDelete (Car cr){
        
        s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(cr);
        s.getTransaction().commit();
        s.close();
        return cr;
    }
        public static List<Truck>findAllTrucks(){
            s= NewHibernateUtil.getSessionFactory().openSession();
            List<Truck> t = s.createQuery("from Truck").list();
            s.close();
            return t;
        }
        
        
         public static List<PassengerCar> findAllPassengerCars(){
            s= NewHibernateUtil.getSessionFactory().openSession();
            List<PassengerCar> pc = s.createQuery("from PassengerCar").list();
            s.close();
            return pc;
        }
    
    
    
}

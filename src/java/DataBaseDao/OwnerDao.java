/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseDao;

import Domain.NewHibernateUtil;
import Domain.Owner;
import Domain.Truck;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bitwayiki
 */
public class OwnerDao {
    private static Session s;
    
    public static  Owner createOwner(Owner o){
        s= NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(o);
        s.getTransaction().commit();
        s.close();
        return o;
    }
    
    
     public static  Owner updateOwner(Owner o){
        s= NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(o);
        s.getTransaction().commit();
        s.close();
        return o;
    }
     
      public static  Owner deleteOwner(Owner o){
        s= NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(o);
        s.getTransaction().commit();
        s.close();
        return o;
    }
      
      public static List<Owner>findAll(){
            s= NewHibernateUtil.getSessionFactory().openSession();
            List<Owner> owners = s.createQuery("from Owner").list();
            s.close();
            return owners;
        }
      
      
}

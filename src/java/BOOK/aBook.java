/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOOK;

import static com.opensymphony.xwork2.Action.SUCCESS;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author bibit
 */    
    @Entity
@Table(name="books")
public class aBook {


    @Id @GeneratedValue
    @Column(name="id")
     private Integer id;
    @Column(name="bname")
     private String bname;
    @Column(name="bauth")
     private String bauth;
 
    
    
    public aBook() {
    }

    public aBook(String bname, String bauth)
    {
        this.bname = bname;
        this.bauth = bauth;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getBname() {
        return this.bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauth() {
        return this.bauth;
    }

    public void setBauth(String bauth) {
        this.bauth = bauth;
    }
    
    private static SessionFactory factory;
    public static void init()
    {
        try{
            factory = new AnnotationConfiguration().configure().addAnnotatedClass(aBook.class).buildSessionFactory();
        }
        catch(Throwable ex)
        {
            System.err.println("Factory Object is not Created"+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
     public String Add_book() throws Exception {
        
        init();
        Session session=factory.openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(this);
            tx.commit();
            System.out.println("Successfully inserted");
            factory.close();
        }
        catch(Exception e){
            System.out.println("!!EXCEPTION HERE!!"+e);
        }
        return SUCCESS;
//        try{
//            Session session = factory.openSession();
//            Transaction tx = session.beginTransaction();
//            
//            aBook ep = new aBook();
//            ep.setBname(bname);
//            ep.setBauth(bauth);
//            
//            session.save(ep);
//            tx.commit();
//            System.out.println("Successfully Inserted");
//            factory.close();
//            
//        }
//        catch(Exception e)
//        {
//            System.out.println("Insertion Not Succesfull"+e);
//        }
//        return SUCCESS;
     }
    
}

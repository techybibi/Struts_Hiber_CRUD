/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOOK;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Iterator;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author bibit
 */
@Entity
@Table(name="books")
public class vBook {
    public List<aBook> blist=null;
    private static SessionFactory factory;
    private boolean noData=false;
    
    public String execute() throws Exception {
        try
        {
            factory = new AnnotationConfiguration().configure().addAnnotatedClass(aBook.class).buildSessionFactory();
            System.out.println("##SUCCESS##");
        }
        catch(Throwable ex) {
            System.err.println("Faiiled to create seesionFactory object"+ex);
            throw new ExceptionInInitializerError(ex);
        }
        noData=false;
        Session session=factory.openSession();
        Transaction tx=null;
        try
        {
            blist=new ArrayList<aBook>();
            tx=session.beginTransaction();
            List depts=session.createQuery("FROM books").list();
            for(Iterator iterator=depts.iterator();iterator.hasNext();)
            {
                aBook d=(aBook)iterator.next();
                blist.add(d);
                noData=true;
            }
            tx.commit();
            factory.close();
            return SUCCESS;
        }
        catch(Exception e){
            System.out.println(e);
            return "!!!ERROR!!!";
        }
        
    }

    public void setNoData(boolean noData) {
        this.noData = noData;
    }

    public boolean isNoData() {
        return this.noData;
    }

    public void setClist(List<aBook> clist) {
        this.blist = clist;
    }

    public List<aBook> getClist() {
        return this.blist;
    }
}

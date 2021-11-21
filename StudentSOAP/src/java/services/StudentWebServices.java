/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Student;
/**
 *
 * @author asus
 */
@WebService(serviceName = "StudentWebServices")
public class StudentWebServices {
    /**
     * Web service operation
     * @param id
     * @return 
     */
    @WebMethod(operationName = "findStudentByID")
    public Student findStudentByID(@WebParam(name = "id") int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentSOAPPU");
        EntityManager em = emf.createEntityManager();
        Student std = null;
        try {
            std = em.find(Student.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
            emf.close();
        }
        return std;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertStudent")
    public int insertStudent(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "GPA") double GPA) {
        Student std = new Student(id,name,GPA);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentSOAPPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student target = em.find(Student.class, std.getId());
            if (target != null) {
                return 0;
            }
            em.persist(std);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
         
        }
        return 1;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteStudent")
    public int deleteStudent(@WebParam(name = "id") int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentSOAPPU");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student target = em.find(Student.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateStudent")
    public int updateStudent(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "GPA") double GPA) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentSOAPPU");
       EntityManager em = emf.createEntityManager();
       Student std = new Student(id,name,GPA);
        try {
            em.getTransaction().begin();
            Student target = em.find(Student.class, std.getId());
            if (target == null) {
                return 0;
            }
            target.setName(std.getName());
            target.setGpa(std.getGpa());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
            emf.close();
        }
        return 1;
    }
    
    
    
    
    
    

    
}

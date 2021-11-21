/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsoapclient;

import servicesClient.Student;

/**
 *
 * @author asus
 */
public class StudentSOAPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student std1 = findStudentByID(1);
        System.out.println("Student No. :" + std1.getId() + " Name :" + std1.getName() + " GPA : " + std1.getGpa());
        
        deleteStudent(1);
        insertStudent(1,"Frank",3.63);
        Student std2 = findStudentByID(1);
        System.out.println("Student No. :" + std2.getId() + " Name :" + std2.getName() + " GPA : " + std2.getGpa());
        updateStudent(1,"Frunk",3.33);
        std2 = findStudentByID(1);
        System.out.println("Student No. :" + std2.getId() + " Name :" + std2.getName() + " GPA : " + std2.getGpa());
        
    }

    private static Student findStudentByID(int id) {
        servicesClient.StudentWebServices_Service service = new servicesClient.StudentWebServices_Service();
        servicesClient.StudentWebServices port = service.getStudentWebServicesPort();
        return port.findStudentByID(id);
    }

    private static int insertStudent(int id, java.lang.String name, double gpa) {
        servicesClient.StudentWebServices_Service service = new servicesClient.StudentWebServices_Service();
        servicesClient.StudentWebServices port = service.getStudentWebServicesPort();
        return port.insertStudent(id, name, gpa);
    }

    private static int updateStudent(int id, java.lang.String name, double gpa) {
        servicesClient.StudentWebServices_Service service = new servicesClient.StudentWebServices_Service();
        servicesClient.StudentWebServices port = service.getStudentWebServicesPort();
        return port.updateStudent(id, name, gpa);
    }

    private static int deleteStudent(int id) {
        servicesClient.StudentWebServices_Service service = new servicesClient.StudentWebServices_Service();
        servicesClient.StudentWebServices port = service.getStudentWebServicesPort();
        return port.deleteStudent(id);
    }
    
}

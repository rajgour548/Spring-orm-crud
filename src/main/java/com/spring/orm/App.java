package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {

    static Student student = new Student();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        boolean check = true;
        while (check) {
            System.out.println("press 1 : for inserting a row");
            System.out.println("press 2 : for fetching single row");
            System.out.println("press 3 : for fetching multiple row");
            System.out.println("press 4 : for deleting a row");
            System.out.println("press 5 : for updating a row");
            System.out.println("press 6 : to exit application");

            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter your Choice : ");
                int input = Integer.parseInt(br.readLine());
                switch (input) {
                    case 1:
                        System.out.println("inserting");
                        insertdata(studentDao);
                        break;
                    case 2:
                        System.out.println("fetching a row");
                        fetch(studentDao);
                        break;
                    case 3:
                        System.out.println("fetching all row");
                        fetchall(studentDao);
                        break;
                    case 4:
                        System.out.println("deleting a row");
                        remove(studentDao);
                        break;
                    case 5:
                        System.out.println("updating a row");
                        updatedata(studentDao);
                        break;
                    case 6:
                        check = false;
                        break;
                    default:
                        System.out.println("invalid input try with some valid input");
                }
            } catch (Exception e) {
                System.out.println("invalid input !");
                System.out.println(e.getMessage());
            }

            System.out.println("Thank you for using my application");
            System.out.println("See you soon !");

        }

        // to insert a row

        // to fetch single object/row
        /*
         * 
         */

        // to fetch multiple object/row
        /*
         * List<Student> students = studentDao.getAllStudents();
         * for (Student s : students) {
         * System.out.println(s);
         */

        // to delete object/row through id
        /* studentDao.deleteStudent(2); */

        // to update objetc/row
        /*
         * Student student = new Student(1, "aman", "sirali,piplya");
         * studentDao.updateStudent(student);
         */
    }

    public static void insertdata(StudentDao studentDao) {
        System.out.print("Enter id : ");
        student.setStudentId(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter name : ");
        student.setStudentName(sc.nextLine());
        System.out.print("Enter city : ");
        student.setStudentCity(sc.nextLine());
        int result = studentDao.insert(student);
        System.out.println("Student with id :" + result + "is inserted");
    }

    public static void fetch(StudentDao studentDao) {
        System.out.print("Enter id to fetch: ");
        int id = sc.nextInt();
        Student student = studentDao.getStudent(id);
        System.out.println(student);
    }

    public static void fetchall(StudentDao studentDao) {
        List<Student> students = studentDao.getAllStudents();
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static void remove(StudentDao studentDao) {
        System.out.print("Enter id to delete : ");
        int id = sc.nextInt();
        studentDao.deleteStudent(id);
        System.out.println("student deleted successfully from the database!");
    }

    public static void updatedata(StudentDao studentDao) {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id : ");
        student.setStudentId(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter name : ");
        student.setStudentName(sc.nextLine());
        System.out.print("Enter city : ");
        student.setStudentCity(sc.nextLine());
        studentDao.updateStudent(student);
        System.out.println("row updated successfully !");
    }

}

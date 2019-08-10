package com.javadub1.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        // Create linked database

        StudentDao dao = new StudentDao();
        Scanner scanner = new Scanner(System.in);

        boolean isWorking = true;

        do{
            String choos = scanner.nextLine();

            if(choos.equalsIgnoreCase("dodaj")){
                Student newStudent = new Student();

                System.out.println("Podaj imie: ");
                newStudent.setName(scanner.nextLine());

                System.out.println("Podaj index: ");
                newStudent.setIndeks(scanner.nextLine());

                System.out.println("Podaj wiek: ");
                newStudent.setAge(Integer.parseInt(scanner.nextLine()));

                dao.insertStudent(newStudent);
            } else if (choos.equalsIgnoreCase("usun")){
                System.out.println("Podaj id studenta");
                dao.deleteStudent(Long.parseLong(scanner.nextLine()));




            }else if (choos.equalsIgnoreCase("listuj")){

                dao.getAllStudents().forEach(System.out::println);

            }else if (choos.equalsIgnoreCase("quit")){
                isWorking = false;
            }
        } while (isWorking);
    }
}

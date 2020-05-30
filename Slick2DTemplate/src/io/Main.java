package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Department parentDepartment = new Department("Parent department :");
        List<Department> departments = new ArrayList<>();
        List<Persons> persons = new ArrayList<>();
        int temp = 0;

        File myFile = new File("C:\\Vedran\\Coding\\Code\\Java\\FightInTheSky\\Slick2DTemplate\\src\\io\\Abteilungen1.txt");

        FileReader reader = new FileReader(myFile);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] splitted = line.split(";");
            String name = splitted[0];

            String stringDepartment = splitted[1];
            Department newDep = new Department(splitted[1].toString());
            for (Department department : departments) {
                if (department.getName().equals(newDep.getName())) {
                    temp++;
                }
            }
            if (temp == 0) {
                departments.add(newDep);
            }
            temp = 0;

            String stringParentDepartment = null;
            try {
                stringParentDepartment = splitted[2];
            } catch (Exception e) {
                System.out.println(name + " HAS NO PARENT DEPARTMENT");
            }
            Persons persons1 = new Persons(splitted[0].toString(), newDep, null);
            persons.add(persons1);
        }
        for (Persons persons1 : persons) {
            System.out.println(persons1.getName() + " " + persons1.getDepartment().getName());
        }
    }
}

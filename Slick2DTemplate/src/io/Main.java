package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Department> departments = new ArrayList<Department>();
        List<Persons> persons = new ArrayList<>();
        int temp = 0;

        File myFile = new File("C:\\Vedran\\Coding\\Code\\Java\\FightInTheSky\\Slick2DTemplate\\src\\io\\Abteilungen1.txt");

        FileReader reader = new FileReader(myFile);
        try {
            reader.skip(40);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

            try {
                String stringParentDepartment = splitted[2];
            } catch (Exception e) {
                //System.out.println(name + " HAS NO PARENT DEPARTMENT\n");
            }
            try {
                Department parDep = new Department(splitted[2].toString());
                for (Department department : departments) {
                    if (department.getName().equals(parDep.getName())) {
                        temp++;
                    }
                }
                if (temp == 0) {
                    departments.add(parDep);
                }
                temp = 0;

                for (Department department : departments) {
                    if (department.getName().equals(newDep.getName()) && !department.getParentDepartments().contains(parDep)){
                        department.addParentDepartment(parDep);
//                        for (int i = 0; i <department.getParentDepartments().size() ; i++) {
//                            System.out.println(department.getParentDepartments().get(i).getName());
//                        }
                    }
                }
            } catch (Exception e) {
                //System.out.println("No valid parent department\n");
            }


            Persons persons1 = new Persons(splitted[0].toString(), newDep);
            persons.add(persons1);


        }
        for (Persons persons1 : persons) {
            System.out.println("NAME: \t" + persons1.getName() + "\t\t DEPARTMENT: \t" + persons1.getDepartment().getName());
        }
        System.out.println();

        for (Department department : departments) {
            try {
                System.out.println("Department\t" + department.getName() + " has parent department "+department.getParentDepartments().get(0).getName());
            } catch (Exception e) {
                System.out.println("Department\t"+ department.getName() + " has no parent department");
            }
        }
    }
}

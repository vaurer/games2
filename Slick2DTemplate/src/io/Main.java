package io;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //ArrayList<Persons> persons;
        Department vorstand = new Department("Vorstand_");
        Department einkauf = new Department("Einkauf_");
        Department einkaufEuropa = new Department("Einkauf Europa_");
        Department einkaufItalien = new Department("Einkauf Italien_");
        Department einkaufUSA = new Department("Einkauf USA_");
        Department vertrieb = new Department("Vertrieb_");
        Department vertriebEuropa = new Department("Vertrieb Europa_");
        List<Department> departments = new ArrayList<>();
        departments.add(vorstand);
        departments.add(vertrieb);
        departments.add(einkauf);
        departments.add(einkaufEuropa);
        departments.add(einkaufItalien);
        departments.add(einkaufUSA);
        departments.add(vertriebEuropa);
        List<Persons>persons = new ArrayList<>();

        File myFile = new File("C:\\Vedran\\Coding\\Code\\Java\\FightInTheSky\\Slick2DTemplate\\src\\io\\Abteilungen.txt");
        try {
            FileReader reader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] splitted = line.split(";");
                String name = splitted[0];
                String department = splitted[1];
                Persons person = new Persons(name, vertrieb);
//                System.out.println("Name: " + name + "\t\t\tDepartment: " + department);
                switch (department){
                    case "Vorstand":
                        person.setDepartment(vorstand);
                        persons.add(person);
                        vorstand.addPersonToTheList(person);
                        break;
                    case "Einkauf":
                        person.setDepartment(einkauf);
                        persons.add(person);
                        einkauf.addPersonToTheList(person);
                        break;
                    case "Einkauf Europa":
                        person.setDepartment(einkaufEuropa);
                        persons.add(person);
                        einkaufEuropa.addPersonToTheList(person);
                        break;
                    case "Einkauf Italien":
                        person.setDepartment(einkaufItalien);
                        persons.add(person);
                        einkaufItalien.addPersonToTheList(person);
                        break;
                    case "Einkauf USA":
                        person.setDepartment(einkaufUSA);
                        persons.add(person);
                        einkaufUSA.addPersonToTheList(person);
                        break;

                    case "Vertrieb":
                        person.setDepartment(vertrieb);
                        persons.add(person);
                        vertrieb.addPersonToTheList(person);
                        break;
                    case "Vertrieb Europa":
                        person.setDepartment(vertriebEuropa);
                        persons.add(person);
                        vertriebEuropa.addPersonToTheList(person);
                        break;
                }
            }
            for (Department department : departments){
                System.out.println("Departmdepent: " + department.getName());
                System.out.println("Number of persons in the department: " + department.getPersons().size());
                for (int i = 0; i <department.getPersons().size() ; i++) {
                    System.out.println(department.getPersons().get(i).getName());
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        System.out.println();

    }


}

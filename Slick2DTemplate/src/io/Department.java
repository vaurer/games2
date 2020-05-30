package io;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Persons> persons;
    private ArrayList<Department> childDepartments;
    private ArrayList<Department> parentDepartments;


    public Department(String name) {
        this.name = name;
        this.persons = new ArrayList<Persons>();
        this.childDepartments = new ArrayList<Department>();
        this.parentDepartments = new ArrayList<Department>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Persons> getPersons() {
        return persons;
    }

    public void setPersons(List<Persons> persons) {
        this.persons = persons;
    }

    public void addPersonToTheList(Persons persons) {
        this.persons.add(persons);
    }

    public void addChildDepartment(Department department) {
        this.childDepartments.add(department);
    }

    public ArrayList<Department> getChildDepartments() {
        return childDepartments;
    }

    public ArrayList<Department> getParentDepartments() {
        return parentDepartments;
    }

    public void addParentDepartment(Department department) {
        this.parentDepartments.add(department);
    }
}

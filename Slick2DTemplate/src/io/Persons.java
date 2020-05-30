package io;

public class Persons {
    private String name;
    private int age;
    private String street;
    private Department department;
    private Department parentDepartment;


    public Persons(String name, Department department, Department parentDepartment) {
        this.name = name;
        this.department = department;
        this.parentDepartment = parentDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(Department parentDepartment) {
        this.parentDepartment = parentDepartment;
    }
}

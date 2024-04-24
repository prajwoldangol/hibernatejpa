package com.prajwol.model;

import javax.persistence.*;

@Entity
@Table(name = "department")
@NamedQuery(name = "getAllDepartments", query = "SELECT d from Department d")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dId;
    private String name;
    private String state;

    public Department(int dId, String name, String state) {
        this.dId = dId;
        this.name = name;
        this.state = state;
    }

    public Department(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public Department() {

    }

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

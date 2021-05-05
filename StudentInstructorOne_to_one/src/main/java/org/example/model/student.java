package org.example.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name="last_name")
    private  String last_name;
    @Column(name = "gpa")
    private double gpa;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_detail_id")
    private instructor instructorDetail;


    public student() {
    }

    public student(int id, String first_name, String last_name, double gpa) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public instructor getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(instructor instructorDetail) {
        this.instructorDetail = instructorDetail;
    }
}

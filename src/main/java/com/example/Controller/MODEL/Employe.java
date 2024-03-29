package com.example.Controller.MODEL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;
@Entity
public class Employe {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private  String email;
    private List<String> skills;
    @ManyToMany (targetEntity=Project.class)
    private List<Project> Projects;

    public Long getId() {
        return id;
    }

    public Employe(Long id, String name, String email, List<String> skills) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.skills = skills;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static List<String> getSkills() {
        return skills;
    }


}

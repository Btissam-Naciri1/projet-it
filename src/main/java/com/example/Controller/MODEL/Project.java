package com.example.Controller.MODEL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long ID;
    private String nom;
    private Double budget;
    @ManyToMany(targetEntity=Employe.class)
    private List<Employe> Emply;

    public Project(Long ID, String nom, Double budget) {
        this.ID = ID;
        this.nom = nom;
        this.budget = budget;
    }

    public Project() {

    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getID() {
        return ID;
    }

    public String getNom() {
        return nom;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
}

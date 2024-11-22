package com.gestiongarderiewebapp.bean;

import java.util.ArrayList;

/**
 * Classe représentant une garderie
 */
public class Garderie {
    /**
     * L'identifiant de la garderie
     */
    private int idGard;
    /**
     * Le nom de la garderie
     */
    private String nameGard;
    /**
     * La capacité d'accueil de la garderie
     */
    private int capGard;
    /**
     * La liste des enfants de la garderie
     */
    private ArrayList<Child> children = new ArrayList<>();
    /**
     * La liste des employés de la garderie
     */
    private ArrayList<Employee> employees = new ArrayList<>();

    /**
     * Constructeur orienté coté code
     *
     * @param nameGard Le nom de la garderie
     * @param capGard  La capacité d'accueil de la garderie
     */
    public Garderie(String nameGard, int capGard) {
        this.nameGard = nameGard;
        this.capGard = capGard;
    }

    /**
     * Constructeur orienté coté base de données
     *
     * @param idGard   L'identifiant de la garderie
     * @param nameGard Le nom de la garderie
     * @param capGard  La capacité d'accueil de la garderie
     */
    public Garderie(int idGard, String nameGard, int capGard) {
        this.idGard = idGard;
        this.nameGard = nameGard;
        this.capGard = capGard;
    }

    //region Getters et Setters

    public int getIdGard() {
        return idGard;
    }

    public void setIdGard(int idGard) {
        this.idGard = idGard;
    }

    public String getNameGard() {
        return nameGard;
    }

    public void setNameGard(String nameGard) {
        this.nameGard = nameGard;
    }

    public int getCapGard() {
        return capGard;
    }

    public void setCapGard(int capGard) {
        this.capGard = capGard;
    }

    public ArrayList<Child> getKids() {
        return children;
    }

    public void setKids(ArrayList<Child> children) {
        this.children = children;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    //endregion


    /**
     * Override de la méthode toString pour afficher les informations de la garderie
     * @return String
     */
    @Override
    public String toString() {
        return "Garderie N°" + this.idGard +
                "Nom : " + this.nameGard +
                "Capacité : " + this.capGard;
    }
}

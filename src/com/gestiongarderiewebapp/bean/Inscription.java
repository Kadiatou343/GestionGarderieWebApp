package com.gestiongarderiewebapp.bean;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Classe représentant une inscription pour un enfant par un employé
 */
public class Inscription {
    /**
     * L'enfant à inscrire
     */
    private Child child;
    /**
     * L'employée qui fait l'inscription
     */
    private Employee employee;
    /**
     * La date à laquelle l'inscription est faite
     */
    private LocalDate inscriptionDate;

    /**
     * Constructeur orienté coté code
     *
     * @param child    L'enfant à inscrire
     * @param employee L'employée qui fait l'inscription
     */
    public Inscription(Child child, Employee employee) {
        this.child = child;
        this.employee = employee;
        this.inscriptionDate = LocalDate.now();
    }

    /**
     * Constructeur orienté coté base de données
     *
     * @param child           L'enfant à inscrire
     * @param employee        L'employée qui fait l'inscription
     * @param inscriptionDate La date à laquelle l'inscription est faite
     */
    public Inscription(Child child, Employee employee, LocalDate inscriptionDate) {
        this.child = child;
        this.employee = employee;
        this.inscriptionDate = inscriptionDate;
    }

    //region Getters et Setters

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getInscriptionDate() {
        return inscriptionDate;
    }

    public void setInscriptionDate(LocalDate inscriptionDate) {
        this.inscriptionDate = inscriptionDate;
    }

    //endregion


    /**
     * Override de la méthode de toString pour afficher les informations de l'inscription
     * @return String
     */
    @Override
    public String toString() {
        return "Inscription: \n" +
                this.child.toString() +
                "\n" + this.employee.toString() +
                "\nDate Inscription : " + this.inscriptionDate;
    }
}

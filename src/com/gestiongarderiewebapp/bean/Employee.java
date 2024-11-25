package com.gestiongarderiewebapp.bean;

/**
 * Classe représentant un employé de la garderie
 */
public class Employee {
    /**
     * L'identifiant employé
     */
    private int numEmp;
    /**
     * Le nom de famille de l'employé
     */
    private String empLastName;
    /**
     * Le prénom de l'employé
     */
    private String empFirstName;
    /**
     * Le hash du mot de passe de l'employé
     */
    private String passwordHash;

    /**
     * Constructeur orienté coté code
     *
     * @param empLastName  Le nom de famille de l'employé
     * @param empFirstName Le prénom d'un employé
     * @param passwordHash Le hash du mot de passe de l'employé
     */
    public Employee(String empLastName, String empFirstName, String passwordHash) {
        this.empLastName = empLastName;
        this.empFirstName = empFirstName;
        this.passwordHash = passwordHash;
    }

    /**
     * Constructeur orienté coté base de données
     *
     * @param numEmp       L'identifiant de l'employé
     * @param empLastName  Le nom de famille de l'employé
     * @param empFirstName Le prénom d'un employé
     * @param passwordHash Le hash du mot de passe de l'employé
     */
    public Employee(int numEmp, String empLastName, String empFirstName, String passwordHash) {
        this.numEmp = numEmp;
        this.empLastName = empLastName;
        this.empFirstName = empFirstName;
        this.passwordHash = passwordHash;
    }

    /**
     * Constructeur orienté coté code
     *
     * @param empLastName  Le nom de famille de l'employé
     * @param empFirstName Le prénom d'un employé
     */
    public Employee(String empLastName, String empFirstName) {
        this.empLastName = empLastName;
        this.empFirstName = empFirstName;
    }

    /**
     * Constructeur orienté coté base de données
     *
     * @param numEmp       L'identifiant de l'employé
     * @param empLastName  Le nom de famille de l'employé
     * @param empFirstName Le prénom d'un employé
     */
    public Employee(int numEmp, String empLastName, String empFirstName) {
        this.numEmp = numEmp;
        this.empLastName = empLastName;
        this.empFirstName = empFirstName;
    }

    //region Getters et Setters

    public int getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    //endregion


    /**
     * Override de la méthode toString pour afficher les informations de l'employé
     * @return String
     */
    @Override
    public String toString() {
        return "Employé N°" + this.numEmp +
                "\tPrénom : " + this.empFirstName +
                "\tNom : " + this.empLastName;
    }
}

package com.gestiongarderiewebapp.bean;

/**
 * Classe représentant un parent
 */
public class Parent {
    /**
     * L'identifiant du parent
     */
    private int numPar;
    /**
     * Le nom de famille du parent
     */
    private String parLastName;
    /**
     * Le prénom du parent
     */
    private String parFirstName;
    /**
     * Le numéro de téléphone du parent
     */
    private String phoneNumber;

    /**
     * Constructeur orienté coté code
     * @param parLastName Le nom de famille du parent
     * @param parFirstName Le prénom du parent
     * @param phoneNumber Le numéro de téléphone du parent
     */
    public Parent(String parLastName, String parFirstName, String phoneNumber) {
        this.parLastName = parLastName;
        this.parFirstName = parFirstName;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Constructeur orienté coté base de données
     * @param numPar L'identifiant du parent
     * @param parLastName Le nom de famille du parent
     * @param parFirstName Le prénom du parent
     * @param phoneNumber Le numéro de téléphone du parent
     */
    public Parent(int numPar, String parLastName, String parFirstName, String phoneNumber) {
        this.numPar = numPar;
        this.parLastName = parLastName;
        this.parFirstName = parFirstName;
        this.phoneNumber = phoneNumber;
    }

    //region Getters et Setters

    public int getNumPar() {
        return numPar;
    }

    public void setNumPar(int numPar) {
        this.numPar = numPar;
    }

    public String getParLastName() {
        return parLastName;
    }

    public void setParLastName(String parLastName) {
        this.parLastName = parLastName;
    }

    public String getParFirstName() {
        return parFirstName;
    }

    public void setParFirstName(String parFirstName) {
        this.parFirstName = parFirstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //endregion

    /**
     * Override de toString pour afficher les informations du parent
     * @return String
     */
    @Override
    public String toString() {
        return "Parent N°" + this.numPar +
                "\tPrénom : " + this.parFirstName +
                "\tNom : " + this.parLastName +
                "\tTelephone : " + this.phoneNumber;
    }
}

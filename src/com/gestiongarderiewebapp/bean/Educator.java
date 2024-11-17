package com.gestiongarderiewebapp.bean;

import com.gestiongarderiewebapp.util.EducatorDegrees;

/**
 * Classe représentant une éducatrice qui est une employée
 */
public class Educator extends Employee {
    /**
     * Le diplôme de l'éducatrice
     */
    private EducatorDegrees degree;
    /**
     * Le nombre d'enfants pris en charge par l'éducatrice
     */
    private int nbrChildren;

    /**
     * Constructeur orienté coté code
     *
     * @param empLastName  Le nom de famille de l'éducatrice
     * @param empFirstName Le prénom de l'éducatrice
     * @param degree       Le diplôme de l'éducatrice
     * @param nbrChildren  Le nombre d'enfants pris en charge par l'éducatrice
     */
    public Educator(String empLastName, String empFirstName, EducatorDegrees degree, int nbrChildren) {
        super(empLastName, empFirstName);
        this.degree = degree;
        this.nbrChildren = nbrChildren;
    }

    /**
     * Constructeur orienté coté base de données
     *
     * @param numEmp       L'identifiant de l'éducatrice
     * @param empLastName  Le nom de famille de l'éducatrice
     * @param empFirstName Le prénom de l'éducatrice
     * @param degree       Le diplôme de l'éducatrice
     * @param nbrChildren  Le nombre d'enfants pris en charge par l'éducatrice
     */
    public Educator(int numEmp, String empLastName, String empFirstName, EducatorDegrees degree, int nbrChildren) {
        super(numEmp, empLastName, empFirstName);
        this.degree = degree;
        this.nbrChildren = nbrChildren;
    }

    //region Getters et Setters

    public EducatorDegrees getDegree() {
        return degree;
    }

    public void setDegree(EducatorDegrees degree) {
        this.degree = degree;
    }

    public int getNbrChildren() {
        return nbrChildren;
    }

    public void setNbrChildren(int nbrChildren) {
        this.nbrChildren = nbrChildren;
    }

    //endregion

    /**
     * Override de la méthode toString pour afficher les informations de l'éducatrice
     *
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() +
                "\tDiplôme : " + this.degree +
                "\tNombre enfants : " + this.nbrChildren;
    }
}

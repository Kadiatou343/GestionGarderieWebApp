package com.gestiongarderiewebapp.bean;

/**
 * Classe représentant un enfant de la garderie
 */
public class Child implements AssigningSection {
    /**
     * L'identifiant de l'enfant
     */
    private int numChild;
    /**
     * Le nom de famille de l'enfant
     */
    private String childLastName;
    /**
     * Le prénom de l'enfant
     */
    private String childFirstName;
    /**
     * L'âge de l'enfant
     */
    private int childAge;
    /**
     * Le parent responsable de l'enfant
     */
    private Parent parent;

    /**
     * Constructeur orienté coté code
     *
     * @param childLastName  Le nom de famille de l'enfant
     * @param childFirstName Le prénom de l'enfant
     * @param childAge       L'âge de l'enfant
     * @param parent         Le parent responsable de l'enfant
     */
    public Child(String childLastName, String childFirstName, int childAge, Parent parent) {
        this.childLastName = childLastName;
        this.childFirstName = childFirstName;
        this.childAge = childAge;
        this.parent = parent;
    }

    /**
     * Constructeur orienté coté base de données
     *
     * @param numChild       L'identifiant de l'enfant
     * @param childLastName  Le nom de famille de l'enfant
     * @param childFirstName Le prénom de l'enfant
     * @param childAge       L'âge de l'enfant
     * @param parent         Le parent responsable de l'enfant
     */
    public Child(int numChild, String childLastName, String childFirstName, int childAge, Parent parent) {
        this.numChild = numChild;
        this.childLastName = childLastName;
        this.childFirstName = childFirstName;
        this.childAge = childAge;
        this.parent = parent;
    }

    //region Getters et Setters

    public int getNumChild() {
        return numChild;
    }

    public void setNumChild(int numChild) {
        this.numChild = numChild;
    }

    public String getChildLastName() {
        return childLastName;
    }

    public void setChildLastName(String childLastName) {
        this.childLastName = childLastName;
    }

    public String getChildFirstName() {
        return childFirstName;
    }

    public void setChildFirstName(String childFirstName) {
        this.childFirstName = childFirstName;
    }

    public int getChildAge() {
        return childAge;
    }

    public void setChildAge(int childAge) {
        this.childAge = childAge;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    //endregion

    /**
     * Override de la méthode toString pour afficher les informations de l'enfant
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Enfant N°" + this.numChild +
                "\tPrénom : " + this.childFirstName +
                "\tNom : " + this.childLastName +
                "\tAge : " + this.childAge +
                "\n" + this.parent.toString();
    }

    /**
     * Override de la méthode assignSection pour affecter une section à l'enfant
     *
     * @param age L'âge de l'enfant
     * @return String
     */
    @Override
    public String assignSection(int age) {
        if (age < 1) {
            return "Poupon";
        } else if (age == 1) {
            return "Petite Section";
        } else if (age == 2) {
            return "Moyenne Section";
        } else if (age == 3) {
            return "Grande Section";
        } else if (age <= 5) {
            return "Préscolaire";
        } else {
            return "No Section Yet";
        }
    }
}

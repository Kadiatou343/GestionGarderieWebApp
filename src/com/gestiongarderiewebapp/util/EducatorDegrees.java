package com.gestiongarderiewebapp.util;

/**
 * Enumération représentant le type de diplôme que peut avoir une éducatrice
 */
public enum EducatorDegrees {
    DEC("DEC"),
    RSGE("RSGE");

    /**
     * La valeur des options
     */
    private final String value;

    /**
     * Constructeur privé
     * @param value La valeur des options de l'enumération
     */
    EducatorDegrees(String value) {
        this.value = value;
    }

    /**
     * Le getter pour récupérer la valeur associée
     * @return String
     */
    public String getValue(){
        return value;
    }
}

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

    /**
     * Obtenir l'option de l'enum à partir d'une chaine
     * @param value La valeur qu'on veut trouver parmi les valeurs de l'enum
     * @return EducatorDegrees
     * @throws IllegalArgumentException si aucune correspondance n'est trouvé
     */
    public static EducatorDegrees fromValue(String value){
        for (EducatorDegrees degree : EducatorDegrees.values()){
            if (degree.getValue().equalsIgnoreCase(value)){
                return degree;
            }
        }
        throw new IllegalArgumentException("No degree in EducatorDegrees for this value : " + value);
    }
}

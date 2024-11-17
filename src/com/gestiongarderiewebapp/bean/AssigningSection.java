package com.gestiongarderiewebapp.bean;

/**
 * Interface pour assigner section à un enfant
 */
public interface AssigningSection {
    /**
     * Signature de la méthode d'affectation de section à réécrir par la classe Child
     *
     * @param age L'âge de l'enfant
     * @return String
     */
    public String assignSection(int age);
}

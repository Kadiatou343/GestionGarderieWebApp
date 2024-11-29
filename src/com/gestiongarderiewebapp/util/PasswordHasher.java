package com.gestiongarderiewebapp.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHasher {
    // Nombre d'itérations PBKDF2
    private static final int ITERATIONS = 10000;

    // La taille du sel (bytes)
    private static final int SALT_SIZE = 16;

    // La taille de la clé d'encryptage (bits)
    private static final int KEY_SIZE = 256;

    //Le delimiteur du hash
    private static final String DELIMITER = ":";

    // Générer un sel aléatoire
    private static byte[] generateSalt() {
        SecureRandom rand = new SecureRandom();
        byte[] salt = new byte[SALT_SIZE];
        rand.nextBytes(salt);
        return salt;
    }

    // Méthode statique pour hasher le mot de passe
    public static String hashPassword(String unencrypedPassword) throws NoSuchAlgorithmException {
        byte[] salt = generateSalt();
        PBEKeySpec spec = new PBEKeySpec(unencrypedPassword.toCharArray(), salt, ITERATIONS, KEY_SIZE);
        SecretKeyFactory skf;

        try {
            skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            byte[] hash = skf.generateSecret(spec).getEncoded();

            String saltBase64 = Base64.getEncoder().encodeToString(salt);
            String hashBase64 = Base64.getEncoder().encodeToString(hash);

            return saltBase64 + DELIMITER + hashBase64;

        } catch (Exception e) {
            throw new NoSuchAlgorithmException("Erreur lors de la génération du hash : ", e);
        }
    }

    // Valider avec le hash stocké
    public static boolean validatePassword(String password, String passwordHash) throws NoSuchAlgorithmException {
        String[] parts = passwordHash.split(DELIMITER);

        String saltBase64 = parts[0];
        String passwordHashBase64 = parts[1];

        byte[] salt = Base64.getDecoder().decode(saltBase64);
        byte[] storedPasswordHash = Base64.getDecoder().decode(passwordHashBase64);

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_SIZE);
        SecretKeyFactory skf;

        try {
            skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] passwordHsh = skf.generateSecret(spec).getEncoded();

            return MessageDigest.isEqual(passwordHsh, storedPasswordHash);
        } catch (Exception e) {
            throw new NoSuchAlgorithmException("Erreur lors de la comparaison des mots de passe ", e);
        }
    }

//    public static void main(String[] args) {
//        try {
//            String password = "Jesuistresbelle";
//            String hashedPassword = hashPassword(password);
//            System.out.println("Mot de passé Hashe : " + hashedPassword);
//
//            boolean isValid = validatePassword(password, hashedPassword);
//            System.out.println("Validation " + isValid);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

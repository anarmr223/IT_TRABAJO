/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays; // Necesario para comparar arrays de bytes

/**
 *
 * @author Jose
 */
public class GestorContrasenias {
    private static final int LONG_SALT = 16;
    private MessageDigest md;
    
    public GestorContrasenias(){
        try{
            md = MessageDigest.getInstance("SHA-256");
        }catch(NoSuchAlgorithmException ex){
            throw new RuntimeException("Error al iniciar GestorHash: " + ex.getMessage());
        }
    }
    
    private byte[] hashPassword(String password){
        return md.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
    
    public String[] generarPasswordHash(String password){
        String [] passwordParam = new String[2];
        
        // Genera un salt nuevo para cada contraseña
        byte[] salt = generarSalt(); 
        
        // Calcula el hash con la contraseña y el salt
        byte[] hashedPassword = calcularHashConSalt(password, salt);
        
        passwordParam[0] = bytesToHex(hashedPassword);
        passwordParam[1] = bytesToHex(salt); // Almacena el salt en formato hexadecimal
        
        return passwordParam;
    }
    
    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    
    private byte[] hexToBytes(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < hex.length(); i += 2) {
            // Convierte cada par de caracteres hex a un byte.
            bytes[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                                 + Character.digit(hex.charAt(i + 1), 16));
        }
        return bytes;
    }
    
    private byte[] calcularHashConSalt(String data, byte[] salt) {
        // Reinicia el MessageDigest para asegurar que no haya datos de hashes anteriores
        md.reset(); 
        // Agrega el salt al hash
        md.update(salt); 
        // Calcula el hash de los datos (contraseña) con el salt añadido
        return md.digest(data.getBytes(StandardCharsets.UTF_8));
    }
    
    private byte[] generarSalt() {
        // SecureRandom es una fuente de números aleatorios criptográficamente fuertes,
        // esencial para la seguridad de los salts.
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[LONG_SALT];
        random.nextBytes(salt); // Rellena el array con bytes aleatorios seguros
        return salt;
    }
    
    public boolean verificarContrasenia(String contraseniaIngresada, String contraseniaAlmacenada, String saltAlmacenado){
        byte[] bSalt = hexToBytes(saltAlmacenado); // Convierte el salt de String a byte[]
        
        // Calcula el hash de la contraseña ingresada con el salt almacenado
        byte[] hashIngresado = calcularHashConSalt(contraseniaIngresada, bSalt);
        
        // Calcula el hash de la contraseña que está almacenada (supuestamente en la base de datos)
        // con el mismo salt. Este hash es el que debería coincidir.
        byte[] hashAlmacenado = hexToBytes(contraseniaAlmacenada);
        
        // Compara los dos arrays de bytes. Usamos Arrays.equals() para comparar el contenido.
        return Arrays.equals(hashIngresado, hashAlmacenado);
    }
}
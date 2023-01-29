package dev.gecontrol.api.domain.vo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class Password {
    private String passwordHash;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Password(String password) {
        this.passwordHash = encryptPassword(password);
        this.createdAt = LocalDateTime.now();
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}


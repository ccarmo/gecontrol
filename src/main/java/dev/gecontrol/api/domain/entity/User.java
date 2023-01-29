package dev.gecontrol.api.domain.entity;
import java.time.LocalDateTime;
import dev.gecontrol.api.domain.vo.*;
 

public class User {
    private final Name name;
    private final Email email;
    private final Password password;
    private final UserPermission permissions;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Status status;

    public User(Name name, Email email, Password password, UserPermission permissions) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.permissions = permissions;
        this.createdAt = LocalDateTime.now();
        this.status = status.ACTIVE;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }
    
    public Password getPassword() {
        return password;
    }
    
    public UserPermission getPermissions() {
        return permissions;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public Status getStatus() {
        return status;
    }
    
}



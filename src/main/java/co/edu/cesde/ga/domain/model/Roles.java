package co.edu.cesde.ga.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long rolesId;

    @NotBlank
    @Column(name = "role_name", nullable = false, length = 100)
    private String name;

    @NotBlank
    @Column(name = "role_description")
    private String description;

    @Column(name = "role_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "role_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Roles(String name, String description) {
        this.name = name;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Roles(Long roleId, String name, String description) {
        this.rolesId = roleId;
        this.name = name;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String toString() {
        return  "RoleId= " + getRolesId() + '\n' +
                "Name= " + getName() + '\n' +
                "Description= " + getDescription() + '\n' +
                "-----------------------------";
    }
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        if (createdAt == null) createdAt = now;
        if (updatedAt == null) updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}

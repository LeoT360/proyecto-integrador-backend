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
@Table(name = "programs")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Programs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private Long programId;

    @Column(name = "program_code", unique = true, nullable = false)
    private String code;

    @NotBlank
    @Column(name = "program_name", nullable = false, length = 100)
    private String name;

    @Column(name = "program_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "program_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Programs(String code, String name) {
        this.code = code;
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Programs(Long programId, String code, String name) {
        this.programId = programId;
        this.code = code;
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String toString() {
        return  "ProgramId= " + getProgramId() + '\n' +
                "Code= " + getCode() + '\n' +
                "Name= " + getName() + '\n' +
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

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
@Table(name = "subjects")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "subject_code", unique = true, nullable = false)
    private String code;

    @NotBlank
    @Column(name = "subject_name", nullable = false, length = 100)
    private String name;

    @Column(name = "subject_credits", unique = true, nullable = false)
    private Integer credits;

    @Column(name = "program_id")
    private Long programId;

    @Column(name = "subject_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "subject_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Subject(String code, String name, Integer credits, Long programId) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.programId = programId;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Subject(Long subjectId, String code, String name, Integer credits, Long programId) {
        this.subjectId = subjectId;
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.programId = programId;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String toString() {
        return  "SubjectId= " + getSubjectId() + '\n' +
                "Code= " + getCode() + '\n' +
                "Name= " + getName() + '\n' +
                "Credits= " + getCredits() + '\n' +
                "ProgramId= " + getProgramId() + '\n' +
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

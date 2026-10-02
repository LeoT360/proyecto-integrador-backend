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
@Table(name = "grades")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Long gradeId;

    @Column(name = "group_subject_id")
    private Long groupSubjectId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "grade_final_score")
    private Double finalScore;

    @NotBlank
    @Column(name = "grade_observation", nullable = false, length = 100)
    private String observation;

    @Column(name = "grade_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "grade_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Grades(Double finalScore, String observation) {
        this.finalScore = finalScore;
        this.observation = observation;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Grades(Long groupSubjectId, Long studentId, Double finalScore, String observation) {
        this.groupSubjectId = groupSubjectId;
        this.studentId = studentId;
        this.finalScore = finalScore;
        this.observation = observation;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String toString() {
        return  "GroupSubjectId= " + getGroupSubjectId() + '\n' +
                "StudentId= " + getStudentId() + '\n' +
                "FinalScore= " + getFinalScore() + '\n' +
                "Observation= " + getObservation() + '\n' +
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

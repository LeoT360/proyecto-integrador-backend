package co.edu.cesde.ga.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Enrollments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long enrollmentId;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "period_id")
    private String periodId;

    @Column(name = "enrollment_status")
    private String status;

    @Column(name = "enrollment_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "enrollment_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Enrollments(String studentId, String groupId, String periodId, String status) {
        this.studentId = studentId;
        this.groupId = groupId;
        this.periodId = periodId;
        this.status = status;
    }

    public Enrollments(Long enrollmentId, String studentId, String groupId, String periodId, String status) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.groupId = groupId;
        this.periodId = periodId;
        this.status = status;
    }

    public String toString() {
        return  "EnrollmentId= " + getEnrollmentId() + '\n' +
                "StudentId= " + getStudentId() + '\n' +
                "GroupId= " + getGroupId() + '\n' +
                "PeriodId= " + getPeriodId() + '\n' +
                "Status= " + getStatus() + '\n' +
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

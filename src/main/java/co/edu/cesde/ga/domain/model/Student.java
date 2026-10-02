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
@Table(name = "students")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @NotBlank
    @Column(name = "student_birth_date", nullable = false, length = 100)
    private String birthDate;

    @Column(name = "student_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "student_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Student(Long userId, String documentType, String documentNumber, String firstName, String lastName, String status, String birthDate) {
        super(userId, null, documentType, documentNumber, firstName, lastName, status);
    }

    public Student(Long studentId, String birthDate, Long userId, String code,String documentType, String documentNumber, String firstName, String lastName, String status) {
        super(userId, code, documentType, documentNumber, firstName, lastName, status);
        this.birthDate = birthDate;
        this.studentId = studentId;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String toString() {
        return  "StudentId= " + getStudentId() + '\n' +
                "UserId= " + getUserId() + '\n' +
                "DocumentNumber= " + getDocumentNumber() + '\n' +
                "DocumentType= " + getDocumentType() + '\n' +
                "FirstName= " + getFirstName() + '\n' +
                "LastName= " + getLastName() + '\n' +
                "BirthDate= " + getBirthDate() + '\n' +
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

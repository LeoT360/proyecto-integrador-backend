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
@Table(name = "teachers")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Teacher extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "teacher_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "teacher_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Teacher(Long userId, String code,String documentType, String documentNumber, String firstName, String lastName, String status) {
        super(userId, code, documentType, documentNumber, firstName, lastName, status);
    }

    public Teacher(Long teacherId,Long userId, String code,String documentType, String documentNumber, String firstName, String lastName, String status) {
        super(userId, code, documentType, documentNumber, firstName, lastName, status);
        this.teacherId = teacherId;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String toString() {
        return  "TeacherId= " + getTeacherId() + '\n' +
                "UserId= " + getUserId() + '\n' +
                "Code= " + getCode() + '\n' +
                "DocumentNumber= " + getDocumentNumber() + '\n' +
                "DocumentType= " + getDocumentType() + '\n' +
                "FirstName= " + getFirstName() + '\n' +
                "LastName= " + getLastName() + '\n' +
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

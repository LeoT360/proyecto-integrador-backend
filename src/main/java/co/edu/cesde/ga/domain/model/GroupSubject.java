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
@Table(name = "group_subjects")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class GroupSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_subject_id")
    private Long groupSubjectId;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "group_subject_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "group_subject_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public GroupSubject(Long groupId, Long subjectId, Long teacherId) {
        this.groupId = groupId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public GroupSubject(Long groupSubjectId, Long groupId, Long subjectId, Long teacherId) {
        this.groupSubjectId = groupSubjectId;
        this.groupId = groupId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String toString() {
        return  "GroupSubjectId= " + getGroupSubjectId() + '\n' +
                "GroupId= " + getGroupId() + '\n' +
                "SubjectId= " + getSubjectId() + '\n' +
                "TeacherId= " + getTeacherId() + '\n' +
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

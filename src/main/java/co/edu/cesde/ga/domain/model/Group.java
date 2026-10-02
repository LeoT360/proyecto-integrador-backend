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
@Table(name = "groups")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_code", unique = true, nullable = false)
    private String code;

    @Column(name = "program_id")
    private Long programId;

    @Column(name = "period_id")
    private Long periodId;

    @NotBlank
    @Column(name = "group_shift", nullable = false, length = 100)
    private String shift;

    @Column(name = "group_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "group_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Group(String code, Long programId, Long periodId, String shift) {
        this.code = code;
        this.programId = programId;
        this.periodId = periodId;
        this.shift = shift;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String toString() {
        return  "Code= " + getCode() + '\n' +
                "ProgramId= " + getProgramId() + '\n' +
                "PeriodId= " + getPeriodId() + '\n' +
                "Shift= " + getShift() + '\n' +
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

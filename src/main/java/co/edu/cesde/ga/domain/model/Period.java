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
@Table(name = "periods")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "period_id")
    private Long periodId;

    @Column(name = "period_code", unique = true, nullable = false)
    private String code;

    @NotBlank
    @Column(name = "period_start_date", nullable = false, length = 100)
    private String startDate;

    @NotBlank
    @Column(name = "period_end_date", nullable = false, length = 100)
    private String endDate;

    @Column(name = "period_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "period_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Period(String code, String startDate, String endDate) {
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Period(Long periodId, String code, String startDate, String endDate) {
        this.periodId = periodId;
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String toString() {
        return  "PeriodId= " + getPeriodId() + '\n' +
                "Code= " + getCode() + '\n' +
                "StartDate= " + getStartDate() + '\n' +
                "EndDate= " + getEndDate() + '\n' +
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

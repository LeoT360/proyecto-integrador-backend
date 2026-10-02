package co.edu.cesde.ga.application.dto.response;

import co.edu.cesde.ga.domain.model.Period;

public record CreatePeriodResponseDto(
        Long periodId,
        String code,
        String startDate,
        String endDate
) {

    public static CreatePeriodResponseDto fromPeriod(Period created) {
        return new CreatePeriodResponseDto(
                created.getPeriodId(),
                created.getCode(),
                created.getStartDate(),
                created.getEndDate()
        );
    }
}

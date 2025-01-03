package com.ssafy.enjoyTrip.domain.plan.dto.detail;

import com.ssafy.enjoyTrip.domain.plan.entity.Plan;
import com.ssafy.enjoyTrip.domain.plan.entity.PlanStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class PlanDetailsResponseDto {
    private Long planId;
    private String planTitle;
    private Long areaCode;
    private String sidoName;
    private String planProfileImg;
    private PlanStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<PlanDetailDayResponse> dayPlans;

    public static PlanDetailsResponseDto fromEntity(Plan plan, List<PlanDetailDayResponse> dayPlans) {
        return PlanDetailsResponseDto.builder()
                .planId(plan.getPlanId())
                .planTitle(plan.getPlanTitle())
                .areaCode(plan.getAreaCode())
                .sidoName(plan.getArea().getSidoName())
                .planProfileImg(plan.getPlanProfileImg())
                .status(plan.getStatus())
                .startDate(plan.getStartDate())
                .endDate(plan.getEndDate())
                .dayPlans(dayPlans)
                .build();
    }
}

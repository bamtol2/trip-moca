package com.ssafy.enjoyTrip.domain.plan.dto.detail;

import com.ssafy.enjoyTrip.domain.plan.entity.PlanDetail;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class PlanDetailResponseDto {
    private Long planDetailId;
    private Long attractionId;
    private String attractionTitle;  // 관광지 이름
    private String image;            // 관광지 이미지
    private String addr1;
    private String addr2;
    private Long contentTypeId;
    private String contentTypeName;
    private Integer day;
    private Integer sequence;
    private String memo;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static PlanDetailResponseDto fromEntity(PlanDetail detail) {
        return PlanDetailResponseDto.builder()
                .planDetailId(detail.getPlanDetailId())
                .attractionId(detail.getAttractionId())
                .attractionTitle(detail.getAttractions().getTitle())
                .image(detail.getAttractions().getImage1())
                .addr1(detail.getAttractions().getAddr1())
                .addr2(detail.getAttractions().getAddr2())
                .contentTypeId(detail.getAttractions().getContentTypeId())
                .contentTypeName(detail.getAttractions().getContentTypeName())
                .day(detail.getDay())
                .sequence(detail.getSequence())
                .memo(detail.getMemo())
                .latitude(detail.getAttractions().getLatitude())
                .longitude(detail.getAttractions().getLongitude())
                .createdAt(detail.getCreatedAt())
                .updatedAt(detail.getUpdatedAt())
                .build();
    }
}

package com.ssafy.enjoyTrip.domain.member.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberUpdateRequest {
    private String password;
    private String memberName;
    private String email;
    private String phone;
    private LocalDate birthDate;
}
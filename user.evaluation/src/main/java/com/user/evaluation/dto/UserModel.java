package com.user.evaluation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String jobDescription;

}

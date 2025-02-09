package com.user.evaluation.infrastructure.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String jobDescription;

}

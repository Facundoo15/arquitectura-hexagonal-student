package com.crymuzz.arquitecturahexsudent.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String address;
}

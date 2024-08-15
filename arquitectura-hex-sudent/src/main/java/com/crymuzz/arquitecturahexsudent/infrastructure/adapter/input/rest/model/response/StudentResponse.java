package com.crymuzz.arquitecturahexsudent.infrastructure.adapter.input.rest.model.response;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentResponse {

    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String address;


}

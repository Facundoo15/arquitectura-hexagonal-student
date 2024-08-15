package com.crymuzz.arquitecturahexsudent.infrastructure.adapter.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentCreateRequest {

    @NotBlank(message = "El campo NOMBRE no puede ser ni vacio, ni nulo")
    private String firstname;
    @NotBlank(message = "El campo no APELLIDO puede ser ni vacio, ni nulo")
    private String lastname;
    @NotNull(message = "El campo de EDAD no puede ser vacio")
    private Integer age;
    @NotEmpty(message = "El campo DIRECCIÓN no puede ser ni vacio, ni nulo")
    private String address;

}

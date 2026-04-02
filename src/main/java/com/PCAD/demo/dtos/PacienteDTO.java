package com.PCAD.demo.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {

    private UUID id;
    private String name;
    private int age;
    private String phone;


}

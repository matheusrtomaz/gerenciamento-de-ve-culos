package com.nassau.gerenciamentodeveiculos.entrypoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoResponseDTO {
    private Long id;
    private String modelo;
    private String placa;
    private int ano;

    // Getters e Setters
}
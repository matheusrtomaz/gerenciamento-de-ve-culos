package com.nassau.gerenciamentodeveiculos.service;

import com.nassau.gerenciamentodeveiculos.entrypoint.dto.*;


import java.util.List;
import java.util.Optional;

public interface VeiculoService {
    List<VeiculoResponseDTO> listarTodos();
    Optional<VeiculoResponseDTO> buscarPorId(Long id);
    VeiculoResponseDTO salvar(VeiculoRequestDTO veiculo);
    VeiculoResponseDTO atualizar(Long id, VeiculoRequestDTO veiculo);
    void deletar(Long id);
}
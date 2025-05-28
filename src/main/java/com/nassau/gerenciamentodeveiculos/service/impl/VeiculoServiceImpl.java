package com.nassau.gerenciamentodeveiculos.service.impl;



import com.nassau.gerenciamentodeveiculos.entity.VeiculoEntity;
import com.nassau.gerenciamentodeveiculos.entrypoint.dto.*;
import com.nassau.gerenciamentodeveiculos.repository.VeiculoEntityRepository;
import com.nassau.gerenciamentodeveiculos.service.VeiculoService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoEntityRepository repository;

    public VeiculoServiceImpl(VeiculoEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<VeiculoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VeiculoResponseDTO> buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toResponseDTO);
    }

    @Override
    public VeiculoResponseDTO salvar(VeiculoRequestDTO dto) {
        VeiculoEntity entity = new VeiculoEntity();
        entity.setModelo(dto.getModelo());
        entity.setPlaca(dto.getPlaca());
        entity.setAno(dto.getAno());

        VeiculoEntity salvo = repository.save(entity);
        return toResponseDTO(salvo);
    }

    @Override
    public VeiculoResponseDTO atualizar(Long id, VeiculoRequestDTO dto) {
        VeiculoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        entity.setModelo(dto.getModelo());
        entity.setPlaca(dto.getPlaca());
        entity.setAno(dto.getAno());

        VeiculoEntity atualizado = repository.save(entity);
        return toResponseDTO(atualizado);
    }


    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private VeiculoResponseDTO toResponseDTO(VeiculoEntity entity) {
        VeiculoResponseDTO dto = new VeiculoResponseDTO();
        dto.setId(entity.getId());
        dto.setModelo(entity.getModelo());
        dto.setPlaca(entity.getPlaca());
        dto.setAno(entity.getAno());
        return dto;
    }
}
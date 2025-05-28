package com.nassau.gerenciamentodeveiculos.entrypoint;

import com.nassau.gerenciamentodeveiculos.entrypoint.dto.*;
import com.nassau.gerenciamentodeveiculos.service.VeiculoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<VeiculoResponseDTO> listar() {
        return veiculoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> buscarPorId(@PathVariable Long id) {
        return veiculoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> criar(@RequestBody VeiculoRequestDTO veiculo) {
        VeiculoResponseDTO salvo = veiculoService.salvar(veiculo);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> atualizar(@PathVariable Long id, @RequestBody VeiculoRequestDTO veiculo) {
        VeiculoResponseDTO atualizado = veiculoService.atualizar(id, veiculo);
        return ResponseEntity.ok(atualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        veiculoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
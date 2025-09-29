package br.com.api.gerenciadortarefas.controller;

import br.com.api.gerenciadortarefas.model.Tarefa;
import br.com.api.gerenciadortarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tarefas") // Define o caminho base para todos os endpoints neste controller
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    // Endpoint para Criar uma nova tarefa [cite: 43]
    // URL: POST /tarefas [cite: 65]
    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa) {
        tarefa.setDataCriacao(LocalDate.now());
        Tarefa novaTarefa = tarefaRepository.save(tarefa);
        return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED);
    }

    // Endpoint para Listar todas as tarefas [cite: 45]
    // URL: GET /tarefas [cite: 63]
    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    // Endpoint para Buscar uma tarefa por ID [cite: 46]
    // URL: GET /tarefas/{id} [cite: 64]
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable String id) {
        return tarefaRepository.findById(id)
                .map(tarefa -> new ResponseEntity<>(tarefa, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para Atualizar uma tarefa existente [cite: 47]
    // URL: PUT /tarefas/{id} [cite: 66]
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable String id, @RequestBody Tarefa tarefaDetalhes) {
        return tarefaRepository.findById(id)
                .map(tarefaExistente -> {
                    tarefaExistente.setTitulo(tarefaDetalhes.getTitulo());
                    tarefaExistente.setDescricao(tarefaDetalhes.getDescricao());
                    tarefaExistente.setDataConclusao(tarefaDetalhes.getDataConclusao());
                    tarefaExistente.setStatus(tarefaDetalhes.getStatus());
                    Tarefa tarefaAtualizada = tarefaRepository.save(tarefaExistente);
                    return new ResponseEntity<>(tarefaAtualizada, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para Excluir uma tarefa [cite: 48]
    // URL: DELETE /tarefas/{id} [cite: 67]
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefaRepository.delete(tarefa);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
}
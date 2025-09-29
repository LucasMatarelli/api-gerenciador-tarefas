package br.com.api.gerenciadortarefas.repository;

import br.com.api.gerenciadortarefas.model.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends MongoRepository<Tarefa, String> {
    // A interface MongoRepository já contém os métodos para:
    // save() (para criar e atualizar) [cite: 43, 47]
    // findAll() (para listar) [cite: 45]
    // findById() (para buscar) [cite: 46]
    // deleteById() (para excluir) [cite: 48]
}
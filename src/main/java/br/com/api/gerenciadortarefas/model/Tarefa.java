package br.com.api.gerenciadortarefas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "tarefas") // Informa que esta classe corresponde a uma coleção no MongoDB
public class Tarefa {

    @Id
    private String id; // id: identificador único (gerado automaticamente) [cite: 50]

    private String titulo; // titulo: título da tarefa [cite: 51]
    private String descricao; // descricao: descrição detalhada [cite: 52]
    private LocalDate dataCriacao; // dataCriacao: data em que a tarefa foi criada [cite: 53]
    private LocalDate dataConclusao; // dataConclusao: data prevista para conclusão [cite: 54]
    private StatusTarefa status; // status: valores possíveis 

    // Getters e Setters (necessários para o Spring)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }
    public LocalDate getDataConclusao() { return dataConclusao; }
    public void setDataConclusao(LocalDate dataConclusao) { this.dataConclusao = dataConclusao; }
    public StatusTarefa getStatus() { return status; }
    public void setStatus(StatusTarefa status) { this.status = status; }
}
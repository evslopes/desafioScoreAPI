package jhhdev.api.score.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String telefone;
    private int score;

    private boolean ativo = true; // Para exclusão lógica
}

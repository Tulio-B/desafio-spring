package com.example.desafio.produto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @ElementCollection
    @CollectionTable(name = "produto_notas", joinColumns = @JoinColumn(
            name = "produto_id", nullable = false, foreignKey = @ForeignKey(name = "produto_notas_produto_fk")
    ))
    @Column(name = "nota")
    private final List<Double> nota = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Double> getNota() {
        return nota;
    }
}

package com.example.AcademySpring.Model;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Service
@Entity
@Table(name = "tb_professor")
public class ProfessorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private String email;

    private int cpf;

    private String nasc;

    private String modalidade;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private List<TreinoModel> treinos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public List<TreinoModel> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<TreinoModel> treinos) {
        this.treinos = treinos;
    }
}

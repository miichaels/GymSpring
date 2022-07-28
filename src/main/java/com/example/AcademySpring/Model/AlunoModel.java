package com.example.AcademySpring.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_aluno")
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Email(message = "Insira um email válido")
    private String email;

    private int cpf;

    private String nasc;

    private boolean lesao;

    @OneToOne
    private TreinoModel treino;

    @ManyToOne
    private ProfessorModel professor;

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

    public boolean isLesao() {
        return lesao;
    }

    public void setLesao(boolean lesao) {
        this.lesao = lesao;
    }

    public TreinoModel getTreino() {
        return treino;
    }

    public void setTreino(TreinoModel treino) {
        this.treino = treino;
    }

    public ProfessorModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) {
        this.professor = professor;
    }
}

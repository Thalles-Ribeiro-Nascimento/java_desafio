package domain;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Pessoa {
    /*
     * Atributos da classe. Privados para garantir o encapsulamento dos dados
     */
    private String nome;
    private LocalDate dataNascimento;

    /*
     * Construtor com parâmetros
     */
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    /*
     * Métodos Getters e Setters
     * */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int idadePessoa(){
        int anoAtual = LocalDate.now().getYear();
        int anoNascimentoFuncionario = this.dataNascimento.getYear();
        return anoAtual - anoNascimentoFuncionario;
    }

}

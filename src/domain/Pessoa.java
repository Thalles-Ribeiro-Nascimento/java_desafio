package domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Pessoa {
    /*
     * Atributos da classe. Privados para garantir o encapsulamento dos dados
     */
    private String nome;
    private LocalDateTime dataNascimento;

    /*
     * Construtor padrão
     */
    public Pessoa() {
    }

    /*
     * Construtor com parâmetros
     */
    public Pessoa(String nome, LocalDateTime dataNascimento) {
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

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int idadePessoa(){
        int anoAtual = LocalDateTime.now().getYear();
        int anoNascimentoFuncionario = this.dataNascimento.getYear();
        return anoAtual - anoNascimentoFuncionario;
    }


    /*
     * Métodos Equals - verifica se dois objetos são iguais
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pessoa pessoa)) return false;
        return Objects.equals(nome, pessoa.nome);
    }

    /*
     * Métodos HashCode - Cria um número do tipo Inteiro para representar um objeto da classe Pessoa
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}

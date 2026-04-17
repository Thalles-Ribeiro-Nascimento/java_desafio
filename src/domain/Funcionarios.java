package domain;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class Funcionarios extends Pessoa {

    private double salario;
    private String funcao;

    public Funcionarios(String nome, LocalDate dataNascimento, double salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void aumentoSalarial(){
        this.salario = this.salario + (this.salario * 0.1);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = sdf.format(Date.from(this.getDataNascimento().atStartOfDay().toInstant(ZoneOffset.UTC)));
        return String.format("Nome: %s%n" +
                "Data de nascimento: %s%n" +
                "Salário: R$ %,.2f%n" +
                "Função: %s%n",
                getNome(),
                dataFormatada,
                getSalario(),
                getFuncao());
    }
}

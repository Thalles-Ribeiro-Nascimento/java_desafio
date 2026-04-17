import domain.Funcionarios;
import domain.Pessoa;

import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        print("Bem-vindos ao meu teste prático Iniflex!");
//      Usei ArrayList por ser mais rápido com leituras, o que é feito majoritariamente nessa aplicação
        List<Funcionarios> funcionariosList = new ArrayList<>();

//      Instância de Funcionários
        Funcionarios maria, joao, caio, miguel, alice, heitor, arthur, laura, heloisa, helena;

        maria = new Funcionarios(
                "Maria",
                LocalDate.of(2000, 10, 18).atStartOfDay(),
                2009.44,
                "Operador"
                );

        joao = new Funcionarios(
                "João",
                LocalDate.of(1990, 5, 12).atStartOfDay(),
                2284.38,
                "Operador"
        );

        caio = new Funcionarios(
                "Caio",
                LocalDate.of(1961, 5, 2).atStartOfDay(),
                9836.14,
                "Coordenador"
        );

        miguel = new Funcionarios(
                "Miguel",
                LocalDate.of(1988, 10, 14).atStartOfDay(),
                19119.88,
                "Diretor"
        );

        alice = new Funcionarios(
                "Alice",
                LocalDate.of(1995, 1, 5).atStartOfDay(),
                2234.68,
                "Recepcionista"
        );

        heitor = new Funcionarios(
                "Heitor",
                LocalDate.of(1999, 11, 19).atStartOfDay(),
                1582.72,
                "Operador"
        );

        arthur = new Funcionarios(
                "Arthur",
                LocalDate.of(1993, 3, 31).atStartOfDay(),
                4071.84,
                "Contador"
        );

        laura = new Funcionarios(
                "Laura",
                LocalDate.of(1994, 7, 8).atStartOfDay(),
                3017.45,
                "Gerente"
        );

        heloisa = new Funcionarios(
                "Heloísa",
                LocalDate.of(2003, 5, 24).atStartOfDay(),
                1606.85,
                "Eletricista"
        );

        helena = new Funcionarios(
                "Helena",
                LocalDate.of(1996, 9, 2).atStartOfDay(),
                2799.93,
                "Gerente"
        );

        /*
        * Inserindo os funcionários na Lista: 3.1
        */
        funcionariosList.add(maria);
        funcionariosList.add(joao);
        funcionariosList.add(caio);
        funcionariosList.add(miguel);
        funcionariosList.add(alice);
        funcionariosList.add(heitor);
        funcionariosList.add(arthur);
        funcionariosList.add(laura);
        funcionariosList.add(heloisa);
        funcionariosList.add(helena);

        /*
        * Removendo o João: 3.2
        */
        funcionariosList.remove(joao);

        /*
         * Imprimir todos os funcionários: 3.3
         */
        print("Imprimir todos os funcionários com todas suas informações.");
        for (Funcionarios funcionario : funcionariosList){
            System.out.println(funcionario);
        }


        /*
         * Aumento de 10% para os funcionários: 3.4
         */
        for (Funcionarios funcionario : funcionariosList){
            funcionario.aumentoSalarial();
        }

        /*
         * Agrupando os Funcionários por Função: 3.5 e 3.6
         */
        print("Imprimir os funcionários, agrupados por função.");
        Map<String, List<Funcionarios>> funcionariosPorFuncao = funcionariosList.stream().collect(Collectors.groupingBy(Funcionarios::getFuncao));
        funcionariosPorFuncao.forEach((funcao, funcionarios) -> {
            System.out.printf("%s -> ", funcao);
            System.out.println(funcionarios);
        });


        /*
         * Todos os funcionários que fazem aniversário nos meses 10 e 12: (3.8) 3.7
         */
        print("Imprimir os funcionários que fazem aniversário no mês 10 e 12.");
        for (Funcionarios funcionario : funcionariosList){
            if (funcionario.getDataNascimento().getMonthValue() == 10 || funcionario.getDataNascimento().getMonthValue() == 12){
                System.out.println(funcionario);

            }
        }


        /*
         * Funcionário mais velho: (3.9) 3.8
         */
        print("Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.");
        funcionariosList.sort(Comparator.comparing(Pessoa::idadePessoa).reversed());
        System.out.printf("Nome: %s%n" +
                "Idade: %d%n",
                funcionariosList.get(0).getNome(),
                funcionariosList.get(0).idadePessoa());


        /*
         * Lista de funcionários ordenada por ordem alfabética: (3.10) 3.9
         */
        print("Imprimir a lista de funcionários por ordem alfabética.");
        funcionariosList.sort(Comparator.comparing(Pessoa::getNome));
        for (Funcionarios funcionario : funcionariosList){
                System.out.println(funcionario);

        }



        /*
        * Apliquei a programação Funcional para resolver o requisito: (3.11) 3.10
        */
        print("Imprimir o total dos salários dos funcionários.");
        double salarioTotal = funcionariosList.stream().map(funcionario -> funcionario.getSalario())
                .reduce(0.0, (salarioInicial, salario) -> salarioInicial + salario);

        System.out.printf("Salário total: R$ %,.2f", salarioTotal);


        /*
         *  Quantidade de salários mínimos por funcionário: (3.12) 3.11
         */
        print("Imprimir quantos salários mínimos ganha cada funcionário.");
        for (Funcionarios funcionario : funcionariosList){
            double minimoPorFuncionario = funcionario.getSalario() / 1212.00;

            if (minimoPorFuncionario < 0.0){
                System.out.printf("Funcionário: %s recebe menos que um salário mínimo", funcionario.getNome());
            }
            System.out.printf("Funcionário: %s%n" +
                    "Salários mínimos: %.1f%n", funcionario.getNome(), minimoPorFuncionario);
            System.out.println();
        }

    }

    public static void print(String mesagem){
        System.out.printf("%n=================== %s ===================%n", mesagem);
    }

}



import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UniqueNameManager {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            Set<String> names = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

            System.out.println("Digite os nomes (digite 'fim' para encerrar):");

            // 1. Fase de Inserção de Dados
            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine().trim();

                // Ignora entradas vazias (caso o usuário aperte Enter sem querer)
                if (input.isEmpty()) {
                    continue;
                }

                if (input.equalsIgnoreCase("fim")) {
                    break; 
                }

                names.add(input);
            }

            System.out.println("\nNomes cadastrados:");
            System.out.println(names);

            System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

            // 2. Fase de Busca e Verificação
            while (true) {
                System.out.print("> ");
                String searchItem = scanner.nextLine().trim();

                if (searchItem.isEmpty()) {
                    continue;
                }

                if (searchItem.equalsIgnoreCase("sair")) {
                    break;
                }

                if (names.contains(searchItem)) {
                    System.out.println("Nome encontrado.");
                } else {
                    System.out.println("Nome não encontrado.");
                }
            }
        }
    }
}

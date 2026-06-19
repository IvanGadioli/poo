import java.util.Scanner;
import java.util.TreeSet;

public class EliminaNomes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }

            if (!entrada.isEmpty()) {
                boolean adicionado = nomes.add(entrada);
                if (!adicionado) {
                    System.out.println("Nome já cadastrado, ignorando duplicata.");
                }
            }
        }

        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

        while (true) {
            System.out.print("> ");
            String busca = scanner.nextLine().trim();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            if (nomes.contains(busca)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
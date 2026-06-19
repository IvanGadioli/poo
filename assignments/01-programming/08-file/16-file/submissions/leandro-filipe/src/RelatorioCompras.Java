import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java RelatorioCompras <caminho_entrada> <caminho_saida>");
            return;
        }

        Path entrada = Paths.get(args[0]);
        Path saida = Paths.get(args[1]);

        // Listas paralelas conforme requisito
        List<String> nomesClientes = new ArrayList<>();
        List<Double> totaisCompras = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(entrada);

            for (String linha : linhas) {
                String[] partes = linha.split(",");

                // Validação de formato (mínimo 3 campos: nome, produto, valor)
                if (partes.length < 3) {
                    continue; 
                }

                try {
                    String nome = partes[0].trim();
                    double valor = Double.parseDouble(partes[2].trim());

                    // Lógica de acumulação em listas paralelas
                    int index = nomesClientes.indexOf(nome);
                    if (index == -1) {
                        nomesClientes.add(nome);
                        totaisCompras.add(valor);
                    } else {
                        double novoTotal = totaisCompras.get(index) + valor;
                        totaisCompras.set(index, novoTotal);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter valor na linha: " + linha);
                }
            }

            // Preparação dos dados para escrita
            List<String> relatorio = new ArrayList<>();
            for (int i = 0; i < nomesClientes.size(); i++) {
                relatorio.add(nomesClientes.get(i) + ": " + totaisCompras.get(i));
            }

            Files.write(saida, relatorio);
            System.out.println("Relatório gerado com sucesso em: " + saida.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Erro ao processar arquivos: " + e.getMessage());
        }
    }
}
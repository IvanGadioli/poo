import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ManipulacaoArquivos {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Uso: java ManipulacaoArquivos <entrada> <saida>");
            return;
        }

        Path entrada = Path.of(args[0]);
        Path saida = Path.of(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            List<String> linhas = Files.readAllLines(entrada);

            for (String linha : linhas) {

                String[] partes = linha.split(",");

                if (partes.length < 3) {
                    continue;
                }

                String cliente = partes[0].trim();

                try {
                    double valor = Double.parseDouble(partes[2].trim());

                    int posicao = clientes.indexOf(cliente);

                    if (posicao == -1) {
                        clientes.add(cliente);
                        totais.add(valor);
                    } else {
                        double totalAtual = totais.get(posicao);
                        totais.set(posicao, totalAtual + valor);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido: " + linha);
                }
            }

            ArrayList<String> relatorio = new ArrayList<>();

            for (int i = 0; i < clientes.size(); i++) {
                relatorio.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(saida, relatorio);

            System.out.println("Relatório criado com sucesso.");

        } catch (IOException e) {
            System.out.println("Erro ao processar arquivo: " + e.getMessage());
        }
    }
}
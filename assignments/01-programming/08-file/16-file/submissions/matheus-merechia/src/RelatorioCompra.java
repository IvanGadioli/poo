import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompra {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java RelatorioCompra <arquivo-entrada> <arquivo-saida>");
            return;
        }

        Path caminhoEntrada = Paths.get(args[0]);
        Path caminhoSaida = Paths.get(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        List<String> linhas;
        try {
            linhas = Files.readAllLines(caminhoEntrada);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de entrada: " + e.getMessage());
            return;
        }

        for (String linha : linhas) {
            String[] campos = linha.split(",");

            if (campos.length < 3) {
                continue;
            }

            String nomeCliente = campos[0].trim();
            String valorStr = campos[2].trim();

            double valor;
            try {
                valor = Double.parseDouble(valorStr);
            } catch (NumberFormatException e) {
                continue;
            }

            int indice = clientes.indexOf(nomeCliente);
            if (indice >= 0) {
                totais.set(indice, totais.get(indice) + valor);
            } else {
                clientes.add(nomeCliente);
                totais.add(valor);
            }
        }

        ArrayList<String> linhasSaida = new ArrayList<>();
        for (int i = 0; i < clientes.size(); i++) {
            linhasSaida.add(clientes.get(i) + ": " + totais.get(i));
        }

        try {
            Files.write(caminhoSaida, linhasSaida);
            System.out.println("Relatório gerado com sucesso: " + caminhoSaida);
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo de saída: " + e.getMessage());
        }
    }
}

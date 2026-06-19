import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PurchaseReport {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java PurchaseReport <arquivo-entrada> <arquivo-saida>");
            return;
        }

        Path inputPath = Path.of(args[0]);
        Path outputPath = Path.of(args[1]);

        ArrayList<String> clients = new ArrayList<>();
        ArrayList<Double> totals = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(inputPath);

            for (String line : lines) {
                String[] parts = line.split(",");

                if (parts.length < 3) {
                    continue;
                }

                String clientName = parts[0].trim();
                double value;

                try {
                    value = Double.parseDouble(parts[2].trim());
                } catch (NumberFormatException e) {
                    continue;
                }

                int index = clients.indexOf(clientName);
                if (index >= 0) {
                    totals.set(index, totals.get(index) + value);
                } else {
                    clients.add(clientName);
                    totals.add(value);
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        StringBuilder report = new StringBuilder();
        for (int i = 0; i < clients.size(); i++) {
            report.append(clients.get(i)).append(": ").append(totals.get(i)).append("\n");
        }

        try {
            Files.writeString(outputPath, report.toString());
            System.out.println("Relatório gerado com sucesso em: " + outputPath);
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
        }
    }
}
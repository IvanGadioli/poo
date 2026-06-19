import java.util.HashMap;
import java.util.Map;

public class HashMapApp {

    public static void main(String[] args) {

        // **Associar Chave ao Valor**
        System.out.println("1. Associar Chave ao Valor");
        HashMap<String, String> cores = new HashMap<>();
        cores.put("001", "Vermelho");
        cores.put("002", "Verde");
        cores.put("003", "Azul");
        cores.put("004", "Amarelo");
        cores.put("005", "Roxo");
        cores.put("006", "Laranja");
        System.out.println("HashMap após associar chaves e valores: " + cores);

        // **Contar Pares Chave-Valor**
        System.out.println("\n2. Contar Pares Chave-Valor");
        System.out.println("Quantidade de pares chave-valor: " + cores.size());

        // **Copiar Associações para Outro Mapa**
        System.out.println("\n3. Copiar Associações para Outro Mapa");
        HashMap<String, String> mapaDestino = new HashMap<>();
        mapaDestino.put("007", "Rosa");
        mapaDestino.putAll(cores);
        System.out.println("Mapa destino após copiar associações: " + mapaDestino);

        // **Remover Todas as Associações**
        System.out.println("\n4. Remover Todas as Associações");
        HashMap<String, String> mapaTemp = new HashMap<>(cores);
        mapaTemp.clear();
        System.out.println("HashMap após remover todas as associações: " + mapaTemp);
        System.out.println("(Mapa de trabalho preservado: " + cores + ")");

        // **Verificar se o Mapa está Vazio**
        System.out.println("\n5. Verificar se o Mapa está Vazio");
        System.out.println("'cores' está vazio? " + cores.isEmpty());
        System.out.println("'mapaTemp' está vazio? " + mapaTemp.isEmpty());

        // **Obter Cópia Superficial**
        System.out.println("\n6. Obter Cópia Superficial");
        @SuppressWarnings("unchecked")
        HashMap<String, String> mapaClonado = (HashMap<String, String>) cores.clone();
        System.out.println("Mapa original: " + cores);
        System.out.println("Mapa clonado:  " + mapaClonado);

        // **Verificar se Chave Existe**
        System.out.println("\n7. Verificar se Chave Existe");
        System.out.println("Contém a chave '003'? " + cores.containsKey("003"));
        System.out.println("Contém a chave '999'? " + cores.containsKey("999"));

        // **Verificar se Valor Existe**
        System.out.println("\n8. Verificar se Valor Existe");
        System.out.println("Contém o valor 'Azul'? " + cores.containsValue("Azul"));
        System.out.println("Contém o valor 'Ciano'? " + cores.containsValue("Ciano"));

        // **Obter Visão em Set dos Pares**
        System.out.println("\n9. Obter Visão em Set dos Pares");
        System.out.println("EntrySet:");
        for (Map.Entry<String, String> entrada : cores.entrySet()) {
            System.out.println("  " + entrada.getKey() + " -> " + entrada.getValue());
        }

        // **Obter Valor pela Chave**
        System.out.println("\n10. Obter Valor pela Chave");
        System.out.println("Valor da chave '001': " + cores.get("001"));
        System.out.println("Valor da chave '004': " + cores.get("004"));

        // **Obter Conjunto de Chaves**
        System.out.println("\n11. Obter Conjunto de Chaves");
        System.out.println("KeySet: " + cores.keySet());

        // **Obter Coleção de Valores**
        System.out.println("\n12. Obter Coleção de Valores");
        System.out.println("Values: " + cores.values());
    }
}

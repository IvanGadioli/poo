import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapApp {

    public static void main(String[] args) {

        // **Associar Valor à Chave**
        System.out.println("1. Associar Valor à Chave");
        TreeMap<String, String> cores = new TreeMap<>();
        cores.put("001", "Vermelho");
        cores.put("002", "Verde");
        cores.put("003", "Azul");
        cores.put("004", "Amarelo");
        cores.put("005", "Roxo");
        cores.put("006", "Laranja");
        cores.put("007", "Rosa");
        cores.put("008", "Marrom");
        System.out.println("TreeMap após associar chaves e valores: " + cores);

        // **Copiar TreeMap**
        System.out.println("\n2. Copiar TreeMap");
        TreeMap<String, String> mapaCopiado = new TreeMap<>(cores);
        System.out.println("TreeMap copiado: " + mapaCopiado);

        // **Buscar Chave**
        System.out.println("\n3. Buscar Chave");
        System.out.println("Contém a chave '003'? " + cores.containsKey("003"));
        System.out.println("Contém a chave '999'? " + cores.containsKey("999"));

        // **Buscar Valor**
        System.out.println("\n4. Buscar Valor");
        System.out.println("Contém o valor 'Azul'? " + cores.containsValue("Azul"));
        System.out.println("Contém o valor 'Ciano'? " + cores.containsValue("Ciano"));

        // **Obter Todas as Chaves**
        System.out.println("\n5. Obter Todas as Chaves");
        System.out.println("Conjunto de chaves: " + cores.keySet());

        // **Limpar TreeMap**
        System.out.println("\n6. Limpar TreeMap");
        TreeMap<String, String> mapaTemp = new TreeMap<>(cores);
        mapaTemp.clear();
        System.out.println("TreeMap após limpar: " + mapaTemp);
        System.out.println("(Mapa de trabalho preservado: " + cores + ")");

        // **Ordenar Chaves com Comparator**
        System.out.println("\n7. Ordenar Chaves com Comparator");
        TreeMap<String, String> mapaOrdenado = new TreeMap<>(Comparator.reverseOrder());
        mapaOrdenado.putAll(cores);
        System.out.println("Chaves ordenadas em ordem reversa com Comparator: " + mapaOrdenado.keySet());

        // **Maior e Menor Mapeamento**
        System.out.println("\n8. Maior e Menor Mapeamento");
        System.out.println("Par com a maior chave: " + cores.lastEntry());
        System.out.println("Par com a menor chave: " + cores.firstEntry());

        // **Obter Primeira e Última Chave**
        System.out.println("\n9. Obter Primeira e Última Chave");
        System.out.println("Menor chave: " + cores.firstKey());
        System.out.println("Maior chave: " + cores.lastKey());

        // **Visão das Chaves em Ordem Reversa**
        System.out.println("\n10. Visão das Chaves em Ordem Reversa");
        System.out.println("Chaves em ordem reversa: " + cores.descendingKeySet());

        // **Floor Entry**
        System.out.println("\n11. Floor Entry");
        System.out.println("Par com a maior chave <= '004': " + cores.floorEntry("004"));
        System.out.println("Par com a maior chave <= '003': " + cores.floorEntry("003"));

        // **Floor Key**
        System.out.println("\n12. Floor Key");
        System.out.println("Maior chave <= '005': " + cores.floorKey("005"));
        System.out.println("Maior chave <= '004': " + cores.floorKey("004"));

        // **Head Map (Exclusivo)**
        System.out.println("\n13. Head Map (Exclusivo)");
        System.out.println("Pares com chaves estritamente menores que '004': " + cores.headMap("004"));

        // **Head Map (Com Opção Inclusiva)**
        System.out.println("\n14. Head Map (Com Opção Inclusiva)");
        System.out.println("Pares com chaves < '004' (exclusivo):  " + cores.headMap("004", false));
        System.out.println("Pares com chaves <= '004' (inclusivo): " + cores.headMap("004", true));

        // **Higher Key**
        System.out.println("\n15. Higher Key");
        System.out.println("Menor chave estritamente maior que '004': " + cores.higherKey("004"));
        System.out.println("Menor chave estritamente maior que '006': " + cores.higherKey("006"));

        // **Lower Entry**
        System.out.println("\n16. Lower Entry");
        System.out.println("Par com a maior chave estritamente menor que '005': " + cores.lowerEntry("005"));
        System.out.println("Par com a maior chave estritamente menor que '003': " + cores.lowerEntry("003"));

        // **Lower Key**
        System.out.println("\n17. Lower Key");
        System.out.println("Maior chave estritamente menor que '005': " + cores.lowerKey("005"));
        System.out.println("Maior chave estritamente menor que '002': " + cores.lowerKey("002"));

        // **Visão NavigableSet**
        System.out.println("\n18. Visão NavigableSet");
        NavigableSet<String> navigableSet = cores.navigableKeySet();
        System.out.println("NavigableSet das chaves: " + navigableSet);

        // **Remover e Retornar o Primeiro Par**
        System.out.println("\n19. Remover e Retornar o Primeiro Par");
        TreeMap<String, String> mapaParaPoll = new TreeMap<>(cores);
        System.out.println("TreeMap antes do pollFirstEntry: " + mapaParaPoll);
        System.out.println("Primeiro par removido: " + mapaParaPoll.pollFirstEntry());
        System.out.println("TreeMap após pollFirstEntry: " + mapaParaPoll);

        // **Remover e Retornar o Último Par**
        System.out.println("\n20. Remover e Retornar o Último Par");
        System.out.println("TreeMap antes do pollLastEntry: " + mapaParaPoll);
        System.out.println("Último par removido: " + mapaParaPoll.pollLastEntry());
        System.out.println("TreeMap após pollLastEntry: " + mapaParaPoll);

        // **SubMap (Inclusivo até Exclusivo)**
        System.out.println("\n21. SubMap (Inclusivo até Exclusivo)");
        System.out.println("Pares com chaves de '002' (inclusivo) até '006' (exclusivo): " + cores.subMap("002", "006"));

        // **SubMap (Intervalo Configurável)**
        System.out.println("\n22. SubMap (Intervalo Configurável)");
        System.out.println("Pares de '002' (inclusivo) até '006' (inclusivo): " + cores.subMap("002", true, "006", true));
        System.out.println("Pares de '002' (exclusivo) até '006' (exclusivo): " + cores.subMap("002", false, "006", false));

        // **TailMap (Inclusivo)**
        System.out.println("\n23. TailMap (Inclusivo)");
        System.out.println("Pares com chaves >= '005': " + cores.tailMap("005"));

        // **TailMap (Exclusivo)**
        System.out.println("\n24. TailMap (Exclusivo)");
        System.out.println("Pares com chaves estritamente > '005': " + cores.tailMap("005", false));

        // **Ceiling Entry**
        System.out.println("\n25. Ceiling Entry");
        System.out.println("Par com a menor chave >= '004': " + cores.ceilingEntry("004"));
        System.out.println("Par com a menor chave >= '005': " + cores.ceilingEntry("005"));

        // **Ceiling Key**
        System.out.println("\n26. Ceiling Key");
        System.out.println("Menor chave >= '003': " + cores.ceilingKey("003"));
        System.out.println("Menor chave >= '006': " + cores.ceilingKey("006"));
    }
}
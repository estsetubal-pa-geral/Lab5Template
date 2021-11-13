package pt.pa.adts;
import com.brunomnsilva.smartgraph.graph.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MapCities{
    private Graph<City, Integer> map;

    public MapCities() {
        map = new GraphEdgeList<>();
    }

    /**
     * Considera-se como dimensão do grafo o número de vértices
     * @return
     */
    public int size() {
        return map.numVertices();
    }

    /**
     * Returns the graph
     * @return
     */
    public Graph<City, Integer> getMap() {
        return map;
    }

    /**
     * Checks if a city exist in an Iterable
     * @param list to check
     * @param city to find
     * @return a boolean
     */
    public boolean exists(Iterable<City> list, String city) {
        for(City item: list)
            if (item.getCity().equals(city))
                return true;
        return false;
    }

    public void load(String filepath) throws FileNotFoundException {
        map = new GraphEdgeList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            int indexStart=0, indexEnd=0, indexDistance=0;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.trim().split( " ");
                switch(tokens.length) {
                    case 1: // (Ex: Abrantes) Apenas uma cidade (um vértice)

                    case 2: // (Ex: Faro 2  ) Uma cidade e a distância para si própria (A ligação a implementar será Faro-->Faro 2kms)

                    case 3: // (Ex: Viseu Coimbra 95)
                }
                // Add Cities and Connection, if not exists
            }
        } catch (IOException e) {
            throw new FileNotFoundException(String.format("The file %s does not seem to exist.", filepath));
        }
    }


    /**
     *
     * @return os compontes do grafo como uma string detalhada no conjunto dos vértices e arestas.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MapCities ");
        sb.append("\n\tVertices { ");
        for(Vertex<City> city: map.vertices())
            sb.append(city.element()+" ");
        sb.append("}");
        sb.append("\n\tEdges { ");
        for(Edge<Integer, City> edge : map.edges())
            sb.append("[" + edge.vertices()[0].element() + "-->" + edge.vertices()[1].element()+"] ");
        sb.append("}");
        return sb.toString();
    }
}


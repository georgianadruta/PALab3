package optional.visiting;

import optional.locations.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * assume that the locations are linked to each other
 * ShortestPath class aims to determine the minimum cost path between two locations according to preferences
 */
public class ShortestPath {
    private List<Location> locations;
    private ArrayList<Integer> path;
    private int[][] costMatrix;
    private Map<String, Integer> preferenceList;
    private int[] distances;
    private int[] parents;
    private boolean[] visited;

    /**
     * constructor
     *
     * @param locations      list of locations from the same city
     * @param preferenceList visitor's preferences
     */
    public ShortestPath(ArrayList<Location> locations, Map<String, Integer> preferenceList) {
        this.locations = locations;
        this.visited = new boolean[locations.size()];
        this.parents = new int[locations.size()];
        this.distances = new int[locations.size()];
        for (int i = 0; i < locations.size(); i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        this.preferenceList = new HashMap<>(preferenceList);
    }

    /**
     * dijkstra method. search the shortest path between two locations and display the path and the cost.
     *
     * @param source      the start location
     * @param destination the end location
     */
    public void getMinDistance(Location source, Location destination) {
        int startVertex = locations.indexOf(source);
        this.path = new ArrayList<>(startVertex);
        int endVertex = locations.indexOf(destination);
        createCostMatrix();
        distances[startVertex] = 0;
        parents[startVertex] = -1;
        getDistances(startVertex);
        printSolution(startVertex, endVertex, distances, parents);
    }

    /**
     * find the best path between any two locations and save the cost for the current location in distances array.
     * in the end the parents array will be contained the shortest path passing through each location
     */
    private void getDistances(int startVertex) {
        for (int i = 0; i < locations.size(); i++) {
            int vertex_U = getMinimumVertex(visited, distances,startVertex);
            visited[vertex_U] = true;
            for (int vertex_V = 0; vertex_V < locations.size(); vertex_V++) {
                if (!visited[vertex_V] && costMatrix[vertex_U][vertex_V] > 0 && distances[vertex_U] != Integer.MAX_VALUE && costMatrix[vertex_U][vertex_V] + distances[vertex_U] < distances[vertex_V]) {
                    if (!visited[vertex_V] && costMatrix[vertex_U][vertex_V] != Integer.MAX_VALUE) {
                        parents[vertex_V] = vertex_U;
                        distances[vertex_V] = distances[vertex_U] + costMatrix[vertex_U][vertex_V];
                    }
                }
            }
        }
    }

    /**
     * print the path and the cost
     *
     * @param startVertex the start location
     * @param endVertex   the end location
     * @param distances   the cost between start location and each location. the position i from distance array represents the location i from list locations
     * @param parents     the shortest path passing through each location.
     */
    private void printSolution(int startVertex, int endVertex, int[] distances, int[] parents) {
        System.out.println("The shortest path from " + locations.get(startVertex).getName() + " to " + locations.get(endVertex).getName() + " is:");
        printPath(endVertex, parents);
        System.out.println("cost = " + distances[endVertex + 1]);
    }

    /**
     * print recursively the path between start location and end location
     *
     * @param currentVertex current location from path
     * @param parents       the shortest path passing through each location.
     */
    private void printPath(int currentVertex, int[] parents) {
        if (currentVertex == -1) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(locations.get(currentVertex).getName() + " --> ");
    }

    /**
     * found the best location with the minimum cost between current location and this location
     * if it founds two locations with the same cost will be choose the location with the smallest order number from preferences
     *
     * @param visited  a boolean array. visited[i]=true if i location was visited, else false
     * @param distance the cost between start location and each location. the position i from distance array represents the location i from list locations
     * @return the number of location with the smallest cost
     */
    private int getMinimumVertex(boolean[] visited, int[] distance,int startVertex) {
        int minKey = Integer.MAX_VALUE, vertex = startVertex;
        for (int i = 0; i < locations.size(); i++) {
            if (!visited[i]) {
                if (minKey == distance[i]) {
                    if (this.preferenceList.get(this.locations.get(vertex).getName()) < this.preferenceList.get(this.locations.get(i).getName())) {
                        minKey = distance[vertex];
                    } else {
                        vertex = i;
                        minKey = distance[i];
                    }
                } else if (minKey > distance[i]) {
                    minKey = distance[i];
                    vertex = i;
                }
            }
        }
        return vertex;
    }

    /**
     * create an adjacency matrix based on each map of the locations
     * instead of 1 between two adjacent locations will be the cost
     */
    private void createCostMatrix() {
        List<String> name = new ArrayList<>();
        for (Location source : this.locations) {
            name.add(source.getName());
        }
        this.costMatrix = new int[this.locations.size()][this.locations.size()];
        for (Location source : this.locations) {
            Map<Location, Integer> cost = source.getCost();
            for (Map.Entry<Location, Integer> destination : cost.entrySet()) {
                this.costMatrix[name.indexOf(source.getName())][name.indexOf(destination.getKey().getName())] = destination.getValue();
            }
        }
    }

    /**
     * a helpful method to print the cost matrix
     */
    public void displayCostMatrix() {
        for (int[] matrix : costMatrix) {
            for (int j = 0; j < costMatrix.length; j++)
                System.out.print(matrix[j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}

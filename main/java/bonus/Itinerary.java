package bonus;

import optional.locations.City;
import optional.locations.Location;

import java.util.*;

/**
 * Itinerary class implements the traveling Salesman Problem
 * some problems to solve:
 * - the path doesn't start and end a daily trip in the same location (hotel)
 * - the tourist have the same trip for each day
 */
public class Itinerary {
    private City city;
    private boolean[] visited;
    private List<Location> locations;
    private int[][] costMatrix;
    private int timeTotal;
    private int daysTotal;

    /**
     * constructor
     *
     * @param locations list of locations from the same city
     */
    public Itinerary(City city, List<Location> locations, int numberDays, int numberMinutes) {
        this.city = city;
        this.locations = locations;
        this.timeTotal = numberMinutes;
        this.daysTotal = numberDays;
    }

    /**
     * finds the path from the start location (should up to the final location..) with the cost<= number of minutes available for visiting.
     *
     * @param source
     */
    public int searchPath(Location source) {
        int time = 0;
        int startVertex = locations.indexOf(source);
        int endVertex = startVertex;
        createCostMatrix();
        int path = startVertex + 1;
        this.visited = new boolean[locations.size()];
        visited[startVertex] = true;
        int power = 10;
        int currentVertex = startVertex;
        for (int nextVertex = 0; nextVertex < costMatrix.length; nextVertex++)
            if (!visited[nextVertex] && costMatrix[currentVertex][nextVertex] > 0 && costMatrix[currentVertex][nextVertex] + time <= this.timeTotal) {
                visited[nextVertex] = true;
                time += costMatrix[currentVertex][nextVertex];
                path = path + (nextVertex + 1) * power;
                power *= 10;
                currentVertex = nextVertex;
            }
        printPath(path);
        System.out.println(time);
        return time;
    }

    /**
     * prints the path between the given two locations
     *
     * @param number each digit represents the index-1 of location
     *               eg: 123 = location.get(0) --> location.get(1) --> location.get(2)
     */
    private void printPath(int number) {
        while (number > 0) {
            System.out.print(locations.get(number % 10 - 1).getName() + " --> ");
            number /= 10;
        }
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
}
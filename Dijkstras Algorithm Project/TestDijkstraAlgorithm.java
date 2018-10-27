import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.*;
import org.junit.Test;


public class TestDijkstraAlgorithm {

	public List<Vertex> nodes;
	public List<Edge> edges;
	
	
	public void testExcute() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }
        
        Random rnd = new Random();
        
      /*  Scanner input = new Scanner(System.in);
        System.out.println("Enter destination: ");
        int destination = input.nextInt();*/
        
        addLane("Edge_0", rnd.nextInt(10), rnd.nextInt(10), rnd.nextInt(300));
        addLane("Edge_1", 0, 2, 5);
        addLane("Edge_2", 0, 4, 2);
        addLane("Edge_3", 2, 6, 1);
        addLane("Edge_4", 2, 7, 3);
        addLane("Edge_5", 3, 7, 8);
        addLane("Edge_6", 5, 8, 10);
        addLane("Edge_7", 8, 9, 12);
        addLane("Edge_8", 7, 9, 2);
        addLane("Edge_9", 4, 9, 3);
        addLane("Edge_10", 9, 10, 5);
        addLane("Edge_11", 1, 10, 9);
	
     // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }

    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
            int duration) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        edges.add(lane);
    }
    
    
	
}

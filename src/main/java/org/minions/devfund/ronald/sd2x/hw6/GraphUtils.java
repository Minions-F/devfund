package org.minions.devfund.ronald.sd2x.hw6;

import java.util.List;
import java.util.Set;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	/**
	 * Given a hw6.Graph, this method returns the shortest distance (in terms of number of edges) from the node labeled src
	 * to the node labeled dest. The method should return -1 for any invalid inputs, including: null values for
	 * the hw6.Graph, src, or dest; there is no node labeled src or dest in the graph; there is no path from src to dest.
	 * Keep in mind that this method does not just return the distance of any path from src to dest,
	 * it must be the shortest path.
	 *
	 * @param graph entity
	 * @param src source
	 * @param dest destination
	 * @return the distance of any path from src to dest, it must be the shortest path.
	 */
	public static int minDistance(Graph graph, String src, String dest) {

		if (graph == null || src == null || dest == null) {
			return -1;
		}

		if (!graph.containsElement(src) && !graph.containsElement(dest)) {
			return -1;
		}
		BreadthFirstSearch search = new BreadthFirstSearch(graph);
		Node srcNode = graph.getNode(src);
		if (search.bfs(srcNode, dest)) {
			return search.getMinDistance();
		}

		return -1;
	}

	/**
	 * Given a hw6.Graph, this method returns a Set of the values of all nodes within the specified distance
	 * (in terms of number of edges) of the node labeled src, i.e. for which the minimum number of edges from src to
	 * that node is less than or equal to the specified distance. The value of the node itself should not be in the Set,
	 * even if there is an edge from the node to itself. The method should return null for any invalid inputs,
	 * including: null values for the hw6.Graph or src; there is no node labeled src in the graph; distance less than 1.
	 * However, if distance is greater than or equal to 1 and there are no nodes within that distance (meaning: src is
	 * the only node in the graph), the method should return an empty Set.
	 * @param graph
	 * @param src
	 * @param distance
	 * @return
	 */
	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		Set<String> set;

		if (graph == null || src == null ) {
			return null;
		}

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it
	}

	/**
	 *
	 * @param g
	 * @param values
	 * @return
	 */
	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		/* IMPLEMENT THIS METHOD! */
		
		return true; // this line is here only so this code will compile if you don't modify it
	}
	
}

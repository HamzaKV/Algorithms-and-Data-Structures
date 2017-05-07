/*
 * Copyright (C) 2017 H
 *
 * This file is part of Algorithms and Data Strucutres
 *
 * Algorithms and Data Strucutres is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package algorithms.and.data.structures.algorithms.graph;

/**
 *
 * @author H
 */
import java.util.ArrayList;

public class Graph {
    
    private final int[][] matrix;
    private static final int INFINITY = Integer.MAX_VALUE;
    
    public Graph(int[][] matrix) {
        int i = matrix.length, j = matrix[i].length;
        if(i != j)
            System.err.println("Your matrix is not a square matrix");
        this.matrix = matrix;
    }
    
    public GraphNode[] getVertices() {
        GraphNode[] vertices = new GraphNode[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            vertices[i] = new GraphNode(i, 0, null);
        }
        return vertices;
    }
    
    public GraphEdge[] getEdges() {
        ArrayList<GraphEdge> edges = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != 0 || matrix[i][j] != INFINITY) {
                    edges.add(new GraphEdge(matrix[i][j], getVertices()[i], getVertices()[j]));
                }
            }
        }
        return (GraphEdge[])edges.toArray();
    }
    
    public GraphNode[] findAdjacent(GraphNode node, GraphNode[] array) {
        int number = node.getNumber();
        ArrayList<GraphNode> adj = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            if(i == number) {
                for(int j = 0; j < matrix[i].length; i++) {
                    if(matrix[i][j] > 0) {
                        adj.add(array[j]);
                    }
                }
            }
        }
        return (GraphNode[])adj.toArray();
    }
}

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
package algorithms.and.data.structures.algorithms.graph.breadth_first_search;

/**
 *
 * @author H
 */
import algorithms.and.data.structures.algorithms.graph.Graph;
import algorithms.and.data.structures.data_structures.Queue;

public class BreadthFirst {
    
    private static final int INFINTY = Integer.MAX_VALUE;
    private Graph graph;
    
    public BreadthFirst(Graph graph) {
        this.graph = graph;
    }

    public void graph(int source) {
        BFSNode[] vertices = (BFSNode[])graph.getVertices();
        vertices[source].setColor('G');
        vertices[source].setDistance(0);
        vertices[source].setPred(null);
        BFSNode s = vertices[source];
        Queue q = new Queue(vertices.length);
        q.enqueue(s);
        while(!(q.isEmpty())) {
            BFSNode u = (BFSNode)q.dequeue();
            for(BFSNode v : (BFSNode[])graph.findAdjacent(u, vertices)) {
                if(v.getColor() == 'W') {
                    v.setColor('G');
                    v.setDistance(u.getDistance()+1);
                    v.setPred(u);
                    q.enqueue(v);
                }
            }
            u.setColor('B');
        }
    }
}

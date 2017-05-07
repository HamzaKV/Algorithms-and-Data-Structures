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
package algorithms.and.data.structures.algorithms.graph.depth_first_search;

/**
 *
 * @author H
 */
import algorithms.and.data.structures.algorithms.graph.Graph;

public class DepthFirst {
    
    private int time;
    private Graph graph;
    private DFSNode[] vertices;

    public DepthFirst(Graph graph) {
        this.graph = graph;
    }

    public void graph() {
        vertices = (DFSNode[])graph.getVertices();
        for(int i = 0; i < vertices.length; i++) {
            vertices[i].setColor('W');
            vertices[i].setPred(null);
        }
        time = 0;
        for(DFSNode u : vertices) {
            if(u.getColor() == 'W') {
                dfsVisit(u);
            }
        }
    }

    private void dfsVisit(DFSNode u) {
        u.setColor('G');
        time++;
        u.setFirstTime(time);
        for(DFSNode v : (DFSNode[])graph.findAdjacent(u, graph.getVertices())) {
            v.setColor('W');
            v.setPred(u);
            dfsVisit(v);
        }
        u.setColor('B');
        u.setSecondTime(time++);
    }
}

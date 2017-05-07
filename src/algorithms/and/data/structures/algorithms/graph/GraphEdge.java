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
public class GraphEdge {
    
    private GraphNode a, b;
    private int weight;
    
    public GraphEdge(int weight, GraphNode a, GraphNode b) {
        this.weight = weight;
        this.a = a;
        this.b = b;
    }

    public GraphNode getA() {
        return a;
    }

    public void setA(GraphNode a) {
        this.a = a;
    }

    public GraphNode getB() {
        return b;
    }

    public void setB(GraphNode b) {
        this.b = b;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

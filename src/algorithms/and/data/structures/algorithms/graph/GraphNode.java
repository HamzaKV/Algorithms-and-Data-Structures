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
import algorithms.and.data.structures.Node;

public class GraphNode extends Node {
    
    private int weight;
    private final int number;
    private char color;
    private GraphNode pred;
    
    public GraphNode(int number, int weight, Object data, char color, GraphNode pred) {
        super(data);
        this.weight = weight;
        this.number = number;
        this.color = color;
        this.pred = pred;
    }
    
    public GraphNode(int number, int weight, Object data) {
        this(number, weight, data, ' ', null);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public GraphNode getPred() {
        return pred;
    }

    public void setPred(GraphNode pred) {
        this.pred = pred;
    }
}

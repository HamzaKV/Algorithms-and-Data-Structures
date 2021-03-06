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
import algorithms.and.data.structures.algorithms.graph.GraphNode;

public class DFSNode extends GraphNode {
    
    private int firstTime, secondTime;
    
    public DFSNode(int number, int weight, Object data, char color, GraphNode pred) {
        super(number, weight, data, color, pred);
    }

    public int getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(int firstTime) {
        this.firstTime = firstTime;
    }

    public int getSecondTime() {
        return secondTime;
    }

    public void setSecondTime(int secondTime) {
        this.secondTime = secondTime;
    }
}

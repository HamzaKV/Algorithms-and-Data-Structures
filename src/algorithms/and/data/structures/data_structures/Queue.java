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
package algorithms.and.data.structures.data_structures;

/**
 *
 * @author H
 */
import algorithms.and.data.structures.Node;

public class Queue {
    private int head, tail, size;
    private Node[] array;
    
    public Queue(int size) {
        this.size = size;
        head = 0;
        tail = head+1;
        array = new Node[size];
    }

    public boolean isEmpty() {
        return (tail > head+1) ? false : true;
    }

    public void enqueue(Node element) {
        if((tail+1)%size == head)
            System.err.println("Full Stack!");
        else
            array[(isEmpty()) ? head : (tail++)%size] = element;
    }

    public Node dequeue() {
        if(isEmpty()) {
            System.err.println("Empty Stack!");
            return null;
        } else
            return array[(head++)%size];
    }
}

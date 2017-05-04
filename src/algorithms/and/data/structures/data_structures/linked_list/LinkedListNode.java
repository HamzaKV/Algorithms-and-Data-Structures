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
package algorithms.and.data.structures.data_structures.linked_list;

/**
 *
 * @author H
 */
import algorithms.and.data.structures.Node;

public class LinkedListNode extends Node {
    
    private LinkedListNode next;
    
    public LinkedListNode(Object data, LinkedListNode next) {
        super(data);
        this.next = next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public LinkedListNode getNext() {
        return next;
    }
}

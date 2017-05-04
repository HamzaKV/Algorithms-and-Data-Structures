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
package algorithms.and.data.structures.data_structures.red_black_tree;

/**
 *
 * @author H
 */
import algorithms.and.data.structures.Node;

public class RBTNode extends Node{

    private RBTNode left, right, parent;
    private char color;

    public RBTNode(RBTNode left, Object data, RBTNode right, RBTNode parent, char color) {
        super(data);
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.color = color;
    }

    public RBTNode getLeft() {
        return left;
    }

    public RBTNode getRight() {
        return right;
    }

    public char getColor() {
        return color;
    }

    public RBTNode getParent() {
        return parent;
    }

    public void setLeft(RBTNode left) {
        this.left = left;
    }

    public void setRight(RBTNode right) {
        this.right = right;
    }

    public void setParent(RBTNode parent) {
        this.parent = parent;
    }

    public void setColor(char color) {
        this.color = color;
    }
}


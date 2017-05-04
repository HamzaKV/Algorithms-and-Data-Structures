/*
 * Copyright (C) 2017 H
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package algorithms.and.data.structures.data_structures.binary_search_tree;

/**
 *
 * @author H
 */
import java.util.ArrayList;

public class BinarySearchTree {

    BSTNode root;

    public BinarySearchTree(ArrayList<Object> list) {
        if(list != null) {
            for(int i = 0; i < list.size(); i++)
                insertData(list.get(i));
        }
    }

    public void insertData(Object object) {
        root = insert(root, object);
    }

    private BSTNode insert(BSTNode node, Object object) {
        if(node == null) {
            return new BSTNode(null, object, null);
        } else {
            if((int)object < (int)node.getLeft().getData()) {
                node.setLeft(insert(node.getLeft(), object));
            } else {
                node.setRight(insert(node.getRight(), object));
            }
            return node;
        }
    }

    public BSTNode searchData(Object object) {
        return search(root, object);
    }

    private BSTNode search(BSTNode node, Object object) {
        if(node == null) {
            return null;
        } else if(object == node.getData()) {
            return node;
        } else if((int)object < (int)node.getData()) {
            return search(node.getLeft(), object);
        } else {
            return search(node.getRight(), object);
        }
    }

    public Object deleteData(Object object) {
        return deleteBSTNode(searchData(object)) ? object : null;
    }

    private boolean deleteBSTNode(BSTNode delete) {
        if(delete.getLeft() == null && delete.getRight() == null) {
            delete = null;
            return true;    
        } else if(delete.getLeft() != null && delete.getRight() == null) {
            delete = replace(delete.getLeft());
            return true;
        } else if(delete.getLeft() == null && delete.getRight() != null) {
            delete = replace(delete.getRight());
            return true;
        } else if(delete.getLeft() != null && delete.getRight() != null) {
            delete = replace(successor(delete));
            return true;
        }
        return false;
    }

    private BSTNode replace(BSTNode node) {
        BSTNode temp = node;
        deleteBSTNode(node);
        return temp;
    }

    private BSTNode successor(BSTNode node) {
        BSTNode successor = node.getRight();
        while(successor.getLeft() != null) {
            successor = node.getLeft();
        }
        return successor;
    }
}

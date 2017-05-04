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
package algorithms.and.data.structures.data_structures.red_black_tree;

/**
 *
 * @author H
 */
public class RedBlackTree {

    private RBTNode root;

    public RedBlackTree(Object[] list) {
        if(list != null) {
            for(int i = 0; i < list.length; i++)
                insertData(list[i]);
        }
    }

    public void insertData(Object object) {
        insert(new RBTNode(null, object, null, null, 'B'));
    }

    private void insert(RBTNode z) {
        RBTNode x = root, y = null;
        while(x != null) {
            y = x;
            if((int)z.getData() < (int)x.getData()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        z.setParent(y);
        if(y == null) {
            root = z;
        } else if((int)z.getData() < (int)y.getData()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }
        z.setLeft(null);
        z.setRight(null);
        z.setColor('R');
        insertFix(z);
    }

    private void insertFix(RBTNode node) {
        while(node.getParent().getColor() == 'R') {
            RBTNode parent = node.getParent(), grandparent = parent.getParent(), uncle;
            if(parent.equals(grandparent.getLeft())) {
                uncle = grandparent.getRight();
                if(uncle.getColor() == 'R') {
                    parent.setColor('B');
                    uncle.setColor('B');
                    grandparent.setColor('R');
                    node = grandparent;
                } else if(node.equals(parent.getRight())) {
                    node = parent;
                    leftRotate(node);
                } else {
                    parent.setColor('B');
                    grandparent.setColor('R');
                    rightRotate(grandparent);
                }
            } else {
                uncle = grandparent.getLeft();
                if(uncle.getColor() == 'R') {
                    parent.setColor('B');
                    uncle.setColor('B');
                    grandparent.setColor('R');
                    node = grandparent;
                } else if(node.equals(parent.getLeft())) {
                    node = parent;
                    rightRotate(node);
                } else {
                    parent.setColor('B');
                    grandparent.setColor('R');
                    leftRotate(grandparent);
                }
            }
        }
        root.setColor('B');
    }

    public RBTNode searchData(Object object) {
        return search(root, object);
    }

    private RBTNode search(RBTNode node, Object object) {
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

    public boolean deleteData(Object object) {
        return (deleteRBTNode(searchData(object)) != null) ? true : false;
    }

    private RBTNode deleteRBTNode(RBTNode z) {
        RBTNode x, y;
        if(z.getLeft() == null || z.getRight() == null) {
            y = z;
        } else {
            y = successor(z);
        }
        if(y.getLeft() != null) {
            x = y.getLeft();
        } else {
            x = y.getRight();
        }
        x.setParent(y.getParent());
        if(y.getParent() == null) {
            root = x;
        } else if(y.equals(y.getParent().getLeft())) {
            y.getParent().setLeft(x);
        } else {
            y.getParent().setRight(x);
        }
        if(!(y.equals(z))) {
            z.setData(y.getData());
        }
        if(y.getColor() == 'B') {
            deleteFix(x);
        }
        return y;
    }

    private void deleteFix(RBTNode x) {
        RBTNode w;
        while(!(x.equals(root)) && x.getColor() == 'B') {
            if(x.equals(x.getParent().getLeft())) {
                w = x.getParent().getRight();
                if(w.getColor() == 'R') {
                    w.setColor('B');
                    x.getParent().setColor('R');
                    leftRotate(x.getParent());
                    w = x.getParent().getRight();
                }
                if(w.getLeft().getColor() == 'B' && w.getRight().getColor() == 'B') {
                    w.setColor('R');
                    x = x.getParent();
                } else if(x.getRight().getColor() == 'B') {
                    w.getLeft().setColor('B');
                    w.setColor('R');
                    rightRotate(w);
                    w = x.getParent().getRight();
                } else {
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor('B');
                    w.getRight().setColor('B');
                    leftRotate(x.getParent());
                    x = root;
                }
            } else {
                w = x.getParent().getLeft();
                if(w.getColor() == 'R') {
                    w.setColor('B');
                    x.getParent().setColor('R');
                    rightRotate(x.getParent());
                    w = x.getParent().getLeft();
                }
                if(w.getLeft().getColor() == 'B' && w.getRight().getColor() == 'B') {
                    w.setColor('R');
                    x = x.getParent();
                } else if(x.getLeft().getColor() == 'B') {
                    w.getRight().setColor('B');
                    w.setColor('R');
                    leftRotate(w);
                    w = x.getParent().getLeft();
                } else {
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor('B');
                    w.getLeft().setColor('B');
                    rightRotate(x.getParent());
                    x = root;
                }
            }
        }
        x.setColor('B');
    }

    private void leftRotate(RBTNode x) {
        RBTNode y = x.getRight(), alpha = x.getLeft(), beta = y.getLeft(), gamma = y.getRight();
        x.setRight(beta);
        beta.setParent(x);
        y.setParent(x.getParent());
        if(x.getParent() == null) {
            root = y;
        } else if(x.equals(x.getParent().getLeft())) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
    }

    private void rightRotate(RBTNode y) {
        RBTNode x = y.getLeft(), alpha = x.getLeft(), beta = x.getRight(), gamma = y.getRight();
        y.setLeft(beta);
        beta.setParent(y);
        x.setParent(y.getParent());
        if(y.getParent() == null) {
            root = x;
        } else if(y.equals(y.getParent().getLeft())) {
            y.getParent().setLeft(x);
        } else {
            y.getParent().setRight(x);
        }
        x.setLeft(y);
        y.setParent(x);
    }

    private RBTNode replace(RBTNode node) {
        RBTNode temp = node;
        deleteRBTNode(node);
        return temp;
    }

    private RBTNode successor(RBTNode node) {
        RBTNode successor = node.getRight();
        while(successor.getLeft() != null) {
            successor = node.getLeft();
        }
        return successor;
    }
}

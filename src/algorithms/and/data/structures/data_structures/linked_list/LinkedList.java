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
package algorithms.and.data.structures.data_structures.linked_list;

/**
 *
 * @author H
 */
public class LinkedList {
    
    private int size;
    private LinkedListNode node;

    public LinkedList(){
        size = 1;
    }

    public int getSize() {
        return size;
    }

    public void addData(Object data) {
        if(node == null) {
            node = new LinkedListNode(data, null);
        }

        LinkedListNode temp = new LinkedListNode(data, null);
        LinkedListNode current = node;

        if(current != null) {
            while(current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(temp);
        }

        size++;
    }

    public boolean deleteData(int index) {
        if(index+1 < 1 || index >= getSize())
            return false;
        
        LinkedListNode current = node;

        if(node != null) {
            for(int i = 0; i < index; i++) {
                if(current.getNext() == null)
                    return false;
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            size--;
            return true;
        }
        return false;
    }

    public Object getData(int index) {
        if(index < 0)
            return null;
        
        LinkedListNode current = null;
        if(node != null) {
            current = node.getNext();
            for(int i = 0; i < index; i++) {
                if(current.getNext() == null)
                    return null;
                current = current.getNext();
            }
            return current.getData();
        }
        return current.getData();
    }
}

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
package algorithms.and.data.structures.data_structures;

/**
 *
 * @author H
 */
public class HashTable {

    private int[] array;
    private boolean divisionMethod;
    private int max;

    public HashTable(int[] array, int max, boolean divisionMethod) {
        this.array = new int[max];
        this.divisionMethod = divisionMethod;
        this.max = max;
        if(array != null) {
            for(int i = 0; i < array.length; i++) {
                insert(array[i]);
            }
        }
    }

    public void insert(int object) {
        array[hashFunction(object)] = object;
    }

    public boolean search(int object) {
        return (array[hashFunction(object)] == object) ? true : false;
    }

    public boolean delete(int object) {
        if(search(object)) {
            array[hashFunction(object)] = 0;
            return true;
        } else {
            return false;
        }
    }

    private int hashFunction(int object) {
        if(divisionMethod) {
            return object % max;
        } else {
            return  max * (int)((object * ((Math.sqrt(5) - 1) / 2)) % 1);
        }
    }
}

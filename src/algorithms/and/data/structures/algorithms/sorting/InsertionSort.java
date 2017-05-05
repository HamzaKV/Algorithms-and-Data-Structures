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
package algorithms.and.data.structures.algorithms.sorting;

/**
 *
 * @author H
 */
public class InsertionSort {
    
    private Object[] array;

    public InsertionSort (Object[] array) {
        this.array = array;
    }

    public void sort() {
        Object key;
        int j;
        for(int i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;
            while(j > 0 && (int)array[j] > (int)key) {
                array[j+1] = array[j];
                j = j - 1;
            }
            array[j+1] = key;
        }
    }

    public Object[] getArray() {
        return array;
    }
}

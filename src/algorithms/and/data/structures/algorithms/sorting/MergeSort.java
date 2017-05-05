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
public class MergeSort {
    
    private Object[] array;
    public MergeSort(Object[] array) {
        this.array = array;
    }

    public void sort() {
        array = mergeSort(array);
    }

    private Object[] mergeSort(Object[] array) {
        if(array.length == 1) {
            return array;
        } else {
            return merge(mergeSort(new Object[(array.length / 2)]), mergeSort(new Object[array.length - (array.length / 2)]));
        }
    }

    private Object[] merge(Object[] left, Object[] right) {
        int i = 0, j = 0;
        Object[] sorted = new Object[left.length + right.length];
        for(int k = 0; k < sorted.length; k++) {
            if((int)left[i] <= (int)right[j]){
                sorted[k] = left[i];
                i++;
            } else {
                sorted[k] = right[j];
                j++;
            }
        }
        return sorted; 
    }

    public Object[] getArray() {
        return array;
    }
}

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
public class HeapSort {

    private Object[] array;
    private int heapSize;

    public HeapSort(Object[] array) {
        this.array = array;
    }

    public void heapSort() {
        buildHeap(array);
        for(int i = heapSize; i > 0; i--) {
            Object temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapSize = heapSize - 1;
            heapify(array, 0);
        }
    }

    private void buildHeap(Object[] array) {
        heapSize = array.length - 1;
        for(int i = (array.length/2); i >= 0; i--)
            heapify(array, i);
    }

    private void heapify(Object[] array, int i) {
        int l = (2 * i) + 1, r = (2 * i) + 2, max;
        if(l <= heapSize && (int)array[l] > (int)array[i]) {
            max = l;
        } else {
            max = i;
        }
        if(r <= heapSize && (int)array[r] > (int)array[max]) {
            max = r;
        }
        if(max != i) {
            Object temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            heapify(array, max);
        }
    }

    public Object[] getArray() {
        return array;
    }
}

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
public class QuickSort {

    private Object[] array;
    public QuickSort(Object[] array) {
        this.array = array;
    }

    public void sort() {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(Object[] array, int p, int r) {
        if(p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q-1);
            quickSort(array, q+1, r);
        }
    }

    private int partition(Object[] array, int p, int r) {
        Object x = array[r];
        int i = p - 1;
        for(int j = p; j < r; j++) {
            if((int)array[j] <= (int)x) {
                i = i + 1;
                Object temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        Object temp = array[i+1];
        array[i+1] = array[r];
        array[r] = temp;
        return i + 1;
    }

    public Object[] getArray() {
        return array;
    }
}

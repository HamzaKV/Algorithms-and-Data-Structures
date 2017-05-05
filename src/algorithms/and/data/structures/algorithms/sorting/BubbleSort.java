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
public class BubbleSort {

    private Object[] array;
    public BubbleSort(Object[] array) {
        this.array = array;
    }

    public void sort() {
        int loop = array.length;

        for(int i = 0; i < loop; i++) {
            boolean swapped = false;
            for(int j = 0; j < loop; j++) {
                if((int)array[j] > (int)array[j + 1]) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
    }

    public Object[] getArray() {
        return array;
    }
}

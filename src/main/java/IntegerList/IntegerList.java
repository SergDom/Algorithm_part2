package IntegerList;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyArgumentException;
import Exceptions.NullParameterException;
import Exceptions.OutOfBondException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class IntegerList implements IntegerListInterface {
    private Integer[] list;
    private int value;
    private int size = 0;

    public IntegerList(int value) {
        this.value = value;
        list = new Integer[value];
    }

    @Override
    public Integer add(Integer item) {
        return add(size, item);
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index > size || index < 0) {
            throw new OutOfBondException("Выходит за пределы размера массива");
        }
        if (item == null) {
            throw new EmptyArgumentException("Введена пустая строка");
        }
        if (index == size) {
            list[size++] = item;
            return item;
        }
        System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index >= size || index < 0) {
            throw new OutOfBondException("Выходит за пределы размера массива");
        }
        list[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                index = i;
            }
        }
        if (index == -1) {
            throw new ElementNotFoundException("Элемент остуствует");
        } else return remove(index);
    }

    @Override
    public Integer remove(int index) {
        if (index >= size || index < 0) {
            throw new ElementNotFoundException("Элемент отсутсвует");
        }
        Integer removed = list[index];
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[size] = null;
        size--;
        return removed;
    }

    @Override
    public boolean contains(Integer item) {
      sortList(list);
      return binarySearch(list,item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (size <= index || index < 0) {
            throw new OutOfBondException("Выходит за пределы размера массива");
        }
        return list[index];

    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new NullParameterException("Пустой список");
        }
        if (this.size != otherList.size()) return false;
        for (int i = 0; i < size; i++) {
            if (!(list[i].equals((otherList.get(i)))))
                return false;
        }
        return true;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(list, size());
    }


    public boolean binarySearch(Integer[] list, Integer item) {

        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == list[mid]) {
                return true;
            }

            if (item < list[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    public void sortList(Integer[] list) {

//        Метод вставками самый быстрый
        for (int i = 0; i < size; i++) {
            int element = list[i];
            int j = i;

            while (j > 0 && list[j - 1] > element) {
                list[j] = list[j - 1];
                j--;
            }
            list[j]=element;
        }
        System.out.println(Arrays.toString(list));
    }


}
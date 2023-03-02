package com.chudnovskiy;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private final int INIT_SIZE = 10;
    private Object[] data;
    private int capacity; //текущая емкость массива
    private int size; // текущее количество существующих элементов в массиве

    /**
     * Конструктор по умолчанию
     */
    public MyArrayList() {
        data = new Object[INIT_SIZE];
        capacity = INIT_SIZE;
        size = 0;
    }

    /**
     * конструктор с заданной емкостью
     *
     * @param capacity
     */
    public MyArrayList(int capacity) {
        this();
        this.capacity = capacity;
    }

    /**
     * геттер для size
     *
     * @return Возвращает количество элементов в списке
     */
    public int getSize() {
        return size;
    }

    /**
     * ensureCapacity – закрытый метод! проверяет, достаточно
     * ли резерва памяти для хранения указанного в параметре
     * количества элементов. Если значение параметра меньше
     * текущего capacity, то ничего не происходит. Если значение
     * параметра больше текущего capacity, то массив пересоздает-
     * ся, памяти выделяется в 1,5 раза + 1 элемент больше.
     * Существующие элементы переносятся в новый массив.
     * Существующие элементы не должны быть потеряны.
     */
    private void ensureCapacity(int capacity) {
        if (capacity + size > this.capacity) {
            //Если значение параметра больше текущего capacity, то массив пересоздается
            resize();
        }
        //Если значение параметра меньше текущего capacity, то ничего не происходит.

    }

    /**
     * Вспомогательный метод для масштабирования, памяти выделяется в 1,5 раза + 1 элемент больше
     */
    private void resize() {
        float CUT_RATE = 1.5f;
        int newCapacity = Math.round((float) this.capacity * CUT_RATE) + 1;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(data, 0, newArray, 0, this.capacity);
        data = newArray;
        this.capacity = newCapacity;

    }

    /**
     * pushBack (добавление элемента obj в конец массива. Должна
     * быть проверка, достаточно ли памяти! Если памяти не
     * достаточно увеличить емкость массива данных);
     */
    public void pushBack(T obj) {
        if (capacity == size) {
            ensureCapacity(1);
        }
        insert(obj, size);
    }

    /**
     * popFront (удаление первого элемента из массива);
     */
    public T popFront() {
        Object obj;
        if (size != 0 && ((obj = removeAt(0)) != null)) {
            return (T) obj;
        }
        return null;
    }

    /**
     * pushFront (добавление нового элемента obj в начало массива)
     *
     * @param obj - добавляемый обьект
     */
    public void pushFront(T obj) {
        if (capacity == size) {
            ensureCapacity(1);
        }
        insert(obj, 0);
    }

    /**
     * insert (вставка нового элемента obj в массив по указанному
     * индексу index, с проверкой на выход за пределы массива)
     *
     * @param obj - добавляемый обьект
     * @param index - индекс вставки обьекта в MyArrayList
     * @return - результат вставки обьекта
     */
    public boolean insert(T obj, int index) {
        if (index < 0 || index > size) {
            System.err.println("Invalid index:\t" + index);
            return false;
        }
        if (capacity == size) {
            ensureCapacity(1);
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = obj;
        size++;
        return true;
    }

    /**
     * removeAt (удаление одного элемента по указанному индексу index
     * Должна быть проверка на допустимость индекса
     *
     * @param index
     * @return - результат удаления
     */
    public T removeAt(int index) {
        if (index < 0 || index >= capacity) {
            return null;
        }
        T removeObject = (T) data[index];
        System.arraycopy(data, index + 1, data, index, size - index);
        size--;

        //TODO :уменьшение размера массива если индекс меньше чем текущая емкость массива разделенная на 2
//        int newCapacity;
//        if (size > INIT_SIZE && size < (newCapacity = capacity / 2)) {
//            //Object[] newArray = new Object[newCapacity];
//            System.arraycopy(data, index + 1, data, index, newCapacity - index);
//            //data = newArray;
//            this.capacity = newCapacity;
//        }
        return removeObject;
    }

    /**
     * remove (удаление одного элемента obj, значение которого
     * совпадает со значением переданного параметра)
     *
     * @param obj
     * @return - результат удаления
     */
    public T remove(T obj) {
        int index = get(obj);
        if (obj == null || index == -1) return null;
        return removeAt(index);
    }

    /**
     * removeAll (удаление всех элементов, значения которых
     * совпадает со значением переданного параметра obj)
     *
     * @param obj
     * @return - кол-во удаленных обьектов
     */
    public int removeAll(T obj) {
        int counter = 0;
        while (remove(obj) != null) {
            counter++;
        }
        return counter;
    }

    /**
     * Возвращает позицию элемент в списке по индексу index.
     *
     * @param obj
     * @return позиция элемента в списка, -1 - обьект не найден
     */
    private int get(T obj) {
        if (obj == null) return -1;
        for (int i = 0; i < size - 1; i++) {
            if (obj.equals(get(i))) return i;
        }
        return -1;
    }

    /**
     * Возвращает элемент списка по индексу index.
     *
     * @param index
     * @return элемент списка
     */
    public T get(int index) {
        return (T) data[index];
    }

    /**
     * сlear (обнуление массива – всем элементам массива по
     * индексам от 0 до size-1 присвоить значение null, полю size
     * присвоить значение 0).
     */
    public void clear() {
        Arrays.fill(data, null);
        size = 0;
    }

    /**
     * переопределить метод toString и реализовать строковое
     * представление элементов массива через пробел.
     *
     * @return
     */
    @Override
    public String toString() {
        final String delimiterString = ",\t";
        int index = 0;
        StringBuilder stringBuilderHead = new StringBuilder().append("Index:\t");
        StringBuilder stringBuilderData = new StringBuilder().append("Data:\t");
        Iterator<T> iterator = this.iterator();

        while (iterator.hasNext()) {
            stringBuilderHead.append(index).append("\t");
            stringBuilderData.append(iterator.next()).append(delimiterString);
            index++;

        }
        stringBuilderData.delete(stringBuilderData.length() - delimiterString.length(), stringBuilderData.length());
        return stringBuilderHead.append((System.getProperty("line.separator"))).append(stringBuilderData).toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public T next() {
                return (T) data[i++];
            }
        };
    }
}
package com.chudnovskiy;

import java.sql.Struct;
import java.util.Arrays;

public class MyArrayList<T> {
    private final int INIT_SIZE = 10;
    private final float CUT_RATE = 1.5f;
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
     * @param capacity
     */
    public MyArrayList(int capacity) {
        this();
        this.capacity = capacity;
    }

    /**
     * геттер для size
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
     * @return
     */
    private void ensureCapacity(int capacity) {
        if (capacity + size > this.capacity) {
             //Если значение параметра меньше текущего capacity, то ничего не происходит.
            resize(capacity);
        }
         //Если значение параметра больше текущего capacity, то массив пересоздается
    }

    /**
     * Вспомогательный метод для масштабирования, памяти выделяется в 1,5 раза + 1 элемент больше
     * @param capacity - новый размер коллекции
     */
    private void resize(int capacity) {
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
        insert(obj, capacity - 1);
    }

    /**
     * popFront (удаление первого элемента из массива);
     */
    public boolean popFront() {
        if (removeAt(0)) {
            return true;
        }
        return false;
    }

    /**
     * pushFront (добавление нового элемента obj в начало массива)
     * @param obj
     */
    public void pushFront(T obj) {
        int currentCapacity = capacity;
        resize(1);
        System.arraycopy(data, 0, data, 1, currentCapacity);
        insert(obj, 0);
    }

    /**
     * insert (вставка нового элемента obj в массив по указанному
     * индексу index, с проверкой на выход за пределы массива)
     * @param obj
     * @param index
     * @return - результат вставки обьекта
     */
    public boolean insert(T obj, int index) {
        if (get(index) == null) {
            if (capacity == size) {
                ensureCapacity(1);
            }
            data[index] = obj;
            size++;
            return true;
        }
        return false;
    }

    /**
     * removeAt (удаление одного элемента по указанному индексу index
     * Должна быть проверка на допустимость индекса
     * @param index
     * @return - результат удаления
     */
    public boolean removeAt(int index) {
        if (index < 0 || index >= capacity) {
            return false;
        }
        for (int i = index; i < capacity - 1; i++) {
            data[i] = data[i + 1];
        }
        data = Arrays.copyOf(data, capacity - 1);
        size--;

        //уменьшение размера массива если индекс меньше чем текущая емкость массива разделенная на 2
        if (getSize() > INIT_SIZE && index < capacity / 2) {
            resize(capacity / 2);
        }
        //TODO: refactoring
        /*data[index] = null;
        if (index == 0) {
            // удалить элемен т с индексом 0
        } else {
            Object[] tmpRightData = new Object[capacity - index - 1];
            System.arraycopy(data, index + 1, tmpRightData, 0, capacity - index - 1);

            Object[] tmpLeftData = new Object[(index - 1) == 0 ? 1 : index];
            System.arraycopy(data, 0, tmpLeftData, 0, index);


        }*/

        return true;
    }


    /**
     * concat two arrays
     * @param first
     * @param second
     * @return
     */
    private T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    /**
     * remove (удаление одного элемента obj, значение которого
     * совпадает со значением переданного параметра)
     * @param obj
     * @return - результат удаления
     */
    public boolean remove(T obj) {

            return false;
    }

    /**
     * removeAll (удаление всех элементов, значения которых
     * совпадает со значением переданного параметра obj)
     * @param obj
     * @return - результат удаления
     */
    public boolean removeAll(T obj){

        return false;
    }


    /**
     *  Добавляет новый элемент obj в список
     * @param obj
     */
    private void add(T obj) {
        size++;
        data[size] = obj;
    }

    /**
     * Возвращает элемент списка по индексу index.
     * @param index
     * @return элемент списка
     */
    public T get(int index) {
        return (T) data[index];
    }

    /*
    Удаляет элемент списка по индексу. Все элементы справа от удаляемого
    перемещаются на шаг налево. Если после удаления элемента количество
    элементов стало в CUT_RATE раз меньше чем размер внутреннего массива,
    то внутренний массив уменьшается в два раза, для экономии занимаемого
    места.
    */
    public void remove(int index) {
        for (int i = index; i< capacity; i++)
            data[i] = data[i+1];
        data[capacity] = null;
        capacity--;
        if (data.length > INIT_SIZE && capacity < data.length / CUT_RATE)
            resize(data.length/2); // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
    }
}
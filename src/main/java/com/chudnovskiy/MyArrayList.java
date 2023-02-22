package com.chudnovskiy;

public class MyArrayList<T> {
    private final int INIT_SIZE = 10;
    private final int CUT_RATE = 4;
    private Object[] data;
    private int capacity;
    private int size;

    public MyArrayList() {
        data = new Object[INIT_SIZE];
        capacity = INIT_SIZE;
        size = 0;
    }

    public MyArrayList(int capacity) {
        this();
        this.capacity = capacity;
    }

    /*
        Добавляет новый элемент в список. При достижении размера внутреннего
        массива происходит его увеличение в два раза.
        */
    public void add(T item) {
        if(capacity == data.length-1)
            resize(data.length*2); // увеличу в 2 раза, если достигли границ
        data[capacity++] = item;
    }

    /*
    Возвращает элемент списка по индексу.
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
    /*Возвращает количество элементов в списке*/
    public int size() {
        return capacity;
    }

    /*Вспомогательный метод для масштабирования.*/
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(data, 0, newArray, 0, capacity);
        data = newArray;
    }
}
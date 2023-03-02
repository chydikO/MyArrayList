package com.chudnovskiy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class MyArrayListTest {

    @BeforeEach
    void setUp() {
    }


    @Test
    void whenSizeIsThree() {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
        for (int i = 0; i < 3; i++) {
            myArrayList1.pushFront(11);
        }
        int size = myArrayList1.getSize();
        assertEquals(3, size);
    }

    @Test
    void pushBack() {
    }

    @Test
    void popFront() {
    }

    @Test
    void pushFront() {
    }

    @Test
    void insert() {
    }

    @Test
    void removeAt() {
    }

    @Test
    void whenRemoveObject() {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
            myArrayList1.pushFront(0);
            myArrayList1.pushFront(1);

        Integer result = myArrayList1.remove(1);
        assertEquals(1, result);
        assertEquals(1,myArrayList1.getSize());
        assertEquals(0, myArrayList1.get(0));
    }

    @Test
    void removeAllTheSameObjects() {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
        myArrayList1.pushFront(0);
        myArrayList1.pushFront(1);
        myArrayList1.pushFront(0);
        myArrayList1.pushFront(1);

        int result = myArrayList1.removeAll(1);
        assertEquals(2, result); //колл-во удаленных обьектов
        assertEquals(2, myArrayList1.getSize()); // размер коллекции после удаления одинаковых Obj
        assertEquals(0, myArrayList1.get(0));
        assertEquals(0, myArrayList1.get(1));
    }

    @Test
    void getObjectToIndex() {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
        for (int i = 0; i < 3; i++) {
            myArrayList1.pushFront(i);
        }
        Integer result = myArrayList1.get(1);
        assertEquals(1, result);
    }

    @Test
    void clear() {
    }

    @Test
    void iterator() {
    }
}
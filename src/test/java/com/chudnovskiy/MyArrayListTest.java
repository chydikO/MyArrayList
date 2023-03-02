package com.chudnovskiy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MyArrayListTest {
    private MyArrayList<Integer> myArrayList1;

    @BeforeEach
    void setUp() {
        myArrayList1 = new MyArrayList<>();
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
        myArrayList1.pushFront(0);
        myArrayList1.pushFront(1);
        myArrayList1.pushBack(99);
        Integer result = myArrayList1.get(myArrayList1.getSize() - 1);
        assertEquals(99, result);
        assertEquals(1, myArrayList1.get(0));
        assertEquals(0, myArrayList1.get(1));
        myArrayList1.clear();
    }

    @Test
    void popFront() {
        myArrayList1.pushFront(0);
        myArrayList1.pushFront(1);
        myArrayList1.pushFront(99);
        Integer result = myArrayList1.popFront();
        assertEquals(99, result);
        assertEquals(2, myArrayList1.getSize());
        assertEquals(1, myArrayList1.get(0));
        assertEquals(0, myArrayList1.get(1));
        myArrayList1.clear();
    }

    @Test
    void pushFront() {
        myArrayList1.pushFront(0);
        myArrayList1.pushFront(1);
        myArrayList1.pushFront(99);
        assertEquals(3, myArrayList1.getSize());
        assertEquals(99, myArrayList1.get(0));
        myArrayList1.clear();
    }

    @Test
    void insert() {
        myArrayList1.pushFront(0);
        myArrayList1.pushFront(1);
        myArrayList1.pushFront(2);
        assertEquals(true, myArrayList1.insert(99, 1));
        assertEquals(4, myArrayList1.getSize());
        assertEquals(2, myArrayList1.get(0));
        assertEquals(99, myArrayList1.get(1));
        assertEquals(1, myArrayList1.get(2));
        myArrayList1.clear();
    }

    @Test
    void removeAtIndex() {
        myArrayList1.pushFront(0);
        myArrayList1.pushFront(1);
        Integer result = myArrayList1.removeAt(1);
        assertEquals(0, result);
        assertEquals(1,myArrayList1.getSize());
        assertEquals(1, myArrayList1.get(0));
        myArrayList1.clear();
    }

    @Test
    void whenRemoveObject() {
        myArrayList1.pushFront(0);
        myArrayList1.pushFront(1);
        Integer result = myArrayList1.remove(1);
        assertEquals(1, result);
        assertEquals(1,myArrayList1.getSize());
        assertEquals(0, myArrayList1.get(0));
        myArrayList1.clear();
    }

    @Test
    void removeAllTheSameObjects() {
        myArrayList1.pushFront(0);
        myArrayList1.pushFront(1);
        myArrayList1.pushFront(0);
        myArrayList1.pushFront(1);

        int result = myArrayList1.removeAll(1);
        assertEquals(2, result); //колл-во удаленных обьектов
        assertEquals(2, myArrayList1.getSize()); // размер коллекции после удаления одинаковых Obj
        assertEquals(0, myArrayList1.get(0));
        assertEquals(0, myArrayList1.get(1));
        myArrayList1.clear();
    }

    @Test
    void getObjectToIndex() {
        myArrayList1.pushFront(0);
        myArrayList1.pushFront(1);
        Integer result = myArrayList1.get(1);
        assertEquals(0, result);
        myArrayList1.clear();
    }

    @Test
    void clearAllCollection() {
        myArrayList1.pushFront(0);
        myArrayList1.pushFront(1);
        myArrayList1.clear();
        assertEquals(0, myArrayList1.getSize());
        assertEquals(null, myArrayList1.get(0));
    }
}
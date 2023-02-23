package com.chudnovskiy;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
        //MyArrayList<Integer> myArrayList2 = new MyArrayList<>(20);


        myArrayList1.pushBack(10);
        myArrayList1.insert(5, 5);
        myArrayList1.pushFront(11);
        myArrayList1.pushBack(99);
        for (int i = 1; i <= 8; i++) {
            myArrayList1.pushFront(i + 30);
        }


        Iterator<Integer> iterator = myArrayList1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        myArrayList1.remove(6);
        System.out.println();
    }
}

package com.chudnovskiy;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
        //MyArrayList<Integer> myArrayList2 = new MyArrayList<>(20);


        myArrayList1.pushBack(10);
        myArrayList1.insert(5, 5);
        myArrayList1.pushFront(11);
        myArrayList1.pushFront(11);
        myArrayList1.pushFront(11);
        myArrayList1.pushBack(99);
        for (int i = 1; i <= 8; i++) {
            myArrayList1.pushFront(i + 30);
        }
        System.out.println(myArrayList1);


        System.out.println("popFront:\t" + myArrayList1.popFront());


        System.out.println(myArrayList1);
        System.out.println("insert(77,3):\t" + myArrayList1.insert(77  ,3));
        System.out.println(myArrayList1);

/*        Iterator<Integer> iterator = myArrayList1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

        System.out.println("remove(10):\t" + myArrayList1.remove(10));
        System.out.println("remove(3333):\t" + myArrayList1.remove(3333));
        System.out.println("size:\t" + myArrayList1.getSize());
        System.out.println("Remove all(11) - count times:\t" + myArrayList1.removeAll(11));
        System.out.println(myArrayList1);
        System.out.println("size:\t" + myArrayList1.getSize());

        myArrayList1.clear();
        System.out.println();

    }
}

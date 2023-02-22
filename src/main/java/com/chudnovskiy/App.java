package com.chudnovskiy;

public class App {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>(20);


        myArrayList1.pushBack(10);
        myArrayList1.insert(5, 5);
        myArrayList1.pushFront(11);

        myArrayList1.remove(6);
        System.out.println();
    }
}

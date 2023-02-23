package com.chudnovskiy;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1, 99);

        list.add(10);
        list.size();
        list.add(9, 99);
        System.out.println();
    }
}

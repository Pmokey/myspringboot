package com.example.myspringboot.generics;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Tool<String> tool = new Tool<String>("Mary");
        System.out.println(tool.getE());
        
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Tom");
        arrayList.add("mmm");
        Tool tool2 = new Tool(arrayList);
        System.out.println(tool2.getE().getClass().getName());
        System.out.println(Test.class.getTypeName());
    }

}

package com.example.myspringboot.generics;

public class Tool<E> {
    private E e;
    
    public Tool(E el){
        this.e=el;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}

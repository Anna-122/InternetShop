package com.uits.task13;

public class Clothes extends Store implements Goods{
    int size;
    String color;

    Clothes( int size, String col ) {
        this.size = size;
        color = col;
    }
    Clothes(){
        size=0;
        color="default";
    }
    public void putToCart(){
        System.out.println("Товар "+title+" положим в корзину");
    }
}


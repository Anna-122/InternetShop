package com.uits.task13;

public class Makeup extends Store implements Goods {
    String sex;

    Makeup ( String sex ) {
        this.sex = sex;
    }
    Makeup() {
       sex="Uni sex";
     }

     public void putToCart(){
        System.out.println("Товар "+title+" положим в корзину");
     }

}

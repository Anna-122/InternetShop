package com.uits.task13;

public class Furniture extends Store implements Goods{
    String color;
    String typeOfFurniture;
    Furniture(  String col, String typeOfFurniture) {
        color=col;
        this.typeOfFurniture=typeOfFurniture;
    }
    Furniture(){
        color="default";
        typeOfFurniture="default";
    }
    public void putToCart(){

        System.out.println("Товар "+title+" положим в корзину");
    }
}


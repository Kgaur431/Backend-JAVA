package com.kartik;

import javax.swing.*;

public class Fruits {
    String color;
    String taste;

    public Fruits(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    public boolean isTasty() {
        return this.taste.equals("sweet");
    }

   static public Fruits copy(Fruits oldFruit) {
     //   System.out.println("copying fruit", color);
        return new Fruits(oldFruit.color, oldFruit.taste);
    }




}

/**
 *  1. isTasty() is important function here. because this fun is depends on the current property of
 *        fruit object. so its inside the Fruits class.
*   2.  does the defination of copy method exists inside every copy of object ?
 *      ANS:- NO. so we will make this function to static.
 */

package com.kartik.basics2.oop;

public class Ford extends Vehicle{
    int fuel;

    public Ford(int fuel) {
        this.fuel = fuel;
    }

    @Override
    void start() {
       if(fuel <= 0){
           throw new  IllegalStateException("Fuel is too low");
       }
       super.start();            // this will call the start method of Vehicle class.
    }
}

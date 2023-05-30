package com.kartik.basics2.oop;

public class VehicleStarter {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.start();

        Ford ford = new Ford(10);
        ford.start();

        Tesla tesla = new Tesla(10);
        tesla.start();
    }
}

/**
 *  when we remove the @Override from start(int charge) method of Tesla class
 *      & Tesla tesla = new Tesla(0);
 *         tesla.start() // this will call the start() method of Vehicle class.
 *       if we want to call the start() method of Tesla class then we have to call it like this
 *          tesla.start(0); ==> this will consider as new method. not the overrided method.
*          so we have to use @Override annotation.
 *              now it will throw an error because in Vehicle class there is no start(int charge) method.
*                if we call tesla.start() then it will call the start() method of Tesla class.
 *                  when we have @Override annotation & no argument in start() method of Tesla class
 *                tesla.start()     ==> this will call the start() method of Tesla class.
 *
 *
 */

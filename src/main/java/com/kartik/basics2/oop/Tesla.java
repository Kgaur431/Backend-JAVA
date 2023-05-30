package com.kartik.basics2.oop;

public class Tesla extends Vehicle{
    int charge;

    public Tesla(int charge) {
        this.charge = charge;
    }

    @Override
    void start() {
       if(charge <= 0){
           throw new  IllegalStateException("Charge is too low");
       }
       super.start();            // this will call the start method of Vehicle class.
    }

//    @Override

//    void start(int charge) {
//            if(charge <= 0){
//                 throw new  IllegalStateException("Charge is too low");
//             }
//             super.start();            // this will call the start method of Vehicle class.
//         }


}

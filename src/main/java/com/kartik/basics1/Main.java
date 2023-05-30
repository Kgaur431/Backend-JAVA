package com.kartik.basics1;

public class Main {
    public static void main(String[] args) {
        Fruits apple = new Fruits("red", "sweet");
        Fruits orange = new Fruits("orange", "sour");



        System.out.println("Is apple tasty? " + apple.isTasty());
        System.out.println("Is orange tasty? " + orange.isTasty());

        Fruits appleCopy = apple.copy(apple); // this will gives us warning. not call static method using object.
                            // if we call apple.copy(apple) then those are really called Fruits.copy(apple) not any other fun
                            // because at Fruit level we have only single defination of copy method that is in Fruits class.
        Fruits orangeCopy = Fruits.copy(orange); // this is the correct way to call static method.
    }
}


/**
 *  QUES 1:- WHAT DOES IT MEANS STATIC IN TERMS OF OOP'S CONCEPT? || WHAT IS STATIC CODE & NON-STATIC CODE?
 *  ANS:- i. static code can be invoked without instantiating the object. (without creating object)
*         ii. static code is belong to class & non-static code is belong to object.
 *        iii. static code not intialized on compile time ==> wrong answer.
 *        iv. static variable hold same data    ==> wrong answer. that is constant & final.
 *
 *  Point to remember:-
 *      i. initilization is only happen when program runs.
 *      ii. what is static & what is dynamic ?
 *          static:- which is not changeable.
 *          dynamic:- which is changeable.
 *
 *
 */
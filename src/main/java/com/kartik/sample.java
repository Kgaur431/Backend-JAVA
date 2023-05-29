package com.kartik;

public class sample {
    public static void main(String[] args) {
        System.out.println("Hello sample!");


        Fruits.copy(null);
        Person p1 = new Person("Kartik", 25);
    }
        /**
         *  we can't call this constructor because person class is not static but psvm fun is static.
         *
         *  imp rule :- for static
         *              if we want to call || want to print an obj or call a fun which is non static from another fun
         *                  which is static like psvm .  ==> this will not work
         *              why ?
         *              Inside Static Code Body there are certain things we allowed to do
         *                  1. we can't use any of the dynamic stuff of Fruit class. means variable & function which are not static in Fruit.
         *                      1.1 Reason why we can't use variable like color & taste directly into static code body ? like copy method in Fruit class.
         *                          because when the Fruit class is getting executed in my program, there is no single Fruit object made.
         *                          eg:-execute the  Fruit program so it will call from Sample.java (line 8) so only hello world will print. &
         *                              there are no fruits objects are created right now so we can't use color & taste variable inside copy fun
         *                              (line 19)
         *                              "BECAUSE THIS CODE (copy fun) IS running from CONTEXT OF CLASS, NOT FROM CONTEXT OF OBJECT OF FRUIT CLASS"
         *                                  but when we do isTasty() then we can access the taste variable because we already create the object called apple.
         *                                  & my code is running inside an apple. so the concept of color & taste is exists.
         *
         *                                  so when we access the static code means that code exists inside a file & in java we can't write code
         *                                  without creating a class. & static code is write inside a class but there is no fruit object exists.
         *                                  so the "EXSIENCE OF STATIC CODE IS IN JAVA"
         *
         *                                  but we can do one thing, we can deal with the Fruit class obj inside the static code body.
         *                                   static public Fruits copy(Fruits oldFruit) {
                                                 Furits f = new Fruits(oldFruit.color, oldFruit.taste);
                                                        f.taste= "sour";
                                                    return f;
                                                 }
                                            WHY ?
                                                because we have an object & we are accessing taste, isTasty() fun with the reference of object.
                                                not directly access the taste.
                                            so "CREATING OBJECT INSIDE STATIC CODE IS ALLOWED"
                                                "BUT WE CAN'T DIRECTLY ACCESS ANY VARIABLE BECAUSE UNLESS WE CREATE AN OBJECT WE DON'T HAVE ANY FRUITS TO
                                                 DEAL WITH VARIABLE LIKE COLOR & TASTE"

                                            "IF WE CREATE AN OBJECT OF FURIT CLASS INSIDE THE COPY FUN THAT HAS SAME WHEN WE CREATE FRUIT CLASS OBJECT INSIDE
                                               THE MAIN FUN"
         *
         *                2. Why we can't create an object of Person class inside static code body  like psvm ?
         *                       either I have to make the Person class static because anything that is not static like classes
         *                       those things will exists only once the object of sample class is created.
         *
         *                       means when we try to create an object of Person class inside psvm that means the class Person will exists only
         *                          if we construct the object of sample class.
         *                          but when we "MAKE THE PERSON CLASS STATIC" that means we are telling the existence of Person class does not
         *                          require Ojbect of Sample to be created.
         *                          like In the psvm func, when we executing the print fun, & creating the object of Person. we are assuming that
         *                                we not required to create the object of Sample class.
         *
         *                               so the only reason, In Sample.Java the class Sample is exists
         *                                  means this class is not exists for sack of oops programming means Sample class not exists for that we build the
         *                                  object of Sample class. "SAMPLE CLASS ONLY EXISTS FOR JAVA SEMANTICS REQUIREMENT" like we can't write code without
         *                                  creating a class.
         *
     *                                  so inside the Sample class, we don't have any object of Sample class. so we won't be able to use the person class
         *                                  unless the Person class is static.
         *
         *                              therefore, the "MAIN CLASS HAVE THE MAIN FUNCTION FROM WHERE THE PROGRAM GET STARTED & WE CONSTRUCT THE
         *                                              OBJECT OF OTHER CLASS" otherwise if we write all code inside the main class then we have to make all of ]
         *                                              things static. like Person class.
         *
         *                                             "MAIN FUN IS THE ONLY PLACE WHERE WE ARE NOT DOING OOPS PROGRAMMING CONCEPTUALLY
         *                                              , WE ARE SIMPLY RUNNING A FUNCTION SO THE CODE INSIDE THE MAIN FUN IS PROCEDURAL.
         *                                              THE OOPS CONCEPT APPLIDE TO ALL THE CLASSES THAT OUTSIDE FROM THE MAIN CLASS"
         *
         *
         */

   //class Person {
    static  class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age  = age;
        }
    }

    /**
     *  Points to remember:-
     *      1. any code that we write, we can never write code unless we first write class inside that only we can write code.
     *          if we have any code that object no need to be created to run that code then we can write that code inside static code body.
     *          but we can't write outside the class.
 *          2. WHY WE NOT USE STATIC CONSTRUCTOR ?
     *             static we use for create var, fun which intend to exists outside of the existance of any obj of that class.
     *             but the purpose of constructor is to create object for that class. so there is not point to being static.
     *                   constructor are neither static nor dynamic. bcoz constructor don't execute from within the object.
     *                   non constructor are used to work with any static field of that class.
     */

}

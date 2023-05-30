

class  Fruit {
    // int size; 
        private int size;               --> 4 byte
        protected int getSize() {
            return size;
        }

}

class Mango extends Fruit{
     boolean ripe;                  --> 1 byte
    public boolean isLarge() {
         return getSize() > 5;
    }
}

Fruit f = new Mango();
Mango m = new Fruit(); 

Simple ANSWER:
    all mango object are fruit
    but all fruit object are not definately mango object. 

Mango m = new Mango();    --> size(m) = 5 byte // when size is public
Mango m = new Mango();    --> size(m) = ? byte // when size is private
m.isLarge();        -->

Ques 1. If making size var private then what will be the size of mango object?
Ques 2. m.isLarge(); --> will it work? 

assume if size var is private then object m is 1 byte & if m.isLarge() is work 
            if both true then it means if size of m object is 1 byte that means size is not exists 
            inside m object that means m can't access size var so m.isLarge() should not able to work.  

actual in JAVA if we not initialised the var then var  have by default value so the size is still there in m object. 
         so size of m object is 5 byte. (primitive type int by default java give 0 value) so size var takes memory of 4 byte.
            so m.isLarge() will work. ==> return false because size is 0 & 0 is not greater than 5.
         
         size of m is 5 byte. & it is not depends on intialisation of var
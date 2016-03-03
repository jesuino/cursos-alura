package org.william;

public class Teste {
    public static void main(String[] args) {

        Programa p1 = new Programa();    
        p1.setId(1);

        Thread t1 = new Thread(p1);
        t1.start();

        Programa p2 = new Programa();    
        p2.setId(2);

        Thread t2 = new Thread(p2);
        t2.start();                

    }
}
package org.example;

import org.example.Components.Supermarket;
import org.example.Realization.Consumer;
import org.example.Realization.DataCashQueue;
import org.example.Realization.Producer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numOfCashRegisters = 3;
        int[] serviceTimes = {2000, 3000, 4000};
        Supermarket supermarket = new Supermarket(numOfCashRegisters, serviceTimes);


        List<Thread> cashierThreads = new ArrayList<>();
        for (int i = 0; i < numOfCashRegisters; i++) {
            Consumer cashier = new Consumer(supermarket);
            Thread cashierThread = new Thread(cashier);
            cashierThreads.add(cashierThread);
            cashierThread.start();
        }

        Producer clientGenerator = new Producer(supermarket);
        Thread generatorThread = new Thread(clientGenerator);
        generatorThread.start();

        for (Thread thread : cashierThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

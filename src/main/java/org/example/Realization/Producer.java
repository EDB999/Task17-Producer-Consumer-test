package org.example.Realization;

import org.example.Components.Client;
import org.example.Components.Supermarket;

import java.util.Random;

public class Producer implements Runnable {
    private final Supermarket supermarket;
    private final Random random;
    private int clientCounter = 0;

    private final String[] surnames = {"Дмитриев", "Артёмова", "Фантокин", "Тюленев", "Забурдяев"};

    public Producer(Supermarket supermarket) {
        this.supermarket = supermarket;
        this.random = new Random();
    }

    @Override
    public void run() {
        produce();
    }

    private void produce() {
        while (true) {
            try {
                Thread.sleep(2000); // Generating clients every 2 seconds
                Client client = generateClient();
                DataCashQueue chosenCashRegister = supermarket.getMinQueueCashRegister();
                chosenCashRegister.addToQueue(client);
                System.out.println("Новый клиент вошёл и присоединился к кассе под номером: " + chosenCashRegister.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Client generateClient() {
        clientCounter++;
        String surname = surnames[random.nextInt(surnames.length)];
        return new Client(clientCounter, surname);
    }
}
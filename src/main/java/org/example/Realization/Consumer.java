package org.example.Realization;

import org.example.Components.Client;
import org.example.Components.Supermarket;

public class Consumer implements Runnable {
    private DataCashQueue cashRegister;
    private final Supermarket supermarket;

    public Consumer(Supermarket supermarket) {
        this.supermarket = supermarket;

        this.cashRegister = supermarket.getMinQueueCashRegister();
    }

    @Override
    public void run() {
        consume();
    }

    private void consume() {
        while (true) {
            try {
                Client client = cashRegister.getNextClient();
                if (client != null) {
                    cashRegister.serviceClient(client);
                } else {
                    cashRegister = supermarket.getMinQueueCashRegister();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

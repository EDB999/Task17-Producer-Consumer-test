package org.example.Components;

import org.example.Realization.DataCashQueue;

public class Supermarket {
    private final DataCashQueue[] cashRegisters;

    public Supermarket(int numOfCashRegisters, int[] serviceTimes) {
        this.cashRegisters = new DataCashQueue[numOfCashRegisters];
        for (int i = 0; i < numOfCashRegisters; i++) {
            cashRegisters[i] = new DataCashQueue(i + 1, serviceTimes[i]);
        }
    }

    public synchronized DataCashQueue getMinQueueCashRegister() {
        DataCashQueue minQueueCashRegister = cashRegisters[0];
        for (DataCashQueue cashRegister : cashRegisters) {
            if (cashRegister.getQueueSize() < minQueueCashRegister.getQueueSize()) {
                minQueueCashRegister = cashRegister;
            }
        }
        return minQueueCashRegister;
    }

    public DataCashQueue[] getCashRegisters() {
        return cashRegisters;
    }
}


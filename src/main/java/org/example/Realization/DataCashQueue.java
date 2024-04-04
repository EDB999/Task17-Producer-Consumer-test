package org.example.Realization;

import org.example.Components.Client;

import java.util.LinkedList;
import java.util.Queue;

public class DataCashQueue {
    private final int id;
    private final int serviceTime;
    private final Queue<Client> queue;

    public DataCashQueue(int id, int serviceTime) {
        this.id = id;
        this.serviceTime = serviceTime;
        this.queue = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public synchronized void serviceClient(Client client) throws InterruptedException {
        System.out.println("Касса под номером: " + id + " Начало обслуживания клиента: " + client);
        Thread.sleep(serviceTime);
        System.out.println("Касса под номером: " + id + " Конец обслуживания клиента: " + client);
    }

    public synchronized void addToQueue(Client client) {
        queue.add(client);
        System.out.println("Клиент: " + client.getId() + " присоединился к очереди кассы под номером: " + id);
    }

    public synchronized Client getNextClient() {
        return queue.poll();
    }

    public synchronized int getQueueSize() {
        return queue.size();
    }
}
package org.example.Components;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Client {
    private int id;
    private String surname;

    @Override
    public String toString() {
        return "Client ID: " + id + ", Surname: " + surname;
    }
}


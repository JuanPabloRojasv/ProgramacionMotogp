package com.example.api_programacion.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node {
    private Kid data;
    private Node next;

    public Node(Kid data){
        this.data = data;
    }
}

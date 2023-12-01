package com.example.cafes2;

public class Producto {
    private String nombre;
    private String pedido;

    public Producto(String nombre, String pedido) {
        this.nombre = nombre;
        this.pedido = pedido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPedido() {
        return pedido;
    }
}

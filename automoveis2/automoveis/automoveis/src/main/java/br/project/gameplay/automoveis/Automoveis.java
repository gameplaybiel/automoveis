package br.project.gameplay.automoveis;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Automoveis {

    private int id;
    private String cliente;
    private String modelo;
    private String placa;

    public Automoveis() {

    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getModelo() {
        return modelo;
    }
    public String getPlaca() {
        return placa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
}

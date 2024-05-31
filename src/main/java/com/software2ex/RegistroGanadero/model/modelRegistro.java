package com.software2ex.RegistroGanadero.model;

public class modelRegistro {
    private Long id;
    private String name;
    private String edad;
    private String raza;
    private String hijos;

    

    public modelRegistro(Long id, String name, String edad, String raza, String hijos) {
        this.id = id;
        this.name = name;
        this.edad = edad;
        this.raza = raza;
        this.hijos = hijos;
    }

    public modelRegistro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getHijos() {
        return hijos;
    }

    public void setHijos(String hijos) {
        this.hijos = hijos;
    }

}

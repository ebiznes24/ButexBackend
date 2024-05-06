package io.github.butexbackend.model;

public enum ProductType {

    SNEAKERS("Trampki"),
    ATHLETIC_SHOES("Buty sportowe"),
    BOOTS("Kozaki"),
    HIGH_HEELS("Szpilki"),
    LOAFERS("Mokasyny"),
    SANDALS("Sandały"),
    ESPADRILLES("Espadryle"),
    HIKING_BOOTS("Trapery"),
    BALLET_FLATS("Baleriny"),
    BROGUES("Brogs");

    public final String name;

    ProductType(String name) {
        this.name = name;
    }
}
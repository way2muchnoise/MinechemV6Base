package minechemV6Base.chemical.properties;

public enum StateEnum {
    solid("Solid"),
    liquid("Liquid"),
    gas("Gas"),
    plasma("Plasma");

    private String name;

    StateEnum(String name){
        this.name = name;
    }

    public String getDisplay()
    {
        return this.name;
    }
}

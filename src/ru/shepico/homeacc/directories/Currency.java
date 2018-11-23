package ru.shepico.homeacc.directories;

public class Currency {
    private int id;
    private String name;

    public Currency(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return (this.id + " " + this.name);
    }

}

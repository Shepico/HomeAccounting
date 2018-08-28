package ru.shepico.directories;

public class Account implements Idirectory {
    private String name;
    private String currency;
    private Account parent;

    public Account (String name, String currency, Account parrent) {
        this.name = name;
        this.currency = currency;
        this.parent = parent;
        this.addElement();

    }

    @Override
    public boolean addElement() {

        return false;
    }

    @Override
    public boolean removeElement() {
        return false;
    }

    @Override
    public boolean changeElement() {
        return false;
    }

    @Override
    public boolean toArchiveElement() {
        return false;
    }

    @Override
    public boolean fromArchiveElement() {
        return false;
    }
}

package ru.shepico.homeacc.directories;

public class Account implements Idirectory {
    private String name;
    private String currency;
    private Account parent;

    public Account (String name, String currency, Account parrent) {
        this.name = name;
        this.currency = currency;
        this.parent = parent;
        //this.addElement();

    }

    @Override
    public String addElement(String[] value ) {
        String newName = "";
        for (int i=0; i<value.length; i++) {
            if ("".equals(newName)) {
                newName = "'" + value[i] + "'";
            }
            else {
                 newName = newName + ", '" + value[i] + "'";
             }
        }
        String sqlQuery = "INSERT INTO account (acc_name) VALUES ('" + newName + "');";
        return sqlQuery;
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

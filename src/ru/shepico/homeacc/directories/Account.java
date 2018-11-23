package ru.shepico.homeacc.directories;

public class Account{
    private int id;
    private String name;
    private boolean isGroup;
    private int currencyID;
    private int parentID;
    private int userID;

    public Account (int id, String name, boolean isGroup, int currencyID, int parentID, int userID){
        this.id = id;
        this.name = name;
        this.isGroup = isGroup;
        this.currencyID = currencyID;
        this.parentID = parentID;
        this.userID = userID;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public int getCurrencyID() {
        return currencyID;
    }

    public int getParentID() {
        return parentID;
    }

    public int getUserID() {
        return userID;
    }

}

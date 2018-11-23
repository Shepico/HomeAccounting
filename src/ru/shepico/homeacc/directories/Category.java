package ru.shepico.homeacc.directories;

public class Category {
    private int id;
    private String name;
    private boolean isGroup;
    private int parentID;
    private int userID;

    public Category(int id, String name, boolean isGroup, int parentID, int userID){
        this.id = id;
        this.name = name;
        this.isGroup = isGroup;
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

    public int getParentID() {
        return parentID;
    }

    public int getUserID() {
        return userID;
    }
}

package ru.shepico.homeacc.directories;

public class Currency implements Idirectory {
    private String name;

    @Override
    public String addElement(String[] newName) {
        String sqlQuery = "INSERT INTO currency (crcy_name) VALUES ('" + newName[0] + "');";
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

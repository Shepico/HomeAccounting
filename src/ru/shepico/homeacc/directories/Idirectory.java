package ru.shepico.homeacc.directories;

public interface Idirectory {

    String addElement (String[] str);
    boolean removeElement();
    boolean changeElement();
    boolean toArchiveElement();
    boolean fromArchiveElement();
}

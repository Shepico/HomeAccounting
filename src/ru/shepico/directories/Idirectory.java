package ru.shepico.directories;

public interface Idirectory {

    boolean addElement ();
    boolean removeElement();
    boolean changeElement();
    boolean toArchiveElement();
    boolean fromArchiveElement();
}

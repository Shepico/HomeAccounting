package ru.shepico.homeacc.directories;

import java.awt.event.ActionListener;

public interface Idirectory {

    boolean addElement ();
    boolean removeElement();
    boolean changeElement();
    boolean toArchiveElement();
    boolean fromArchiveElement();
}

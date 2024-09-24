package edu.mum.cs.cs525.labs.exercises.project.business.framework;

public interface Command {
    void execute();
    void undo();
}

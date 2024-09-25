package edu.mum.cs.cs525.labs.exercises.project.business.framework;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Account account);
}

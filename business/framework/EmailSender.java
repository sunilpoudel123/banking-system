package edu.mum.cs.cs525.labs.exercises.project.business.framework;


public interface EmailSender {
    public void sendEmail(String from, String to, String title, String body);
}
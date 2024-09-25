package edu.mum.cs.cs525.labs.exercises.project.business.framework;


public class MockEmailSender implements EmailSender {
    public void sendEmail(String from, String to, String title, String body) {
        System.out.println("================================================================================");
        System.out.println("from: " + from);
        System.out.println("to: " + to);
        System.out.println("title: " + title);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(body);
        System.out.println("================================================================================");
    }
}
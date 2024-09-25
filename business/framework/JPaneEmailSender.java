package edu.mum.cs.cs525.labs.exercises.project.business.framework;


import javax.swing.*;

public class JPaneEmailSender implements EmailSender {
    public void sendEmail(String from, String to, String title, String body) {
        StringBuilder sb = new StringBuilder();
        sb.append("================================================================================\n");
        sb.append("from: " + from + "\n");
        sb.append("to: " + to + "\n");
        sb.append("title: " + title + "\n");
        sb.append("--------------------------------------------------------------------------------" + "\n");
        sb.append(body);
        sb.append("\n");
        sb.append("================================================================================" + "\n");
        JOptionPane.showMessageDialog(null, sb.toString(), "send email", JOptionPane.INFORMATION_MESSAGE);
    }
}
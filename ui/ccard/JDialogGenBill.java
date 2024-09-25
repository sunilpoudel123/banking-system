package edu.mum.cs.cs525.labs.exercises.project.ui.ccard;
/*
		A basic implementation of the JDialog class.
*/

import edu.mum.cs.cs525.labs.exercises.project.business.ccard.CreditCardAccountType;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.business.framework.ApplicationFacade;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JDialogGenBill extends javax.swing.JDialog {
    private ApplicationFacade<CreditCardAccountType> applicationFacade;
    String billstring;

    public JDialogGenBill(Frame parent, JTable JTable1, DefaultTableModel model, ApplicationFacade<CreditCardAccountType> applicationFacade) {
        super(parent);

        // Initialize components
        getContentPane().setLayout(null);
        setSize(405, 367);
        setVisible(false);
        getContentPane().add(JScrollPane1);
        JScrollPane1.setBounds(24, 24, 358, 240);
        JScrollPane1.getViewport().add(JTextField1);
        JTextField1.setBounds(0, 0, 355, 237);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(156, 276, 96, 24);

        // Register listeners
        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);

        // Get selected account number from JTable
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0 && model.getRowCount() > 0) {
            String accountNumber = (String) model.getValueAt(selection, 1);
            Account acc = applicationFacade.getAccount(accountNumber);
            if (acc != null) {
                System.out.println("Details are being generated");
                String report = acc.generate();
                JTextField1.setText(report);
            } else {
                JTextField1.setText("Account not found.");
            }
        } else {
            JTextField1.setText("No account selected.");
        }
    }


    //{{DECLARE_CONTROLS
    javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
    javax.swing.JTextField JTextField1 = new javax.swing.JTextField();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    //}}

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_OK)
                JButtonOK_actionPerformed(event);
        }
    }

    void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
        dispose();

    }
}

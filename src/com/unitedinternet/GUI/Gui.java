package com.unitedinternet.GUI;

import com.unitedinternet.Libary.PortChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {

    private JButton scanButton = new JButton("Jetzt scannen");
    private JLabel label = new JLabel("Used ports:");
    private JTextArea textArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(textArea);
    public void openGUI(){
        setTitle("Port Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(scanButton, BorderLayout.SOUTH);

        setResizable(true);
        setSize(400,300);
        setVisible(true);

        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scanButton.setText("Scanning...");
                scanButton.setEnabled(false);

                textArea.setText("");

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        PortChecker portChecker = new PortChecker();

                        for(int i=0; i<65535; i++) {
                            if (portChecker.isPortUsed("localhost", i)){
                                textArea.setText(textArea.getText()+i+"\n");
                            }
                        }
                        scanButton.setText("Jetzt scannen");
                        scanButton.setEnabled(true);
                    }
                });
                t.start();
            }
        });
    }
}

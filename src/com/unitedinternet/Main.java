package com.unitedinternet;

import com.unitedinternet.GUI.Gui;
import com.unitedinternet.Libary.PortChecker;

public class Main {

    public static void main(String[] args) {
        if(args[0].equalsIgnoreCase("--headless")){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    PortChecker portChecker = new PortChecker();

                    for(int i=0; i<65535; i++) {
                        if (portChecker.isPortUsed("localhost", i)){
                            System.out.println(i);
                        }
                    }
                }
            });
            t.start();
        }else if(args[0].equalsIgnoreCase("--help")){
            System.out.println("--help\tZeige die Hilfe an.");
            System.out.println("--headless\tGibt alle belegten Ports aus ohne eine GUI zu öffnen.");
        }else {
            Gui gui = new Gui();
            gui.openGUI();
        }
    }
}

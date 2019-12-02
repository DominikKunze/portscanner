package com.unitedinternet.Libary;

import java.io.IOException;
import java.net.Socket;

public class PortChecker {
    public boolean isPortUsed(String host, int port){
        try {
            Socket socket = new Socket(host,port);
            socket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}

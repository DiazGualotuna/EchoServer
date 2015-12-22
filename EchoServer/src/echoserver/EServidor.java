/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;


 
import java.net.*;
import java.io.*;
 
public class EServidor {
    public static void main(String[] args) throws IOException {
         
        try {
      ServerSocket Sserver = new ServerSocket(5566);
      while (true) {
        Socket Scliente = Sserver.accept();
        miThread thread = new miThread(Scliente);
        thread.start();
      }
    }
    catch (Exception e) {
      System.err.println("Exception caught:" + e);
    }
  }
}
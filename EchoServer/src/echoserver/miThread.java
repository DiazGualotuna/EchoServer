/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import java.io.*;
import java.net.*;

public class miThread extends Thread{
    Socket Scliente;
     miThread (Socket Scliente) {
        this.Scliente = Scliente;
     }
    public void run(){
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(Scliente.getInputStream()));
      PrintWriter writer = new PrintWriter(Scliente.getOutputStream(), true);
      writer.println("[ 'bye'para desconectar]");

      while (true) {
        String line = reader.readLine();
        if (line.trim().equals("bye")) {
          writer.println("bye!");
          break;
        }
          System.out.println(line);
        writer.println("[echo] " +" "+ line );
      }
    }
    catch (Exception e) {
      System.err.println("Exception caught: El cliente se desconectó");
    }
    finally {
      try { Scliente.close(); }
      catch (Exception e ){ ; }
    }
  
    }
}

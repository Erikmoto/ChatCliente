package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Interface.InterfaceCliente;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author ryuic
 */
public class Recebedor implements Runnable {
 
   private InputStream servidor;
   private InterfaceCliente interfaceCliente;
 
   public Recebedor(InputStream servidor, InterfaceCliente interfaceCliente) {
     this.servidor = servidor;
     this.interfaceCliente = interfaceCliente;
   }
 
   public void run() {
     // recebe msgs do servidor e imprime na tela
     Scanner s = new Scanner(this.servidor);
     JTextArea areaTexto = interfaceCliente.getAreaTexto();
     
     while (s.hasNextLine()) {
       System.out.println(s.nextLine());
       areaTexto.setText(areaTexto.getText() + s.nextLine());
     }
   }
 }
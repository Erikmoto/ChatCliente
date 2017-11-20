package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Interface.InterfaceCliente;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author ryuic
 */
public class Cliente {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // dispara socketCliente
        Cliente cliente = new Cliente();
        cliente.interfaceCliente.setVisible(true);
    }
    
    private String host;
    private int porta;
    private final InterfaceCliente interfaceCliente;
    private Socket socketCliente;
    private PrintStream saidaMensagem;

    private Cliente() {
        this.interfaceCliente = new InterfaceCliente(this);
    }
    
    public void executa() {
        try {
            socketCliente = new Socket(this.host, this.porta);
            System.out.println("O cliente se conectou ao servidor!");
            
            // thread para receber mensagens do servidor
            Recebedor r;
            
            r = new Recebedor(socketCliente.getInputStream(), interfaceCliente);
            new Thread(r).start();
            
            capturaMensagens();
            
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
    
    private void capturaMensagens() {
        try {
            // lê msgs do teclado e manda pro servidor
            Scanner teclado;
            teclado = new Scanner(System.in);
            PrintStream saida;
            
            saida = new PrintStream(socketCliente.getOutputStream());
            
            String mensagem;
            
            while (teclado.hasNextLine()) {
                mensagem = teclado.nextLine();
                saida.println(mensagem);
                this.mostraMensagens(mensagem);
            }

            saida.close();
            teclado.close();
            socketCliente.close();
            
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void capturaMensagens(String mensagem) {
        this.mostraMensagens(mensagem);
    }
    
    private void mostraMensagens(String mensagem) {
        String mensagemBinario = this.converteStringParaBinario(mensagem);
        String mensagemManchester = this.converteBinarioParaManchester(mensagemBinario);
        JTextArea areaTexto = this.interfaceCliente.getAreaTexto();
        
        areaTexto.setText(areaTexto.getText() + "\n" + mensagem + "\n" + "Binário: " + mensagemBinario + "\n" + "Manchester: " + mensagemManchester + "\n");
        
        try {
            saidaMensagem = new PrintStream(socketCliente.getOutputStream());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
            
        saidaMensagem.println(mensagemManchester);
    }
    
    private String converteStringParaBinario(String mensagem) {
        char[] caracteres = mensagem.toCharArray();
        String mensagemBinario = ""; 
        String binario;
        
        for (int i = 0; i < caracteres.length; i++) {  
            binario = Integer.toBinaryString(caracteres[i]);
            
            while(binario.length() < 16) {
                binario = "0" + binario;
            }
            
            mensagemBinario = mensagemBinario + binario;
        }
        
        return mensagemBinario;
    }
    
    private String converteBinarioParaManchester(String mensagemBinario) {
        String mensagemManchester = "";
        
        for(int i = 0; i < mensagemBinario.length(); i++) {
            if(mensagemBinario.charAt(i) == '0') {
                mensagemManchester = mensagemManchester + "10";
            }
            
            else {
                mensagemManchester = mensagemManchester + "01";
            }
        }
        
        return mensagemManchester;
    }
    
    public void fechar() {
        try {
            saidaMensagem.close();
            socketCliente.close();
        } catch (IOException ex) {
            System.out.println(ex + ": Erro Socket");
        }
    }

    public String getHost() {
        return host;
    }

    public int getPorta() {
        return porta;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }
}
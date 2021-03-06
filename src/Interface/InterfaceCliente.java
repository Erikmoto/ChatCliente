/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Classes.Cliente;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author ryuic
 */
public class InterfaceCliente extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceCliente
     */
    
    private Cliente cliente;
    private final MaskFormatter formatador = new MaskFormatter();
    private boolean IPValido = false;
    private final String textoCampoIP = "___.___.___.___";
    
    public InterfaceCliente(Cliente cliente) {
        this.cliente = cliente;
        initComponents();
    }

    private InterfaceCliente() {
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoIP = new javax.swing.JFormattedTextField();
        campoPorta = new javax.swing.JFormattedTextField();
        status = new javax.swing.JLabel();
        rotuloIP = new javax.swing.JLabel();
        rotuloPorta = new javax.swing.JLabel();
        rotuloStatus = new javax.swing.JLabel();
        painelTexto = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        campoMensagem = new javax.swing.JTextField();
        enviarMensagem = new javax.swing.JButton();
        conectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        formatador.setValidCharacters("_0123456789");

        try {
            formatador.setMask("***.***.***.***");
        } catch (ParseException ex) {
            System.out.println(ex.toString() + ": Erro Máscara");
        }

        formatador.install(campoIP);
        campoIP.setText("___.___.___.___");
        campoIP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoIP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoIPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoIPFocusLost(evt);
            }
        });
        campoIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoIPKeyTyped(evt);
            }
        });

        campoPorta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        status.setBackground(new java.awt.Color(255, 204, 204));
        status.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        status.setForeground(new java.awt.Color(153, 0, 0));
        status.setText("Desconectado");
        status.setOpaque(true);

        rotuloIP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rotuloIP.setText("Endereço IP");

        rotuloPorta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rotuloPorta.setText("Porta");

        rotuloStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rotuloStatus.setText("Status");

        areaTexto.setEditable(false);
        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        painelTexto.setViewportView(areaTexto);

        campoMensagem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoMensagem.setEnabled(false);
        campoMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoMensagemKeyTyped(evt);
            }
        });

        enviarMensagem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enviarMensagem.setText("Enviar");
        enviarMensagem.setEnabled(false);
        enviarMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarMensagemActionPerformed(evt);
            }
        });

        conectar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        conectar.setText("Conectar");
        conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(painelTexto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(rotuloIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(rotuloPorta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rotuloStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(conectar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(campoMensagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enviarMensagem)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloIP)
                    .addComponent(rotuloPorta)
                    .addComponent(campoIP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloStatus)
                    .addComponent(status)
                    .addComponent(conectar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(painelTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enviarMensagem))
                .addGap(53, 53, 53))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {campoIP, rotuloIP});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {campoPorta, rotuloPorta});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {rotuloStatus, status});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void enviaMensagem() {
        String mensagem = campoMensagem.getText();
        campoMensagem.setText("");
        campoMensagem.requestFocusInWindow();
        
        Thread enviaMensagem = new Thread() {
            @Override
            public void run() {
                cliente.capturaMensagens(mensagem);
            }
        };
        
        enviaMensagem.start();
    }
    
    private void enviarMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarMensagemActionPerformed
        enviaMensagem();
    }//GEN-LAST:event_enviarMensagemActionPerformed

    private void formataCampoIP() {
        campoIP.setCaretPosition(0);
    }
    
    private void campoIPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoIPFocusGained
        formataCampoIP();
    }//GEN-LAST:event_campoIPFocusGained
    
    private void conectar() {
        cliente.setHost(campoIP.getText().trim());
        cliente.setPorta(Integer.parseInt(campoPorta.getText()));
        
        areaTexto.setEnabled(true);
        campoMensagem.setEnabled(true);
        enviarMensagem.setEnabled(true);
        status.setText("Conectado");
        status.setForeground(new Color(100, 150, 125));
        status.setBackground(new Color(100, 255, 200));
        campoMensagem.requestFocusInWindow();
        
        //this.dispose();
        Thread conectaCliente = new Thread() {
            @Override
            public void run() {
                cliente.executa();
            }
        };
        
        conectaCliente.start();
    }
    
    private void conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarActionPerformed
        if(IPValido) {
            conectar();
        }
        
        else {
            campoIP.requestFocus();
        }
    }//GEN-LAST:event_conectarActionPerformed
    
    private void verificaIP() {
        String IP = campoIP.getText();
        
        if(IP.equals(textoCampoIP)) {
            IPValido = false;
            campoIP.setBackground(new Color(255, 155, 155));
        }

        else {
            campoIP.setText(IP.replaceAll("_", " "));
            IPValido = true;
            campoIP.setBackground(new Color(55, 255, 155));
        }
    }
    
    private void campoIPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoIPFocusLost
        verificaIP();
    }//GEN-LAST:event_campoIPFocusLost
    
    private void verificaTecla(KeyEvent evt) {
        if(evt.getKeyChar() == '_') {
            evt.consume();
        }
    }
    
    private void campoIPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoIPKeyTyped
        verificaTecla(evt);
    }//GEN-LAST:event_campoIPKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        cliente.fechar();
    }//GEN-LAST:event_formWindowClosing
    
    private void enterPressionado(char tecla) {
        if(tecla == '\n') {
            enviaMensagem();
        }
    }
    
    private void campoMensagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMensagemKeyTyped
        enterPressionado(evt.getKeyChar());
    }//GEN-LAST:event_campoMensagemKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JFormattedTextField campoIP;
    private javax.swing.JTextField campoMensagem;
    private javax.swing.JFormattedTextField campoPorta;
    private javax.swing.JButton conectar;
    private javax.swing.JButton enviarMensagem;
    private javax.swing.JScrollPane painelTexto;
    private javax.swing.JLabel rotuloIP;
    private javax.swing.JLabel rotuloPorta;
    private javax.swing.JLabel rotuloStatus;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextArea getAreaTexto() {
        return areaTexto;
    }

    public void setAreaTexto(javax.swing.JTextArea areaTexto) {
        this.areaTexto = areaTexto;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinaled;

import ArvBinPesq.ABP;
import ArvBinPesq.No;
import PacoteCanvas.Canvas;
import PacoteCanvas.Circulo;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;

/**
 *
 * @author jpedr
 */
public class TelaArvBin extends javax.swing.JFrame {

    private Canvas canvas;
    private Circulo circulo;
    private No no;
    private ABP abp;
    int x, y, yAux, xAux;
    int retorna = 1;
    
    public TelaArvBin() {
        initComponents();
        canvas = new Canvas();
        canvas.setBounds(HEIGHT + 2, WIDTH + 150, 660, 415);
        this.add(canvas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbltamanho = new javax.swing.JLabel();
        lblraiz = new javax.swing.JLabel();
        lblelementoinserido = new javax.swing.JLabel();
        criarArvore = new javax.swing.JButton();
        buscarNaArvore = new javax.swing.JButton();
        inserirNaArvore = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Árvore Binária de Pesquisa");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações da árvore"));

        lbltamanho.setText("Tamanho: ");

        lblraiz.setText("Raiz:");

        lblelementoinserido.setText("Elemento inserido: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltamanho)
                    .addComponent(lblelementoinserido)
                    .addComponent(lblraiz))
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbltamanho)
                .addGap(11, 11, 11)
                .addComponent(lblraiz)
                .addGap(11, 11, 11)
                .addComponent(lblelementoinserido)
                .addGap(11, 11, 11))
        );

        criarArvore.setText("Criar árvore");
        criarArvore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarArvoreActionPerformed(evt);
            }
        });

        buscarNaArvore.setText("Buscar na árvore");
        buscarNaArvore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarNaArvoreActionPerformed(evt);
            }
        });

        inserirNaArvore.setText("Inserir na árvore");
        inserirNaArvore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirNaArvoreActionPerformed(evt);
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
                        .addComponent(criarArvore, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(buscarNaArvore, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(inserirNaArvore, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(criarArvore, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarNaArvore, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(inserirNaArvore, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(419, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void criarArvoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarArvoreActionPerformed
        //se a estrutura estiver vázia lancará uma mensagem de erro;
        if (canvas.Tamanho() == 0) {
            // instanciando a arvore;
            abp = new ABP();

            //printando no label o tamanho:
            lbltamanho.setText("Tamanho: 0");

            //printando no label raiz da arvore;
            lblraiz.setText(String.valueOf("Raiz: null"));
            
            lblelementoinserido.setText(String.valueOf("Elemento Inserido: null"));

            //passando posição que começará a arvore;
            xAux = x = 100;
            yAux = y = 0;

            //instancia circulo e faço as alterações para arvore;
            circulo = new Circulo();

        } else {
            //exibe uma mensagem de erro;
            JOptionPane.showMessageDialog(null, "Uma estrutura já foi criada. Remova todos os elementos"
                    + " da estrutura para criar outra !", "CRIAR ARVORE", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_criarArvoreActionPerformed

    private void buscarNaArvoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarNaArvoreActionPerformed
        No valor;
        
        //verifica se a fila está vazia;
        if (!abp.vazia()) {

            //mosta o valor no topo da fila;
            valor = abp.busca(Integer.parseInt(JOptionPane.showInputDialog("Qual valor deseja buscar na arvore?")));
            JOptionPane.showMessageDialog(null, "O valor " + valor, "CONSULTA ELEMENTO", JOptionPane.INFORMATION_MESSAGE);
        } else {

            //exibe uma mensagem de erro se a pilha estiver vazia;
            JOptionPane.showMessageDialog(null, "A arvore está vazia.", "CONSULTA ELEMENTO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buscarNaArvoreActionPerformed

    private void inserirNaArvoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirNaArvoreActionPerformed
        int valorInserido;
        
        valorInserido = Integer.parseInt(JOptionPane.showInputDialog("Qual valor deseja inserir na arvore?"));
        
        //se a inserção na fila for bem sucedida ele pinta na tela;
        if (abp.insere(valorInserido)) {
            
            if(abp.getTamanho() == 1){
                lblraiz.setText(String.valueOf("Raiz: " + abp.getRaiz()));
            }
            lbltamanho.setText("Tamanho: " + abp.getTamanho());
            
            lblelementoinserido.setText(String.valueOf("Elemento Inserido: "+ valorInserido));
            
            
            //distancia entre os retangulos;
            if(abp.getPosicaoEsq() > 0 && abp.getPosicaoDir() == 0){
                x = x - 70;
            }else if(abp.getPosicaoEsq() == 0 && abp.getPosicaoDir() > 0){
                x = xAux + 70;
                y = yAux + 20 * abp.getPosicaoDir();
            }else if(abp.getPosicaoDir() > 0 || abp.getPosicaoEsq() > 0){
                x = xAux - 70;
                y = yAux - (abp.getPosicaoDir() + abp.getPosicaoEsq());
            }
            

            //instanciando o retangulo e passando os atributos;
            circulo = new Circulo();
            circulo.setCoordX(x);
            circulo.setCoordY(y);
            circulo.setValor(Integer.toString(valorInserido));
            circulo.setBasePx(50);
            circulo.setAlturaPx(50);
            
            y = y + 45;
            //adicionando circulo no canvas;
            canvas.adicionar(circulo);

            //gerando o circulo na tela;
            canvas.paintArvBin(canvas.getGraphics());


        } else {
            //exibe mensagem de erro;
            JOptionPane.showMessageDialog(null, "A árvore está cheia!", "Falha na inserção do Elemento", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_inserirNaArvoreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaArvBin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaArvBin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaArvBin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaArvBin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaArvBin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarNaArvore;
    private javax.swing.JButton criarArvore;
    private javax.swing.JButton inserirNaArvore;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblelementoinserido;
    private javax.swing.JLabel lblraiz;
    private javax.swing.JLabel lbltamanho;
    // End of variables declaration//GEN-END:variables
}

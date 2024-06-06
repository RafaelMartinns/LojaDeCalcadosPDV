/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.lojacalcados.views;

import com.mycompany.lojacalcados.dao.ProdutoTamanhoDAO;
import com.mycompany.lojacalcados.utils.Validador;
import com.mycompany.lojacalcados.models.ProdutoTamanho;
import javax.swing.JOptionPane;


public class TelaProdutoTamanho extends javax.swing.JFrame {

    /**
     * Creates new form TelaProdutoTamanho
     */
    public TelaProdutoTamanho() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelarProdutoTamanho = new javax.swing.JButton();
        btnAdicionarProdutoTamanho = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdProdutoAdicionado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spnQtdProdutoTamanho = new javax.swing.JSpinner();
        spnTamanhoProduto = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelarProdutoTamanho.setText("Cancelar");
        btnCancelarProdutoTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProdutoTamanhoActionPerformed(evt);
            }
        });

        btnAdicionarProdutoTamanho.setText("Salvar");
        btnAdicionarProdutoTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarProdutoTamanhoActionPerformed(evt);
            }
        });

        jLabel1.setText("Id. Produto:");

        txtIdProdutoAdicionado.setEnabled(false);
        txtIdProdutoAdicionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProdutoAdicionadoActionPerformed(evt);
            }
        });

        jLabel2.setText("Tamanho:");

        jLabel3.setText("Qtd:");

        spnQtdProdutoTamanho.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spnTamanhoProduto.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnCancelarProdutoTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdicionarProdutoTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spnTamanhoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 30, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnQtdProdutoTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIdProdutoAdicionado))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdProdutoAdicionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(spnQtdProdutoTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnTamanhoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarProdutoTamanho)
                    .addComponent(btnAdicionarProdutoTamanho))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdProdutoAdicionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProdutoAdicionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProdutoAdicionadoActionPerformed

    private void btnCancelarProdutoTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProdutoTamanhoActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarProdutoTamanhoActionPerformed

    private void btnAdicionarProdutoTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoTamanhoActionPerformed
        try {
            Validador.validarSpinner(spnQtdProdutoTamanho);
            Validador.validarSpinner(spnQtdProdutoTamanho);
            
            int qtd = Integer.parseInt(spnQtdProdutoTamanho.getValue().toString());
            int tamanho = Integer.parseInt(spnTamanhoProduto.getValue().toString());
            
            if(jLabel1.getText().equals("Id Tam.:"))
            {
                int idTamanho = Integer.parseInt(txtIdProdutoAdicionado.getText());
                ProdutoTamanho produtoTamanho = new ProdutoTamanho(idTamanho, 0, tamanho, qtd);
                
                boolean retorno = ProdutoTamanhoDAO.alterar(produtoTamanho);

                if(retorno)
                    JOptionPane.showMessageDialog(rootPane, "Tamanho alterado com sucesso");
               else
                    JOptionPane.showMessageDialog(rootPane, "Falha ao alterar tamanho");
            }
            else{
                
                int fkProduto = Integer.parseInt(txtIdProdutoAdicionado.getText());
            
                ProdutoTamanho produtoTamanho = new ProdutoTamanho(fkProduto, tamanho, qtd);

                boolean retorno = ProdutoTamanhoDAO.adicionar(produtoTamanho);

                if(retorno)
                    JOptionPane.showMessageDialog(rootPane, "Tamanho adicionado com sucesso");
                else
                    JOptionPane.showMessageDialog(rootPane, "Falha ao adicionar tamanho");
            }

        } 
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            //objValidar.setBackground(Color.yellow);
        }
    }//GEN-LAST:event_btnAdicionarProdutoTamanhoActionPerformed
    
    public void setItensAlterar(ProdutoTamanho produtoTamanho)
    {
        txtIdProdutoAdicionado.setText(String.valueOf(produtoTamanho.getId()));
        spnQtdProdutoTamanho.setValue(produtoTamanho.getQuantidade());
        spnTamanhoProduto.setValue(produtoTamanho.getTamanho());
        jLabel1.setText("Id Tam.:");
    }
    
    public void setCodigoProdutoAdicionado(String valor) {
        txtIdProdutoAdicionado.setText(valor);
    }
        
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
            java.util.logging.Logger.getLogger(TelaProdutoTamanho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProdutoTamanho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProdutoTamanho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProdutoTamanho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProdutoTamanho().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarProdutoTamanho;
    private javax.swing.JButton btnCancelarProdutoTamanho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner spnQtdProdutoTamanho;
    private javax.swing.JSpinner spnTamanhoProduto;
    private javax.swing.JTextField txtIdProdutoAdicionado;
    // End of variables declaration//GEN-END:variables
}

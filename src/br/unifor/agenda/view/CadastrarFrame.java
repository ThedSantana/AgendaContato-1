/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unifor.agenda.view;
import java.sql.*;
import br.unifor.agenda.dao.ConectaDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Maikon Albuquerque
 */
public class CadastrarFrame extends javax.swing.JFrame {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form CadastrarFrame
     */
    public CadastrarFrame() {
        initComponents();
        conexao = ConectaDAO.conector();
        //status da conexão
        //System.out.println(conexao);
        if (conexao != null){
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unifor/agenda/view/images/accept-database-icon.png")));
        }else{
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unifor/agenda/view/images/remove-from-database-icon.png")));
        }    
    }
    
    private void novoContato(){
        idField.setText(null);
        nomeField.setText(null);
        enderecoField.setText(null);
        bairroField.setText(null);
        cidadeField.setText(null);
        ufField.setText(null);
        telefoneField.setText(null);
    }
    
    private void consultar(){
        String sql = "select * from contato where id=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, idField.getText());
            rs=pst.executeQuery();
            
            if (rs.next()) {
                nomeField.setText(rs.getString(1));
                enderecoField.setText(rs.getString(2));
                bairroField.setText(rs.getString(3));
                cidadeField.setText(rs.getString(4));
                ufField.setText(rs.getString(5));
                telefoneField.setText(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null,"Usuário não cadastrado!");
                // Linha para limpara fields
                nomeField.setText(null);
                enderecoField.setText(null);
                bairroField.setText(null);
                cidadeField.setText(null);
                ufField.setText(null);
                telefoneField.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void adicionar(){
        String sql = "INSERT INTO contato (nome, endereco, bairro, cidade, uf, telefone, id)" + "values (?, ?, ?, ?, ?, ?, ?)";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(7, idField.getText());
            pst.setString(1, nomeField.getText());
            pst.setString(2, enderecoField.getText());
            pst.setString(3, bairroField.getText());
            pst.setString(4, cidadeField.getText());
            pst.setString(5, ufField.getText());
            pst.setString(6, telefoneField.getText());
            
            // atualizar tabela contatos com os dados do formulário
            
            int adicionado = pst.executeUpdate();
            if (adicionado > 0){
                JOptionPane.showMessageDialog(null,"Contato cadastrado com sucesso!");
                idField.setText(null);
                nomeField.setText(null);
                enderecoField.setText(null);
                bairroField.setText(null);
                cidadeField.setText(null);
                ufField.setText(null);
                telefoneField.setText(null);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void atualizar(){
        
        String sql = "UPDATE contato SET nome=?, endereco=?, bairro=?, cidade=?, uf=?, telefone=? WHERE id=?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, nomeField.getText());
            pst.setString(2, enderecoField.getText());
            pst.setString(3, bairroField.getText());
            pst.setString(4, cidadeField.getText());
            pst.setString(5, ufField.getText());
            pst.setString(6, telefoneField.getText());
            pst.setString(7, idField.getText());
            
            int adicionado = pst.executeUpdate();
            
            if (adicionado > 0){
                JOptionPane.showMessageDialog(null,"Contato atualizado com sucesso!");
                idField.setText(null);
                nomeField.setText(null);
                enderecoField.setText(null);
                bairroField.setText(null);
                cidadeField.setText(null);
                ufField.setText(null);
                telefoneField.setText(null);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
    }
    
    private void deletar(){
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o usuário?", "Atenção", JOptionPane.YES_NO_OPTION);
        
        if (confirma == JOptionPane.YES_OPTION){
            String sql = "DELETE FROM contato WHERE id=?";
            
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1,idField.getText());
                
                int deletado = pst.executeUpdate();
                
                if (deletado > 0){
                    JOptionPane.showMessageDialog(null,"Contato excluído com sucesso!");
                    idField.setText(null);
                    nomeField.setText(null);
                    enderecoField.setText(null);
                    bairroField.setText(null);
                    cidadeField.setText(null);
                    ufField.setText(null);
                    telefoneField.setText(null);
                }
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JLabel();
        enderecoField = new javax.swing.JTextField();
        txtEmail = new javax.swing.JLabel();
        cidadeField = new javax.swing.JTextField();
        bairroField = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JLabel();
        ufField = new javax.swing.JTextField();
        telefoneField = new javax.swing.JTextField();
        txtCidade = new javax.swing.JLabel();
        txtUf = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda de Contatos");
        setName(""); // NOI18N
        setResizable(false);

        txtNome.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        txtNome.setText("Nome");

        enderecoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enderecoFieldActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        txtEmail.setText("Bairro");

        txtTelefone.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        txtTelefone.setText("Endereço");

        txtEndereco.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        txtEndereco.setText("Cidade");

        txtCidade.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        txtCidade.setText("Telefone");

        txtUf.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        txtUf.setText("UF");

        nomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFieldActionPerformed(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAtualizar.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unifor/agenda/view/images/accept-database-icon.png"))); // NOI18N

        txtId.setText("ID");

        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(txtId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUf, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCidade, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblStatus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cidadeField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bairroField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enderecoField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telefoneField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ufField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtId)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enderecoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bairroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidadeField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ufField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUf))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnNovo))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblStatus)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Agenda de Contatos");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void enderecoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enderecoFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_enderecoFieldActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        consultar();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void nomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFieldActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        atualizar();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        deletar();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        novoContato();
    }//GEN-LAST:event_btnNovoActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bairroField;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JTextField cidadeField;
    private javax.swing.JTextField enderecoField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField nomeField;
    private javax.swing.JTextField telefoneField;
    private javax.swing.JLabel txtCidade;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtEndereco;
    private javax.swing.JLabel txtId;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtTelefone;
    private javax.swing.JLabel txtUf;
    private javax.swing.JTextField ufField;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import facade.FacadeProduct;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class ProductSearch extends InternalFrameHelper {

    protected FacadeProduct facadeProduct;
    protected DefaultTableModel defaultTableModel;

    /**
     * Creates new form TableSearch
     */
    public ProductSearch() {
        facadeProduct = new FacadeProduct();
        initComponents();
        loadTable();

        setClosable(true);
    }

    public void loadTable() {
        cleanTable();
        defaultTableModel = (DefaultTableModel) tablePane.getModel();

        for (entity.Product p : facadeProduct.listAll()) {
            defaultTableModel.addRow(new Object[]{p.getCode(), p.getName(), p.getPrice()});
        }
    }

    private void cleanTable() {
        defaultTableModel = (DefaultTableModel) tablePane.getModel();
        int rowCount = defaultTableModel.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            defaultTableModel.removeRow(i);
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

      jLabel3 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      tablePane = new javax.swing.JTable();
      editButton = new javax.swing.JButton();
      removeButton = new javax.swing.JButton();
      jLabel4 = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      searchCode = new javax.swing.JTextField();
      searchButton = new javax.swing.JButton();
      waiterAdd = new javax.swing.JButton();

      jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
      jLabel3.setText("Cadastro de Mesa");

      tablePane.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "Código", "Nome", "Preço"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
         };
         boolean[] canEdit = new boolean [] {
            false, false, false
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      jScrollPane1.setViewportView(tablePane);

      editButton.setText("Editar");
      editButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            editButtonActionPerformed(evt);
         }
      });

      removeButton.setText("Remover");
      removeButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            removeButtonActionPerformed(evt);
         }
      });

      jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
      jLabel4.setText("Pesquisa de Produtos");

      jLabel1.setText("Código do produto");

      searchButton.setText("Pesquisar");
      searchButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            searchButtonActionPerformed(evt);
         }
      });

      waiterAdd.setText("Adicionar Produto");
      waiterAdd.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            waiterAddActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(editButton)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(removeButton))
               .addComponent(jScrollPane1)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(searchCode, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel1))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(searchButton))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel4)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(waiterAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(waiterAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(searchCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(searchButton))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(editButton)
               .addComponent(removeButton))
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
       if (!this.searchCode.getText().isEmpty()) {
           cleanTable();
           defaultTableModel = (DefaultTableModel) tablePane.getModel();
           
           int code = Integer.parseInt(searchCode.getText());

           entity.Product p = facadeProduct.listByCode(code);

           if (p instanceof entity.Product) {
               defaultTableModel.addRow(new Object[]{p.getCode(), p.getName(), p.getPrice()});
           } else {
               message("Não foi encontrado nenhum produto com o código: " + code, "Produto não encontrado", JOptionPane.OK_OPTION);
           }
       } else {
           message("Você deve informar o código do produto para buscar", "Busca vazia", JOptionPane.OK_OPTION);
       }
   }//GEN-LAST:event_searchButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int line = tablePane.getSelectedRow();
        
        if (line >= 0) {
            Object lineId = tablePane.getValueAt(line, 0);
            
            ProductNew pn = new ProductNew(lineId.hashCode());
            JDesktopPane desktopPane = getDesktopPane();
            desktopPane.add(pn);

            pn.setVisible(true);
            this.setVisible(false);
        } else {
            message("Você deve selecionar uma linha para editar.", "Atenção", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void waiterAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waiterAddActionPerformed
        ProductNew pn = new ProductNew(0);
        JDesktopPane desktopPane = getDesktopPane();
        desktopPane.add(pn);
        
        pn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_waiterAddActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int line = tablePane.getSelectedRow();
        
        if (line >= 0) {
            Object lineId = tablePane.getValueAt(line, 0);

            if (JOptionPane.showConfirmDialog(null, "Você tem certeza?", "ATENÇÃO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                entity.Product p = facadeProduct.listByCode(line);

                if (p instanceof entity.Product) {
                    facadeProduct.delete(line);
                    
                    loadTable();
                } else {
                    message("Não foi encontrado o produto escolhido. Certifique-se que você selecionou a linha.", "Produto não encontrado", JOptionPane.OK_OPTION);
                }
            }
        } else {
            message("Você deve selecionar uma linha para remover.", "Atenção", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton editButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JButton removeButton;
   private javax.swing.JButton searchButton;
   private javax.swing.JTextField searchCode;
   private javax.swing.JTable tablePane;
   private javax.swing.JButton waiterAdd;
   // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Product;
import facade.FacadeOrdersProduct;
import facade.FacadeProduct;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class OrderAddProduct extends InternalFrameHelper {

   protected FacadeProduct facadeProduct;
   protected FacadeOrdersProduct facadeOrdersProduct;
   protected DefaultTableModel defaultTableModel;
   protected int orderId;

   /**
    * Creates new form OrderAddProduct
    */
   public OrderAddProduct(int orderId) {
      facadeProduct = new FacadeProduct();
      facadeOrdersProduct = new FacadeOrdersProduct();
      
      if (orderId != 0) {
         this.orderId = orderId;
         
         System.out.println(orderId);
      } else {
         message("Informação inválida.", "Error", JOptionPane.ERROR_MESSAGE);
         
         OrderIndex o = new OrderIndex();
         JDesktopPane desktopPane = getDesktopPane();
         desktopPane.add(o);

         o.setVisible(true);
         this.setVisible(false);
      }
      
      initComponents();
      populate();
   }

   private void populate() {
      cleanTable();
      
      List<Product> p = facadeProduct.listAll();
      defaultTableModel = (DefaultTableModel) productTablePane.getModel();

      for (Product product : p) {
         defaultTableModel.addRow(new Object[]{product.getCode(), product.getName(), product.getPrice()});
      }
   }

   private void cleanTable() {
      defaultTableModel = (DefaultTableModel) productTablePane.getModel();
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

      jLabel1 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      productTablePane = new javax.swing.JTable();
      addButton = new javax.swing.JButton();
      backButton = new javax.swing.JButton();

      jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
      jLabel1.setText("Adicionando produtos");

      productTablePane.setModel(new javax.swing.table.DefaultTableModel(
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
      jScrollPane1.setViewportView(productTablePane);

      addButton.setText("Adicionar produtos selecionados");
      addButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            addButtonActionPerformed(evt);
         }
      });

      backButton.setText("Voltar");
      backButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            backButtonActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel1)
                  .addGap(0, 0, Short.MAX_VALUE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(backButton)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(addButton)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(addButton)
               .addComponent(backButton))
            .addContainerGap(25, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
      OrderList o = new OrderList(this.orderId);
      JDesktopPane desktopPane = getDesktopPane();
      desktopPane.add(o);

      o.setVisible(true);
      this.setVisible(false);
   }//GEN-LAST:event_backButtonActionPerformed

   private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
      int[] productCode = productTablePane.getSelectedRows();
      
      for (int i = 0; i < productCode.length; i++) {
         Object lineId = productTablePane.getValueAt(productCode[i], 0);
         
         facadeOrdersProduct.insert(this.orderId, lineId.hashCode());
      }
      
      message("Produtos adicionados com sucesso!", "Sucesso!", JOptionPane.OK_OPTION);
      
      backButtonActionPerformed(evt);
   }//GEN-LAST:event_addButtonActionPerformed


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton addButton;
   private javax.swing.JButton backButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable productTablePane;
   // End of variables declaration//GEN-END:variables
}
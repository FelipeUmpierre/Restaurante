/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Orders;
import facade.FacadeOrders;
import facade.FacadeOrdersProduct;
import facade.FacadeProduct;
import facade.FacadeTable;
import facade.FacadeWaiter;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class OrderNew extends InternalFrameHelper {

   protected FacadeWaiter facadeWaiter;
   protected FacadeTable facadeTable;
   protected FacadeProduct facadeProduct;
   protected FacadeOrders facadeOrders;
   protected FacadeOrdersProduct facadeOrdersProduct;
   protected DefaultTableModel defaultTableModel;

   /**
    * Creates new form Order
    */
   public OrderNew() {
      facadeWaiter = new FacadeWaiter();
      facadeTable = new FacadeTable();
      facadeProduct = new FacadeProduct();
      facadeOrders = new FacadeOrders();
      facadeOrdersProduct = new FacadeOrdersProduct();

      initComponents();
      populateComboboxes();
   }

   public void populateComboboxes() {
      for (entity.Waiter w : facadeWaiter.listAll()) {
         waiterComboBox.addItem(w.getCpf() + " - " + w.getName());
      }

      for (entity.Table t : facadeTable.listAll()) {
         tableComboBox.addItem(t.getNumber() + " - " + t.getCapacity() + " pessoa(s)");
      }

      defaultTableModel = (DefaultTableModel) productPane.getModel();

      for (entity.Product p : facadeProduct.listAll()) {
         defaultTableModel.addRow(new Object[]{p.getCode(), p.getName(), p.getPrice()});
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

      waiterComboBox = new javax.swing.JComboBox();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      tableComboBox = new javax.swing.JComboBox();
      jLabel4 = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      productPane = new javax.swing.JTable();
      addOrder = new javax.swing.JButton();
      backButton = new javax.swing.JButton();

      waiterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Escolha um garçom"}));
      waiterComboBox.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            waiterComboBoxActionPerformed(evt);
         }
      });

      jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
      jLabel1.setText("Novo Pedido");

      jLabel2.setText("Garçom");

      jLabel3.setText("Mesa");

      tableComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Escolha uma mesa"}));
      tableComboBox.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            tableComboBoxActionPerformed(evt);
         }
      });

      jLabel4.setText("Produtos");

      productPane.setModel(new javax.swing.table.DefaultTableModel(
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
      jScrollPane1.setViewportView(productPane);

      addOrder.setText("Adicionar Pedido a mesa");
      addOrder.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            addOrderActionPerformed(evt);
         }
      });

      backButton.setText("Cancelar");
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
               .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(backButton)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(addOrder))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel4)
                  .addGap(0, 486, Short.MAX_VALUE))
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel3)
                     .addComponent(tableComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                     .addComponent(waiterComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
               .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(jLabel3)
                  .addGap(4, 4, 4)
                  .addComponent(tableComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(jLabel2)
                  .addGap(4, 4, 4)
                  .addComponent(waiterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(addOrder)
               .addComponent(backButton))
            .addContainerGap(20, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void tableComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableComboBoxActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_tableComboBoxActionPerformed

   private void waiterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waiterComboBoxActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_waiterComboBoxActionPerformed

   private void addOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrderActionPerformed
      String[] tableNumber = tableComboBox.getSelectedItem().toString().split(" - ");
      String[] waiterCpf = waiterComboBox.getSelectedItem().toString().split(" - ");
      int[] productCode = productPane.getSelectedRows();

      Orders o = facadeOrders.listByTableId(Integer.parseInt(tableNumber[0]));

      if ((o instanceof Orders)) {
         entity.Table table = facadeTable.listById(o.getTableId());

         if (table instanceof entity.Table) {
            message("Esta mesa já possui um pedido aberto.", "Pedido já aberto.", JOptionPane.OK_OPTION);

            OrderList ol = new OrderList(o.getId());
            JDesktopPane desktopPane = getDesktopPane();
            desktopPane.add(ol);

            ol.setVisible(true);
            this.setVisible(false);
         } else {
            insert(tableNumber, waiterCpf, productCode, evt);
         }
      } else {
         insert(tableNumber, waiterCpf, productCode, evt);
      }
   }//GEN-LAST:event_addOrderActionPerformed

   private void insert(String[] tableNumber, String[] waiterCpf, int[] productCode, java.awt.event.ActionEvent evt) {
      entity.Table t = facadeTable.listByNumber(Integer.parseInt(tableNumber[0]));
      entity.Waiter w = facadeWaiter.listByCpf(waiterCpf[0]);
      int ordersId = facadeOrders.insert(t.getId(), w.getId());

      for (int i = 0; i < productCode.length; i++) {
         Object lineId = productPane.getValueAt(productCode[i], 0);

         facadeOrdersProduct.insert(ordersId, lineId.hashCode());
      }

      facadeTable.update(Integer.parseInt(tableNumber[0]), t.getCapacity(), 1);

      message("Pedido adicionado com sucesso!", "Sucesso!", JOptionPane.OK_OPTION);

      backButtonActionPerformed(evt);
   }

   private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
      OrderIndex o = new OrderIndex();
      JDesktopPane desktopPane = getDesktopPane();
      desktopPane.add(o);

      o.setVisible(true);
      this.setVisible(false);
   }//GEN-LAST:event_backButtonActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton addOrder;
   private javax.swing.JButton backButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable productPane;
   private javax.swing.JComboBox tableComboBox;
   private javax.swing.JComboBox waiterComboBox;
   // End of variables declaration//GEN-END:variables
}

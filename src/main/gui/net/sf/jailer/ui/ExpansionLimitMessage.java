/*
 * Copyright 2007 - 2022 Ralf Wisser.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.jailer.ui;

/**
 * Expansion Limit Message.
 * 
 * @author Ralf Wisser
 */
public abstract class ExpansionLimitMessage extends javax.swing.JPanel {

    /**
     * Creates new form ExpansionLimitMessage
     */
    public ExpansionLimitMessage(int limit, int numAllTables) {
        initComponents();
        if (limit >= numAllTables) {
        	limit = numAllTables;
        }
        showMoreButton.setText(showMoreButton.getText().replace("?", "" + limit));
        showAllButton.setText(showAllButton.getText().replace("?", "" + numAllTables));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        showMoreButton = new javax.swing.JButton();
        showAllButton = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jailer/ui/resource/wanr.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Expansion limit reached");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(jLabel2, gridBagConstraints);

        showMoreButton.setText("Show ? tables more");
        showMoreButton.setOpaque(false);
        showMoreButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMoreButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 0);
        add(showMoreButton, gridBagConstraints);

        showAllButton.setText("Show all ? tables");
        showAllButton.setOpaque(false);
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 0, 0);
        add(showAllButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void showMoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMoreButtonActionPerformed
        showMore();
    }//GEN-LAST:event_showMoreButtonActionPerformed

    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        showAll();
    }//GEN-LAST:event_showAllButtonActionPerformed

    protected abstract void showMore();

    protected abstract void showAll();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton showAllButton;
    private javax.swing.JButton showMoreButton;
    // End of variables declaration//GEN-END:variables
}

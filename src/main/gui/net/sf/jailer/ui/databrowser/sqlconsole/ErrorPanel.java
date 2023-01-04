/*
 * Copyright 2007 - 2023 Ralf Wisser.
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
package net.sf.jailer.ui.databrowser.sqlconsole;

import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

/**
 * SQL-Console error view.
 *
 * @author Ralf Wisser
 */
public class ErrorPanel extends javax.swing.JPanel {

    /**
     * Creates new form ErrorPanel.
     * 
     * @param errorMessage the error message
     * @param statement the statement
     * @param errorPosition error position
     */
    public ErrorPanel(String errorMessage, String statement, int errorPosition) {
        initComponents();
        errorTextArea.setText(errorMessage);
        errorTextArea.setCaretPosition(0);
        iconLabel.setText(null);
		try {
			Icon errorIcon = UIManager.getIcon("OptionPane.errorIcon");
			iconLabel.setIcon(errorIcon);
		} catch (Throwable t) {
			// ignore
		}
		sqlEditorPane = new RSyntaxTextArea();
		sqlEditorPane.setBracketMatchingEnabled(false);

		sqlEditorPane.setFadeCurrentLineHighlight(true);
		sqlEditorPane.setEditable(false);
		sqlEditorPane.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_SQL);
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setViewportView(sqlEditorPane);
		statementPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);
		if (statement != null) {
			sqlEditorPane.setText(statement.trim());
		}
		try {
			int l = sqlEditorPane.getLineOfOffset(errorPosition);
			sqlEditorPane.setCaretPosition(errorPosition);
			int lineHeight = sqlEditorPane.getLineHeight();
			sqlEditorPane.scrollRectToVisible(new Rectangle(0, Math.max(0, l - 2) * lineHeight, 1, 4 * lineHeight));
		} catch (Exception e) {
			// ignore
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
        java.awt.GridBagConstraints gridBagConstraints;

        iconLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        errorTextArea = new javax.swing.JTextArea();
        statementPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        iconLabel.setText("erroricon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 2);
        add(iconLabel, gridBagConstraints);

        errorTextArea.setEditable(false);
        errorTextArea.setBackground(new java.awt.Color(254, 255, 255));
        errorTextArea.setForeground(java.awt.Color.red);
        jScrollPane1.setViewportView(errorTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane1, gridBagConstraints);

        statementPanel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(statementPanel, gridBagConstraints);

        jLabel1.setText("Statement");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        add(jLabel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea errorTextArea;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel statementPanel;
    // End of variables declaration//GEN-END:variables
    private final RSyntaxTextArea sqlEditorPane;

	public void doDisable() {
		iconLabel.setEnabled(false);
		statementPanel.setEnabled(false);
		errorTextArea.setEnabled(false);
		sqlEditorPane.setText("");
		jLabel1.setEnabled(false);
	}
}

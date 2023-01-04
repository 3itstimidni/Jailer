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
package net.sf.jailer.ui;

import java.awt.Point;
import java.awt.Window;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.Icon;
import javax.swing.UIManager;

/**
 * Startup Wizzard.
 * 
 * @author Ralf Wisser
 */
public abstract class StartupWizzardDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = -6737420167295938488L;
	
	/** Creates new form SqlErrorDialog 
	*/
	public StartupWizzardDialog(Window parent, boolean withLoad, Point pos) {
		super(parent, ModalityType.MODELESS);
		setUndecorated(true);
		initComponents();
		try {
			iconLabel.setText(null);
			Icon errorIcon = UIManager.getIcon("OptionPane.questionIcon");
			iconLabel.setIcon(errorIcon);
		} catch (Throwable t) {
			// ignore
		}
		
		addWindowFocusListener(new WindowFocusListener() {
			@Override
			public void windowLostFocus(WindowEvent e) {
				setVisible(false);
			}
			@Override
			public void windowGainedFocus(WindowEvent e) {
			}
		});
		addComponentListener(new ComponentListener() {
			@Override
			public void componentShown(ComponentEvent e) {
			}
			@Override
			public void componentResized(ComponentEvent e) {
			}
			@Override
			public void componentMoved(ComponentEvent e) {
			}
			@Override
			public void componentHidden(ComponentEvent e) {
				onClose();
			}
		});

		KeyListener keyListener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
					newModelButtonActionPerformed(null);
				}
				if (e.getKeyChar() == '\n') {
					if (e.getComponent() == newModelButton) {
						newModelButtonActionPerformed(null);
					}
					if (e.getComponent() == newModelWRjButton) {
						newModelWRjButtonActionPerformed(null);
					}
					if (e.getComponent() == loadButton) {
						loadButtonActionPerformed(null);
					}
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		};
		newModelButton.addKeyListener(keyListener);
		newModelWRjButton.addKeyListener(keyListener);
		loadButton.addKeyListener(keyListener);
		loadButton.setVisible(withLoad);
		
		pack();
		if (pos != null) {
			setLocation(new Point(pos.x - getWidth() / 2, pos.y - getHeight() / 2));
		} else if (parent == null) {
			setLocation(200, 100);
		} else {
			setLocation(getParent().getX() + (getParent().getWidth() - getWidth()) / 2, getParent().getY() + (getParent().getHeight() - getHeight()) / 2);
		}
		UIUtil.fit(this);
		UIUtil.invokeLater(() -> StartupWizzardDialog.this.requestFocus());
		setVisible(true);
	}

	public boolean loadModel = false;
	public boolean newModelWithRestrictions = false;
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        messagePanel = new javax.swing.JPanel();
        newModelButton = new javax.swing.JButton();
        newModelWRjButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        iconLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create or Load Model");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridBagLayout());

        messagePanel.setLayout(new java.awt.GridBagLayout());

        newModelButton.setText("New Model");
        newModelButton.setToolTipText("New Model without Restrictions");
        newModelButton.setMargin(new java.awt.Insets(4, 10, 4, 10));
        newModelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newModelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        messagePanel.add(newModelButton, gridBagConstraints);

        newModelWRjButton.setText("  New Model with Restrictions  ");
        newModelWRjButton.setToolTipText("New Model with disabled non-dependencies");
        newModelWRjButton.setMargin(new java.awt.Insets(4, 10, 4, 10));
        newModelWRjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newModelWRjButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        messagePanel.add(newModelWRjButton, gridBagConstraints);

        loadButton.setText("Load Model");
        loadButton.setMargin(new java.awt.Insets(4, 10, 4, 10));
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        messagePanel.add(loadButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 8);
        jPanel1.add(messagePanel, gridBagConstraints);

        iconLabel.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        jPanel1.add(iconLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void newModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newModelButtonActionPerformed
		setVisible(false);
	}//GEN-LAST:event_newModelButtonActionPerformed

	private void newModelWRjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newModelWRjButtonActionPerformed
		newModelWithRestrictions = true;
		setVisible(false);
	}//GEN-LAST:event_newModelWRjButtonActionPerformed

	private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
		loadModel = true;
		setVisible(false);
	}//GEN-LAST:event_loadButtonActionPerformed

	protected abstract void onClose();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loadButton;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JButton newModelButton;
    private javax.swing.JButton newModelWRjButton;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emreozgenc.eoeditor.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;
import com.emreozgenc.eoeditor.EOEditor;
import com.emreozgenc.eoeditor.interfaces.IEOEditorLauncher;
import javax.swing.SwingUtilities;

/**
 *
 * @author emreo
 */
public class DesktopLauncher extends javax.swing.JFrame implements IEOEditorLauncher {

    private LwjglAWTCanvas canvas;
    public EOEditor editor;

    public DesktopLauncher() {
        editor = new EOEditor();
        editor.setLauncher(this);
        canvas = new LwjglAWTCanvas(editor);
        canvas.getCanvas().setSize(800, 600);

        initComponents();
        canvasPanel.add(canvas.getCanvas());
        setResizable(false);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        canvasPanel = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        cameraOptionsPanel = new javax.swing.JPanel();
        cameraPosXLabel = new javax.swing.JLabel();
        cameraPosXField = new javax.swing.JTextField();
        cameraPosYLabel = new javax.swing.JLabel();
        cameraPosYField = new javax.swing.JTextField();
        cameraPositionSetButton = new javax.swing.JButton();
        cameraPositionResetButton = new javax.swing.JButton();
        screenSizeLabel = new javax.swing.JLabel();
        cameraZoomLabel = new javax.swing.JLabel();
        cameraZoomField = new javax.swing.JTextField();
        cameraZoomSetButton = new javax.swing.JButton();
        cameraZoomResetButton = new javax.swing.JButton();
        objectOptionsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(0, 48, 73));

        javax.swing.GroupLayout canvasPanelLayout = new javax.swing.GroupLayout(canvasPanel);
        canvasPanel.setLayout(canvasPanelLayout);
        canvasPanelLayout.setHorizontalGroup(
            canvasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        canvasPanelLayout.setVerticalGroup(
            canvasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tabbedPane.setBackground(new java.awt.Color(0, 255, 255));

        cameraOptionsPanel.setBackground(new java.awt.Color(234, 226, 183));

        cameraPosXLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cameraPosXLabel.setText("Camera Position X :");

        cameraPosXField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cameraPosXField.setText("0.0");
        cameraPosXField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cameraPosXFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cameraPosXFieldFocusLost(evt);
            }
        });

        cameraPosYLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cameraPosYLabel.setText("Camera Position Y :");

        cameraPosYField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cameraPosYField.setText("0.0");
        cameraPosYField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cameraPosYFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cameraPosYFieldFocusLost(evt);
            }
        });

        cameraPositionSetButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cameraPositionSetButton.setText("Set Camera Position");
        cameraPositionSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cameraPositionSetButtonActionPerformed(evt);
            }
        });

        cameraPositionResetButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cameraPositionResetButton.setText("Reset Camera Position");
        cameraPositionResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cameraPositionResetButtonActionPerformed(evt);
            }
        });

        screenSizeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screenSizeLabel.setText("Screen Size : 800x600 - 8 meter x 6 meter");

        cameraZoomLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cameraZoomLabel.setText("Camera Zoom :");

        cameraZoomField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cameraZoomField.setText("1");

        cameraZoomSetButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cameraZoomSetButton.setText("Set Camera Zoom");

        cameraZoomResetButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cameraZoomResetButton.setText("Reset Camera Zoom");

        javax.swing.GroupLayout cameraOptionsPanelLayout = new javax.swing.GroupLayout(cameraOptionsPanel);
        cameraOptionsPanel.setLayout(cameraOptionsPanelLayout);
        cameraOptionsPanelLayout.setHorizontalGroup(
            cameraOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cameraOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cameraOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cameraPosXLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cameraPosXField)
                    .addComponent(cameraPosYLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cameraPosYField)
                    .addComponent(cameraPositionSetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(screenSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(cameraPositionResetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cameraZoomLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cameraZoomField)
                    .addComponent(cameraZoomSetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cameraZoomResetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        cameraOptionsPanelLayout.setVerticalGroup(
            cameraOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cameraOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cameraPosXLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(cameraPosXField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cameraPosYLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cameraPosYField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cameraPositionSetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cameraPositionResetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(screenSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cameraZoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cameraZoomField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cameraZoomSetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cameraZoomResetButton)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Camera Settings", cameraOptionsPanel);

        objectOptionsPanel.setBackground(new java.awt.Color(234, 226, 183));

        javax.swing.GroupLayout objectOptionsPanelLayout = new javax.swing.GroupLayout(objectOptionsPanel);
        objectOptionsPanel.setLayout(objectOptionsPanelLayout);
        objectOptionsPanelLayout.setHorizontalGroup(
            objectOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );
        objectOptionsPanelLayout.setVerticalGroup(
            objectOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Object Settings", objectOptionsPanel);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(canvasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canvasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cameraPositionSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cameraPositionSetButtonActionPerformed
        String posXStr = cameraPosXField.getText();
        posXStr = posXStr.replace(',', '.');
        String posYStr = cameraPosYField.getText();
        posYStr = posYStr.replace(',', '.');
        
        float posX = Float.parseFloat(posXStr);
        float posY = Float.parseFloat(posYStr);

        editor.setCameraPosition(posX, posY);
    }//GEN-LAST:event_cameraPositionSetButtonActionPerformed

    private void cameraPosXFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cameraPosXFieldFocusGained
        editor.pauseCamTimer();
    }//GEN-LAST:event_cameraPosXFieldFocusGained

    private void cameraPosXFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cameraPosXFieldFocusLost
        editor.startCamTimer();
    }//GEN-LAST:event_cameraPosXFieldFocusLost

    private void cameraPosYFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cameraPosYFieldFocusGained
        editor.pauseCamTimer();
    }//GEN-LAST:event_cameraPosYFieldFocusGained

    private void cameraPosYFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cameraPosYFieldFocusLost
        editor.startCamTimer();
    }//GEN-LAST:event_cameraPosYFieldFocusLost

    private void cameraPositionResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cameraPositionResetButtonActionPerformed
        editor.resetCameraPosition();
    }//GEN-LAST:event_cameraPositionResetButtonActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DesktopLauncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesktopLauncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesktopLauncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesktopLauncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DesktopLauncher();
            }
        });
        
        System.console();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cameraOptionsPanel;
    private javax.swing.JTextField cameraPosXField;
    private javax.swing.JLabel cameraPosXLabel;
    private javax.swing.JTextField cameraPosYField;
    private javax.swing.JLabel cameraPosYLabel;
    private javax.swing.JButton cameraPositionResetButton;
    private javax.swing.JButton cameraPositionSetButton;
    private javax.swing.JTextField cameraZoomField;
    private javax.swing.JLabel cameraZoomLabel;
    private javax.swing.JButton cameraZoomResetButton;
    private javax.swing.JButton cameraZoomSetButton;
    private javax.swing.JPanel canvasPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel objectOptionsPanel;
    private javax.swing.JLabel screenSizeLabel;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void upgradeCamPositionFields(float posX, float posY) {
        cameraPosXField.setText(String.valueOf(posX));
        cameraPosYField.setText(String.valueOf(posY));
    }

}

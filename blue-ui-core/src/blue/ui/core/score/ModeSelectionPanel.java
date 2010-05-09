/*
 * ModeSelectionPanel.java
 *
 * Created on November 24, 2006, 2:11 PM
 */

package blue.ui.core.score;

/**
 * 
 * @author steven
 */
public class ModeSelectionPanel extends javax.swing.JPanel {

    boolean updating = false;

    /** Creates new form ModeSelectionPanel */
    public ModeSelectionPanel() {
        initComponents();
        modeScoreToggle.setSelected(true);

        ModeManager.getInstance().addModeListener(new ModeListener() {
            public void modeChanged(int mode) {
                updating = true;

                switch (mode) {
                    case ModeManager.MODE_SCORE:
                        modeScoreToggle.setSelected(true);
                        break;
                    case ModeManager.MODE_SINGLE_LINE:
                        modeSingleLineToggle.setSelected(true);
                        break;
                    case ModeManager.MODE_MULTI_LINE:
                        modeMultiLineToggle.setSelected(true);
                        break;
                }
                updating = false;
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // ">//GEN-BEGIN:initComponents
    private void initComponents() {
        modeButtonGroup = new javax.swing.ButtonGroup();
        modeScoreToggle = new javax.swing.JToggleButton();
        modeSingleLineToggle = new javax.swing.JToggleButton();
        modeMultiLineToggle = new javax.swing.JToggleButton();

        setLayout(new javax.swing.BoxLayout(this,
                javax.swing.BoxLayout.LINE_AXIS));

        modeButtonGroup.add(modeScoreToggle);
        modeScoreToggle.setText("Score");
        modeScoreToggle.setFocusPainted(false);
        modeScoreToggle.setFocusable(false);
        modeScoreToggle.setMargin(new java.awt.Insets(0, 3, 0, 3));
        modeScoreToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeScoreToggleActionPerformed(evt);
            }
        });

        add(modeScoreToggle);

        modeButtonGroup.add(modeSingleLineToggle);
        modeSingleLineToggle.setText("Single Line");
        modeSingleLineToggle.setFocusPainted(false);
        modeSingleLineToggle.setFocusable(false);
        modeSingleLineToggle.setMargin(new java.awt.Insets(0, 3, 0, 3));
        modeSingleLineToggle
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        modeSingleLineToggleActionPerformed(evt);
                    }
                });

        add(modeSingleLineToggle);

        modeButtonGroup.add(modeMultiLineToggle);
        modeMultiLineToggle.setText("Multi Line");
        modeMultiLineToggle.setFocusPainted(false);
        modeMultiLineToggle.setFocusable(false);
        modeMultiLineToggle.setMargin(new java.awt.Insets(0, 3, 0, 3));
        modeMultiLineToggle
                .addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        modeMultiLineToggleActionPerformed(evt);
                    }
                });

        add(modeMultiLineToggle);

    }// </editor-fold>//GEN-END:initComponents

    private void modeMultiLineToggleActionPerformed(
            java.awt.event.ActionEvent evt) {// GEN-FIRST:event_modeMultiLineToggleActionPerformed
        if (!updating) {
            ModeManager.getInstance().setMode(ModeManager.MODE_MULTI_LINE);
        }
    }// GEN-LAST:event_modeMultiLineToggleActionPerformed

    private void modeSingleLineToggleActionPerformed(
            java.awt.event.ActionEvent evt) {// GEN-FIRST:event_modeSingleLineToggleActionPerformed
        if (!updating) {
            ModeManager.getInstance().setMode(ModeManager.MODE_SINGLE_LINE);
        }
    }// GEN-LAST:event_modeSingleLineToggleActionPerformed

    private void modeScoreToggleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_modeScoreToggleActionPerformed
        if (!updating) {
            ModeManager.getInstance().setMode(ModeManager.MODE_SCORE);
        }
    }// GEN-LAST:event_modeScoreToggleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup modeButtonGroup;

    private javax.swing.JToggleButton modeMultiLineToggle;

    private javax.swing.JToggleButton modeScoreToggle;

    private javax.swing.JToggleButton modeSingleLineToggle;
    // End of variables declaration//GEN-END:variables

}

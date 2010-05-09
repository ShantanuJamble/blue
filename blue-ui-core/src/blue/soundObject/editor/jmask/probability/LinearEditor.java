/*
 * LinearEditor.java
 *
 * Created on April 20, 2008, 9:56 PM
 */

package blue.soundObject.editor.jmask.probability;

import blue.soundObject.editor.jmask.DurationSettable;
import blue.soundObject.jmask.probability.Linear;

/**
 *
 * @author  syi
 */
public class LinearEditor extends javax.swing.JPanel implements DurationSettable {
    private Linear linear = null;
    
    /** Creates new form LinearEditor */
    public LinearEditor(Linear linear) {
        initComponents();
        this.directionComboBox.setSelectedIndex(linear.getDirection());
        this.linear = linear;
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        directionComboBox = new javax.swing.JComboBox();

        jLabel1.setText("Direction");

        directionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Decreasing", "Increasing" }));
        directionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                directionComboBoxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(directionComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(directionComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void directionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_directionComboBoxActionPerformed
        if(this.linear != null) {
            this.linear.setDirection(directionComboBox.getSelectedIndex());
        }
}//GEN-LAST:event_directionComboBoxActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox directionComboBox;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public void setDuration(double duration) {
        //ignore
    }
    
}

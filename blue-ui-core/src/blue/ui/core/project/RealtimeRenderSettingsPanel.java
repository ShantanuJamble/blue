/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RealtimeRenderSettingsPanel.java
 *
 * Created on Feb 8, 2009, 8:36:42 PM
 */
package blue.ui.core.project;

import blue.ProjectProperties;
import blue.event.SimpleDocumentListener;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author steven
 */
public class RealtimeRenderSettingsPanel extends javax.swing.JPanel {

    private ProjectProperties projectProperties = null;

    /** Creates new form RealtimeRenderSettingsPanel */
    public RealtimeRenderSettingsPanel() {
        initComponents();

        srText.getDocument().addDocumentListener(new SimpleDocumentListener() {

            public void documentChanged(DocumentEvent e) {
                if (projectProperties != null) {
                    projectProperties.sampleRate = srText.getText();
                }
            }
        });

        ksmpsText.getDocument().addDocumentListener(
                new SimpleDocumentListener() {

                    public void documentChanged(DocumentEvent e) {
                        if (projectProperties != null) {
                            projectProperties.ksmps = ksmpsText.getText();
                        }
                    }
                });

        nchnlsText.getDocument().addDocumentListener(
                new SimpleDocumentListener() {

                    public void documentChanged(DocumentEvent e) {
                        if (projectProperties != null) {
                            projectProperties.channels = nchnlsText.getText();
                        }
                    }
                });

        advancedSettingsText.getDocument().addDocumentListener(
                new SimpleDocumentListener() {

                    public void documentChanged(DocumentEvent e) {
                        if (projectProperties != null) {
                            projectProperties.advancedSettings = advancedSettingsText.getText();
                        }
                    }
                });
    }

    public void setProjectProperties(ProjectProperties projectProperties) {
        this.projectProperties = null;

        if (projectProperties != null) {
            srText.setText(projectProperties.sampleRate);
            ksmpsText.setText(projectProperties.ksmps);
            nchnlsText.setText(projectProperties.channels);
            audioOutCBox.setSelected(projectProperties.useAudioOut);
            audioInCBox.setSelected(projectProperties.useAudioIn);
            midiInCBox.setSelected(projectProperties.useMidiIn);
            midiOutCBox.setSelected(projectProperties.useMidiOut);

            noteAmpCBox.setSelected(projectProperties.noteAmpsEnabled);
            outOfRangeCBox.setSelected(projectProperties.outOfRangeEnabled);
            warningsCBox.setSelected(projectProperties.warningsEnabled);
            benchmarkCBox.setSelected(projectProperties.benchmarkEnabled);

            advancedSettingsText.setText(projectProperties.advancedSettings);
            overrideCBox.setSelected(projectProperties.completeOverride);

            this.projectProperties = projectProperties;
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        audioInCBox = new javax.swing.JCheckBox();
        midiInCBox = new javax.swing.JCheckBox();
        midiOutCBox = new javax.swing.JCheckBox();
        noteAmpCBox = new javax.swing.JCheckBox();
        overrideCBox = new javax.swing.JCheckBox();
        benchmarkCBox = new javax.swing.JCheckBox();
        warningsCBox = new javax.swing.JCheckBox();
        outOfRangeCBox = new javax.swing.JCheckBox();
        audioOutCBox = new javax.swing.JCheckBox();
        ksmpsText = new javax.swing.JTextField();
        srText = new javax.swing.JTextField();
        nchnlsText = new javax.swing.JTextField();
        advancedSettingsText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel4.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.jLabel4.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.jLabel3.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.jLabel2.text")); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.jLabel1.text")); // NOI18N

        jLabel9.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.jLabel9.text")); // NOI18N

        jLabel14.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.jLabel14.text")); // NOI18N

        audioInCBox.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.audioInCBox.text")); // NOI18N
        audioInCBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        audioInCBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        audioInCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                audioInCBoxActionPerformed(evt);
            }
        });

        midiInCBox.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.midiInCBox.text")); // NOI18N
        midiInCBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        midiInCBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        midiInCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midiInCBoxActionPerformed(evt);
            }
        });

        midiOutCBox.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.midiOutCBox.text")); // NOI18N
        midiOutCBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        midiOutCBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        midiOutCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midiOutCBoxActionPerformed(evt);
            }
        });

        noteAmpCBox.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.noteAmpCBox.text")); // NOI18N
        noteAmpCBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        noteAmpCBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        noteAmpCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteAmpCBoxActionPerformed(evt);
            }
        });

        overrideCBox.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.overrideCBox.text")); // NOI18N
        overrideCBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        overrideCBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        overrideCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overrideCBoxActionPerformed(evt);
            }
        });

        benchmarkCBox.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.benchmarkCBox.text")); // NOI18N
        benchmarkCBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        benchmarkCBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        benchmarkCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benchmarkCBoxActionPerformed(evt);
            }
        });

        warningsCBox.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.warningsCBox.text")); // NOI18N
        warningsCBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        warningsCBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        warningsCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warningsCBoxActionPerformed(evt);
            }
        });

        outOfRangeCBox.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.outOfRangeCBox.text")); // NOI18N
        outOfRangeCBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        outOfRangeCBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        outOfRangeCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outOfRangeCBoxActionPerformed(evt);
            }
        });

        audioOutCBox.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.audioOutCBox.text")); // NOI18N
        audioOutCBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        audioOutCBox.setMargin(new java.awt.Insets(0, 0, 0, 0));
        audioOutCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                audioOutCBoxActionPerformed(evt);
            }
        });

        jButton1.setText(org.openide.util.NbBundle.getMessage(RealtimeRenderSettingsPanel.class, "RealtimeRenderSettingsPanel.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1openAdvancedFlags(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jLabel3)
                        .add(jLabel2)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(94, 94, 94)))
                    .add(jLabel9)
                    .add(jLabel14)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(midiOutCBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(176, 176, 176))
                    .add(layout.createSequentialGroup()
                        .add(overrideCBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 134, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(148, 148, 148))
                    .add(layout.createSequentialGroup()
                        .add(advancedSettingsText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton1))
                    .add(layout.createSequentialGroup()
                        .add(benchmarkCBox)
                        .add(151, 151, 151))
                    .add(layout.createSequentialGroup()
                        .add(warningsCBox)
                        .add(217, 217, 217))
                    .add(layout.createSequentialGroup()
                        .add(outOfRangeCBox)
                        .add(145, 145, 145))
                    .add(layout.createSequentialGroup()
                        .add(noteAmpCBox)
                        .add(185, 185, 185))
                    .add(layout.createSequentialGroup()
                        .add(midiInCBox)
                        .add(220, 220, 220))
                    .add(layout.createSequentialGroup()
                        .add(audioInCBox)
                        .add(216, 216, 216))
                    .add(layout.createSequentialGroup()
                        .add(audioOutCBox)
                        .add(208, 208, 208))
                    .add(nchnlsText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .add(ksmpsText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .add(srText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(srText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(ksmpsText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(nchnlsText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(audioOutCBox))
                .add(7, 7, 7)
                .add(audioInCBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(midiInCBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(midiOutCBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel14)
                    .add(noteAmpCBox))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(outOfRangeCBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(warningsCBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(benchmarkCBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jButton1)
                    .add(advancedSettingsText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(overrideCBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void audioInCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_audioInCBoxActionPerformed
        if (projectProperties != null) {
            projectProperties.useAudioIn = audioInCBox.isSelected();
        }
    }//GEN-LAST:event_audioInCBoxActionPerformed

    private void midiInCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midiInCBoxActionPerformed
        if (projectProperties != null) {
            projectProperties.useMidiIn = midiInCBox.isSelected();
        }
    }//GEN-LAST:event_midiInCBoxActionPerformed

    private void midiOutCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midiOutCBoxActionPerformed
        if (projectProperties != null) {
            projectProperties.useMidiOut = midiOutCBox.isSelected();
        }
    }//GEN-LAST:event_midiOutCBoxActionPerformed

    private void noteAmpCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteAmpCBoxActionPerformed
        if (projectProperties != null) {
            projectProperties.noteAmpsEnabled = noteAmpCBox.isSelected();
        }
    }//GEN-LAST:event_noteAmpCBoxActionPerformed

    private void overrideCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overrideCBoxActionPerformed
        if (projectProperties != null) {
            projectProperties.completeOverride = overrideCBox.isSelected();
        }
    }//GEN-LAST:event_overrideCBoxActionPerformed

    private void benchmarkCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_benchmarkCBoxActionPerformed
        if (projectProperties != null) {
            projectProperties.benchmarkEnabled = benchmarkCBox.isSelected();
        }
    }//GEN-LAST:event_benchmarkCBoxActionPerformed

    private void warningsCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warningsCBoxActionPerformed
        if (projectProperties != null) {
            projectProperties.warningsEnabled = warningsCBox.isSelected();
        }
    }//GEN-LAST:event_warningsCBoxActionPerformed

    private void outOfRangeCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outOfRangeCBoxActionPerformed
        if (projectProperties != null) {
            projectProperties.outOfRangeEnabled = outOfRangeCBox.isSelected();
        }
    }//GEN-LAST:event_outOfRangeCBoxActionPerformed

    private void audioOutCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_audioOutCBoxActionPerformed
        if (projectProperties != null) {
            projectProperties.useAudioOut = audioOutCBox.isSelected();
        }
    }//GEN-LAST:event_audioOutCBoxActionPerformed

    private void jButton1openAdvancedFlags(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1openAdvancedFlags
        // TODO - implement method to get Program Options
        //         String url = ProgramOptions.getGeneralSettings().getCsoundDocRoot()
//            + "CommandFlags.html";
//         URLOpener.openURL(url);
    }//GEN-LAST:event_jButton1openAdvancedFlags
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField advancedSettingsText;
    private javax.swing.JCheckBox audioInCBox;
    private javax.swing.JCheckBox audioOutCBox;
    private javax.swing.JCheckBox benchmarkCBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField ksmpsText;
    private javax.swing.JCheckBox midiInCBox;
    private javax.swing.JCheckBox midiOutCBox;
    private javax.swing.JTextField nchnlsText;
    private javax.swing.JCheckBox noteAmpCBox;
    private javax.swing.JCheckBox outOfRangeCBox;
    private javax.swing.JCheckBox overrideCBox;
    private javax.swing.JTextField srText;
    private javax.swing.JCheckBox warningsCBox;
    // End of variables declaration//GEN-END:variables

}

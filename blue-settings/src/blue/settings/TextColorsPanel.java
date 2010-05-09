/*
 * blue - object composition environment for csound Copyright (c) 2000-2009
 * Steven Yi (stevenyi@gmail.com)
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; see the file COPYING.LIB. If not, write to the Free
 * Software Foundation Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307
 * USA
 */
package blue.settings;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

final class TextColorsPanel extends javax.swing.JPanel {

    private final TextColorsOptionsPanelController controller;

    private boolean loading = false;

    TextColorsPanel(TextColorsOptionsPanelController controller) {
        this.controller = controller;
        initComponents();

        PropertyChangeListener pcl = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                if ("colorSelectionValue".equals(evt.getPropertyName())) {
                    if (!loading) {
                        TextColorsPanel.this.controller.changed();
                    }
                }
            }
        };

        textNormal.addPropertyChangeListener(pcl);
        textComment.addPropertyChangeListener(pcl);
        textKeyword.addPropertyChangeListener(pcl);
        textQuote.addPropertyChangeListener(pcl);
        textVariable.addPropertyChangeListener(pcl);
        textBackground.addPropertyChangeListener(pcl);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        resetColorsButton = new javax.swing.JButton();
        useBlueDefaultsButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textComment = new blue.settings.ColorSelectionPanel();
        textNormal = new blue.settings.ColorSelectionPanel();
        textKeyword = new blue.settings.ColorSelectionPanel();
        textQuote = new blue.settings.ColorSelectionPanel();
        textVariable = new blue.settings.ColorSelectionPanel();
        textBackground = new blue.settings.ColorSelectionPanel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(TextColorsPanel.class, "TextColorsPanel.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(TextColorsPanel.class, "TextColorsPanel.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(TextColorsPanel.class, "TextColorsPanel.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(TextColorsPanel.class, "TextColorsPanel.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(TextColorsPanel.class, "TextColorsPanel.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(resetColorsButton, org.openide.util.NbBundle.getMessage(TextColorsPanel.class, "TextColorsPanel.resetColorsButton.text")); // NOI18N
        resetColorsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetColorsButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(useBlueDefaultsButton, org.openide.util.NbBundle.getMessage(TextColorsPanel.class, "TextColorsPanel.useBlueDefaultsButton.text")); // NOI18N
        useBlueDefaultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useBlueDefaultsButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(TextColorsPanel.class, "TextColorsPanel.jLabel6.text")); // NOI18N

        org.jdesktop.layout.GroupLayout textCommentLayout = new org.jdesktop.layout.GroupLayout(textComment);
        textComment.setLayout(textCommentLayout);
        textCommentLayout.setHorizontalGroup(
            textCommentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 310, Short.MAX_VALUE)
        );
        textCommentLayout.setVerticalGroup(
            textCommentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 14, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout textNormalLayout = new org.jdesktop.layout.GroupLayout(textNormal);
        textNormal.setLayout(textNormalLayout);
        textNormalLayout.setHorizontalGroup(
            textNormalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 310, Short.MAX_VALUE)
        );
        textNormalLayout.setVerticalGroup(
            textNormalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 14, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout textKeywordLayout = new org.jdesktop.layout.GroupLayout(textKeyword);
        textKeyword.setLayout(textKeywordLayout);
        textKeywordLayout.setHorizontalGroup(
            textKeywordLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 310, Short.MAX_VALUE)
        );
        textKeywordLayout.setVerticalGroup(
            textKeywordLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 14, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout textQuoteLayout = new org.jdesktop.layout.GroupLayout(textQuote);
        textQuote.setLayout(textQuoteLayout);
        textQuoteLayout.setHorizontalGroup(
            textQuoteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 310, Short.MAX_VALUE)
        );
        textQuoteLayout.setVerticalGroup(
            textQuoteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 14, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout textVariableLayout = new org.jdesktop.layout.GroupLayout(textVariable);
        textVariable.setLayout(textVariableLayout);
        textVariableLayout.setHorizontalGroup(
            textVariableLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 310, Short.MAX_VALUE)
        );
        textVariableLayout.setVerticalGroup(
            textVariableLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 14, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout textBackgroundLayout = new org.jdesktop.layout.GroupLayout(textBackground);
        textBackground.setLayout(textBackgroundLayout);
        textBackgroundLayout.setHorizontalGroup(
            textBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 310, Short.MAX_VALUE)
        );
        textBackgroundLayout.setVerticalGroup(
            textBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 14, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(4, 4, 4))
                            .add(layout.createSequentialGroup()
                                .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(4, 4, 4))
                            .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(textBackground, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(textQuote, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(textKeyword, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(textNormal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, useBlueDefaultsButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, resetColorsButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, textVariable, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(textComment, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1)
                    .add(textNormal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(textComment, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel3))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel5))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(textKeyword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel4))
                    .add(layout.createSequentialGroup()
                        .add(textQuote, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(textVariable, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(textBackground, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(8, 8, 8)
                        .add(resetColorsButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(useBlueDefaultsButton))
                    .add(jLabel6))
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resetColorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetColorsButtonActionPerformed
        resetColors();
    }//GEN-LAST:event_resetColorsButtonActionPerformed

    private void useBlueDefaultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useBlueDefaultsButtonActionPerformed
        defaultColors();
    }//GEN-LAST:event_useBlueDefaultsButtonActionPerformed

    protected void defaultColors() {
        textNormal.setColor(Color.WHITE);
        textComment.setColor(Color.GRAY);
        textKeyword.setColor(Color.ORANGE);
        textQuote.setColor(Color.PINK);
        textVariable.setColor(Color.PINK);
        textBackground.setColor(Color.BLACK);
    }

    protected void resetColors() {
        load();
    }

    void load() {
        loading = true;

        TextColorsSettings settings = TextColorsSettings.getInstance();

        textNormal.setColor(settings.blueSyntaxNormal);
        textComment.setColor(settings.blueSyntaxComment);
        textKeyword.setColor(settings.blueSyntaxKeyword);
        textQuote.setColor(settings.blueSyntaxQuote);
        textVariable.setColor(settings.blueSyntaxVariable);
        textBackground.setColor(settings.blueSyntaxBackground);

        loading = false;
    }

    void store() {

        TextColorsSettings settings = TextColorsSettings.getInstance();

        settings.blueSyntaxNormal = textNormal.getColor();
        settings.blueSyntaxComment = textComment.getColor();
        settings.blueSyntaxKeyword = textKeyword.getColor();
        settings.blueSyntaxQuote = textQuote.getColor();
        settings.blueSyntaxVariable = textVariable.getColor();
        settings.blueSyntaxBackground = textBackground.getColor();

        settings.save();
    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private blue.settings.ColorSelectionPanel colorSelectionPanel3;
    private blue.settings.ColorSelectionPanel colorSelectionPanel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton resetColorsButton;
    private blue.settings.ColorSelectionPanel textBackground;
    private blue.settings.ColorSelectionPanel textComment;
    private blue.settings.ColorSelectionPanel textKeyword;
    private blue.settings.ColorSelectionPanel textNormal;
    private blue.settings.ColorSelectionPanel textQuote;
    private blue.settings.ColorSelectionPanel textVariable;
    private javax.swing.JButton useBlueDefaultsButton;
    // End of variables declaration//GEN-END:variables
}

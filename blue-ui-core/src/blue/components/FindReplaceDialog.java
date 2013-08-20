/*
 * blue - object composition environment for csound
 * Copyright (c) 2000-2005 Steven Yi (stevenyi@csounds.com)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by  the Free Software Foundation; either version 2 of the License or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; see the file COPYING.LIB.  If not, write to
 * the Free Software Foundation Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307 USA
 */

package blue.components;

import blue.WindowSettingManager;
import blue.WindowSettingsSavable;
import blue.utility.GUI;
import electric.xml.Element;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.WeakHashMap;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

/**
 * 
 * @author Steven Yi
 */

// TODO - Regular Expression, Occurrences, Not Found Message
public class FindReplaceDialog extends javax.swing.JDialog implements
        WindowSettingsSavable {

    JTextComponent textArea = null;

    private static WeakHashMap<Component, FindReplaceDialog> map =
            new WeakHashMap<>();

    public static void showFindReplace(JTextComponent textComponent) {
        Component root = SwingUtilities.getRoot(textComponent);

        if (!map.containsKey(root)) {
            FindReplaceDialog dialog;

            if (root instanceof Frame) {
                dialog = new FindReplaceDialog((Frame) root);
            } else if (root instanceof Dialog) {
                dialog = new FindReplaceDialog((Dialog) root);
            } else {
                return;
            }
            map.put(root, dialog);
        }

        FindReplaceDialog findReplaceDialog = map.get(root);

        findReplaceDialog.setTextArea(textComponent);

        String selectedText = textComponent.getSelectedText();
        if (selectedText != null) {
            findReplaceDialog.setInititalSearchText(selectedText);
        }

        findReplaceDialog.setVisible(true);
    }

    /** Creates new form FindReplaceDialog */
    public FindReplaceDialog(Frame parent) {
        super(parent);
        initComponents();

        // WindowSettingManager.getInstance().registerWindow("FindReplaceDialog",
        // this);

        GUI.centerOnScreen(this);
        pack();
    }

    /** Creates new form FindReplaceDialog */
    public FindReplaceDialog(Dialog parent) {
        super(parent);
        initComponents();

        // WindowSettingManager.getInstance().registerWindow("FindReplaceDialog",
        // this);

        GUI.centerOnScreen(this);

        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        directionButtonGroup = new javax.swing.ButtonGroup();
        findLabel = new javax.swing.JLabel();
        replaceLabel = new javax.swing.JLabel();
        findText = new javax.swing.JTextField();
        replaceText = new javax.swing.JTextField();
        directionPanel = new javax.swing.JPanel();
        forwardsRadio = new javax.swing.JRadioButton();
        backwardsRadio = new javax.swing.JRadioButton();
        optionsPanel = new javax.swing.JPanel();
        wrapSearchBox = new javax.swing.JCheckBox();
        caseSensitiveBox = new javax.swing.JCheckBox();
        findButton = new javax.swing.JButton();
        replaceFindButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        replaceAllButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setTitle("Find and Replace");
        setName("Find and Replace"); // NOI18N
        setResizable(false);

        findLabel.setText("Find:");

        replaceLabel.setText("Replace:");

        findText.setPreferredSize(new java.awt.Dimension(200, 19));
        findText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findTextActionPerformed(evt);
            }
        });

        replaceText.setPreferredSize(new java.awt.Dimension(200, 19));

        directionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Direction"));
        directionPanel.setLayout(new java.awt.GridLayout(2, 0));

        directionButtonGroup.add(forwardsRadio);
        forwardsRadio.setSelected(true);
        forwardsRadio.setText("Forwards");
        directionPanel.add(forwardsRadio);

        directionButtonGroup.add(backwardsRadio);
        backwardsRadio.setText("Backwards");
        directionPanel.add(backwardsRadio);

        optionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));
        optionsPanel.setLayout(new java.awt.GridLayout(2, 0));

        wrapSearchBox.setSelected(true);
        wrapSearchBox.setText("Wrap Search");
        optionsPanel.add(wrapSearchBox);

        caseSensitiveBox.setText("Case Sensitive");
        optionsPanel.add(caseSensitiveBox);

        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findText(evt);
            }
        });

        replaceFindButton.setText("Replace and Find");
        replaceFindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceAndFind(evt);
            }
        });

        jButton1.setText("Replace");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceText(evt);
            }
        });

        replaceAllButton.setText("Replace All");
        replaceAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceAll(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFindReplaceDialog(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(directionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(findLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(findText, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(replaceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(replaceText, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(findButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(replaceAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(replaceFindButton, 0, 0, Short.MAX_VALUE))))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(closeButton)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(replaceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(replaceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(directionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(replaceFindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(replaceAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findTextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_findTextActionPerformed
        findText(null);
    }// GEN-LAST:event_findTextActionPerformed

    private void closeFindReplaceDialog(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_closeFindReplaceDialog
        this.setVisible(false);
    }// GEN-LAST:event_closeFindReplaceDialog

    private int findText(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_findText
        String searchText = findText.getText();

        if (textArea == null || searchText.length() == 0) {
            return -1;
        }

        String text = textArea.getText();

        if (!caseSensitiveBox.isSelected()) {
            searchText = searchText.toLowerCase();
            text = text.toLowerCase();
        }

        int startIndex = textArea.getCaretPosition();

        if (forwardsRadio.isSelected()) {

            int start = textArea.getSelectionStart();
            int end = textArea.getSelectionEnd();

            if (start != end) {
                startIndex = end;
            }

            int index = text.indexOf(searchText, startIndex);

            if (index == -1) {
                if (wrapSearchBox.isSelected()) {
                    startIndex = 0;
                    index = text.indexOf(searchText);
                } else {
                    return -1;
                }
            }

            if (index >= startIndex) {
                textArea.select(index, index + searchText.length());
                return index;
            }

        } else if (backwardsRadio.isSelected()) {

            int start = textArea.getSelectionStart();
            int end = textArea.getSelectionEnd();

            if (start != end) {
                startIndex = start;
            }

            int index = text.substring(0, startIndex).lastIndexOf(searchText);

            if (index == -1) {
                if (wrapSearchBox.isSelected()) {
                    startIndex = text.length();
                    index = text.lastIndexOf(searchText);
                } else {
                    return -1;
                }
            }

            if (index <= startIndex && index != -1) {
                textArea.select(index, index + searchText.length());
                return index;
            }

        }

        return -1;

    }// GEN-LAST:event_findText

    private boolean replaceText(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_replaceText
        String searchText = findText.getText();

        if (textArea == null || searchText.length() == 0) {
            return false;
        }

        String selectedText = textArea.getSelectedText();

        if (selectedText == null) {
            return false;
        }

        int start = textArea.getSelectionStart();
        int end = textArea.getSelectionEnd();

        Document doc = textArea.getDocument();

        String replacementText = replaceText.getText();

        try {
            doc.remove(start, end - start);
            doc.insertString(start, replacementText, null);
        } catch (BadLocationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        textArea.select(start, start + replacementText.length());

        return true;

    }// GEN-LAST:event_replaceText

    private void replaceAll(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_replaceAll

        int startVal = findText(null);

        if (startVal != -1) {
            replaceText(null);
        }

        int start = 0;
        int index;

        int charDiff = replaceText.getText().length()
                - findText.getText().length();

        // TODO - This needs a better check for wrap around checking
        // currently this works for if the word and replacement value starts off
        // the same, but if the search term is contained later in the
        // replacement term this goes into an infinite loop !
        while ((index = findText(null)) != -1 && index != (start + startVal)) {
            replaceText(null);
            if (index < startVal) {
                start += charDiff;
            }
        }

    }// GEN-LAST:event_replaceAll

    private void replaceAndFind(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_replaceAndFind
        if (replaceText(null)) {
            findText(null);
        }
    }// GEN-LAST:event_replaceAndFind

    // public JTextComponent getTextArea() {
    // return textArea;
    // }

    public void setTextArea(JTextComponent textArea) {
        this.textArea = textArea;
    }

    public void setInititalSearchText(String text) {
        findText.setText(text);
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                new FindReplaceDialog(frame).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton backwardsRadio;
    private javax.swing.JCheckBox caseSensitiveBox;
    private javax.swing.JButton closeButton;
    private javax.swing.ButtonGroup directionButtonGroup;
    private javax.swing.JPanel directionPanel;
    private javax.swing.JButton findButton;
    private javax.swing.JLabel findLabel;
    private javax.swing.JTextField findText;
    private javax.swing.JRadioButton forwardsRadio;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JButton replaceAllButton;
    private javax.swing.JButton replaceFindButton;
    private javax.swing.JLabel replaceLabel;
    private javax.swing.JTextField replaceText;
    private javax.swing.JCheckBox wrapSearchBox;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadWindowSettings(Element settings) {
        WindowSettingManager.setBasicSettings(settings, this);
    }

    @Override
    public Element saveWindowSettings() {
        return WindowSettingManager.getBasicSettings(this);
    }
}

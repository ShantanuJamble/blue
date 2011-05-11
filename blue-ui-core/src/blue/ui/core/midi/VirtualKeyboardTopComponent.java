/*
 * blue - object composition environment for csound
 * Copyright (c) 2000-2011 Steven Yi (stevenyi@gmail.com)
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
package blue.ui.core.midi;

import java.awt.Dimension;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//blue.ui.core.midi//VirtualKeyboard//EN",
autostore = false)
@TopComponent.Description(preferredID = "VirtualKeyboardTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "output", openAtStartup = false)
@ActionID(category = "Window", id = "blue.ui.core.midi.VirtualKeyboardTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_VirtualKeyboardAction",
preferredID = "VirtualKeyboardTopComponent")
public final class VirtualKeyboardTopComponent extends TopComponent {

    public VirtualKeyboardTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(VirtualKeyboardTopComponent.class, "CTL_VirtualKeyboardTopComponent"));
        setToolTipText(NbBundle.getMessage(VirtualKeyboardTopComponent.class, "HINT_VirtualKeyboardTopComponent"));

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        virtualKeyboardPanel1 = new blue.ui.core.midi.VirtualKeyboardPanel();

        javax.swing.GroupLayout virtualKeyboardPanel1Layout = new javax.swing.GroupLayout(virtualKeyboardPanel1);
        virtualKeyboardPanel1.setLayout(virtualKeyboardPanel1Layout);
        virtualKeyboardPanel1Layout.setHorizontalGroup(
            virtualKeyboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
        );
        virtualKeyboardPanel1Layout.setVerticalGroup(
            virtualKeyboardPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(virtualKeyboardPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(virtualKeyboardPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private blue.ui.core.midi.VirtualKeyboardPanel virtualKeyboardPanel1;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}
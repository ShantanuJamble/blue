/*
 * blue - object composition environment for csound
 * Copyright (C) 2016
 * Steven Yi <stevenyi@gmail.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package blue.ui.core.score.actions;

import blue.ui.core.score.ScorePreferences;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.util.NbPreferences;
import org.openide.util.actions.Presenter;

@ActionID(
        category = "Blue",
        id = "blue.ui.core.score.actions.LinkAutomationToScoreObjectsAction"
)
@ActionRegistration(
        displayName = "#CTL_LinkAutomationToScoreObjectsAction"
)
@ActionReferences({
    @ActionReference(path = "Menu/Score", position = 3333),
    @ActionReference(path = "Shortcuts", name = "DS-L")
})
@Messages("CTL_LinkAutomationToScoreObjectsAction=Link Automation to Score Objects")
public final class LinkAutomationToScoreObjectsAction extends AbstractAction implements Presenter.Menu {

    JRadioButtonMenuItem item = null;  

    @Override
    public void actionPerformed(ActionEvent e) {
        ScorePreferences prefs = ScorePreferences.getInstance();
        prefs.setLinkAutomations(!prefs.isLinkAutomations());
        prefs.save();

        if(item != null) {
            item.setSelected(prefs.isLinkAutomations());
        }
    }

    @Override
    public JMenuItem getMenuPresenter() {
        item = new JRadioButtonMenuItem(
                NbBundle.getMessage(LinkAutomationToScoreObjectsAction.class, 
                        "CTL_LinkAutomationToScoreObjectsAction"),null);
        item.setMnemonic(0);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));
        item.setSelected(ScorePreferences.getInstance().isLinkAutomations());
       
        item.addActionListener(ae -> {
            ScorePreferences prefs = ScorePreferences.getInstance();
            prefs.setLinkAutomations(!prefs.isLinkAutomations());
            prefs.save();
        });

        return item;
    }
}

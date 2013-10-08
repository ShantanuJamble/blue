/*
 * blue - object composition environment for csound
 * Copyright (C) 2013
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
package blue.ui.core.score.object.actions;

import blue.score.ScoreObject;
import blue.ui.core.score.undo.AlignEdit;
import blue.undo.BlueUndoManager;
import java.awt.event.ActionEvent;
import java.util.Collection;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.openide.util.ContextAwareAction;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;

//@ActionID(
//        category = "Blue",
//        id = "blue.ui.core.score.actions.AlignCenterAction")
//@ActionRegistration(
//        displayName = "#CTL_AlignCenterAction")
@Messages("CTL_AlignCenterAction=Align Center")
//@ActionReference(path = "blue/score/actions", position = 110)
public final class AlignCenterAction extends AbstractAction implements ContextAwareAction {

    private final Collection<? extends ScoreObject> selected;

    public AlignCenterAction() {
        this(null);
    }

    public AlignCenterAction(Collection<? extends ScoreObject> soundObjects) {
        super(NbBundle.getMessage(AlignCenterAction.class,
                "CTL_AlignCenterAction"));
        this.selected = soundObjects;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {

        if (selected.size() < 2) {
            return;
        }

        float initialStartTimes[] = new float[selected.size()];
        float endingStartTimes[] = new float[selected.size()];

        float farLeft = Float.MAX_VALUE;
        float farRight = Float.MIN_VALUE;
        float end;
        int i = 0;

        for (ScoreObject scoreObj : selected) {
            initialStartTimes[i] = scoreObj.getStartTime();
            end = initialStartTimes[i] + scoreObj.getSubjectiveDuration();

            if(initialStartTimes[i] < farLeft) {
                farLeft = initialStartTimes[i];
            } 
            if(end > farRight) {
                farRight = end;
            }

            i++;
        }

        float centerTime = ((farRight - farLeft) / 2) + farLeft;

        float newEndTime;
        i = 0;

        for (ScoreObject scoreObj : selected) {
            newEndTime = centerTime - (scoreObj.getSubjectiveDuration() / 2);
            scoreObj.setStartTime(newEndTime);
            endingStartTimes[i] = newEndTime;
        }

        BlueUndoManager.setUndoManager("score");
        AlignEdit edit = new AlignEdit(selected.toArray(new ScoreObject[0]), initialStartTimes,
                endingStartTimes);

        edit.setPresentationName("Align Center");

        BlueUndoManager.addEdit(edit);
    }

    @Override
    public boolean isEnabled() {
        return selected.size() > 1;
    }

    @Override
    public Action createContextAwareInstance(Lookup actionContext) {
        return new AlignCenterAction(actionContext.lookupAll(ScoreObject.class));
    }
}

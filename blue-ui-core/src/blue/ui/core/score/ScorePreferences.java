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
package blue.ui.core.score;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;

/**
 *
 * @author stevenyi
 */
public class ScorePreferences {

    private static final String PREFIX = "score.";
    private static final String LINK_AUTOMATIONS = "linkAutomations";
    private static ScorePreferences INSTANCE = null;

    private boolean linkAutomations;

    private ScorePreferences() {
    }

    public static ScorePreferences getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ScorePreferences();

            final Preferences prefs = NbPreferences.forModule(
                    ScorePreferences.class);

            INSTANCE.linkAutomations = prefs.getBoolean(
                    PREFIX + LINK_AUTOMATIONS, false);
        }
        return INSTANCE;
    }

    public boolean isLinkAutomations() {
        return linkAutomations;
    }

    public void setLinkAutomations(boolean val) {
        this.linkAutomations = val;

    }

    public void save() {
        final Preferences prefs = NbPreferences.forModule(
                ScorePreferences.class);

        prefs.putBoolean(PREFIX + LINK_AUTOMATIONS, linkAutomations);
        try {
            prefs.sync();
        } catch (BackingStoreException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}

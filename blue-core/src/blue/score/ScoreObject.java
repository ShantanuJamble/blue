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
package blue.score;

import java.awt.Color;

/**
 * Object that exists in the Score Timeline that can be selected, moved, and/or
 * resized. 
 * 
 * @author stevenyi
 */
public interface ScoreObject {

    /**
     * Sets the name of the ScoreObject.
     */
    public void setName(String name);

    /**
     * Gets the name of the ScoreObject;
     */
    public String getName();
    
    /**
     * Gets the start time of the ScoreObject.
     */
    //FIXME -  change this to use double
    public float getStartTime();

    /**
     * Sets the start time of the ScoreObject.
     */
    //FIXME -  change this to use double
    public void setStartTime(float startTime);
    
    /**
     * Gets the subjective duration of the ScoreObject.
     * 
     * The subjective duration of the ScoreObject is the amount of time a
     * ScoreObject is assigned to last, regardless of its contents.
     */
    //FIXME -  change this to use double
    public float getSubjectiveDuration();

    /**
     * Sets the subjective duration of the ScoreObject.
     * 
     * The subjective duration of the ScoreObject is the amount of time a
     * ScoreObject is assigned to last, regardless of its contents.
     */
    //FIXME -  change this to use double
    public void setSubjectiveDuration(float duration);

//    boolean isLayerTransferrable();
    // maybe use interface of Resizable?
//    boolean isLeftResizable()
    // boolean isRightResizble()

    /**
     * Adds a ScoreObjectListener to this ScoreObject
     * 
     * @param listener
     */
    public void addScoreObjectListener(ScoreObjectListener listener);

    /**
     * Removes a ScoreObjectListener to this ScoreObject
     * 
     * @param listener
     */
    public void removeScoreObjectListener(ScoreObjectListener listener);
   
    /**
     * Gets background color for ScoreObject
     * 
     * @return
     */
    public Color getBackgroundColor();

    /**
     * Sets background color for ScoreObject
     * 
     * @param color
     */
    public void setBackgroundColor(Color color);
           
    public ScoreObject clone();

}

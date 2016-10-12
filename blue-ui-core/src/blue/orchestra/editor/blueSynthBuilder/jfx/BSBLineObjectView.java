/*
 * blue - object composition environment for csound
 * Copyright (C) 2016 stevenyi
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
package blue.orchestra.editor.blueSynthBuilder.jfx;

import blue.orchestra.blueSynthBuilder.BSBLineObject;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 *
 * @author stevenyi
 */
public class BSBLineObjectView extends BorderPane {

    public BSBLineObjectView(BSBLineObject lines) {
        setUserData(lines);

        LineSelector selector = new LineSelector(lines);

        LineView lineView = new LineView(lines.getLines());
       
        setCenter(lineView);
        setBottom(selector);


        setStyle("-fx-border-color:gray;");

        sceneProperty().addListener((obs, old, newVal) -> {
            if(newVal == null) {
                lineView.widthProperty().unbind();
                lineView.heightProperty().unbind();
                selector.prefWidthProperty().unbind();
                lineView.lockedProperty().unbind();
            } else {
                lineView.widthProperty().bind(lines.canvasWidthProperty());
                lineView.heightProperty().bind(lines.canvasHeightProperty());
                selector.prefWidthProperty().bind(lines.canvasWidthProperty());
                lineView.lockedProperty().bind(lines.lockedProperty());
            }
        });
    } 

   
    static class LineSelector extends HBox {
        public LineSelector(BSBLineObject lines) {
            Label label = new Label("Test");
            Button leftButton = new Button();
            leftButton.getStyleClass().add("left-arrow");
            Button rightButton = new Button();
            rightButton.getStyleClass().add("right-arrow");
            rightButton.setStyle("-fx-scale-shape: false;");

            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);
            getChildren().addAll(label, leftButton, rightButton);
        }

    }
}

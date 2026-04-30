package cs112.lab09.controllers;

import cs112.lab09.MainApplication;
import cs112.lab09.models.Date;
import cs112.lab09.models.RevisedHistoricalEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MapController {

    private void openPopupWindow(String location, RevisedHistoricalEvent rhEvent) throws IOException {
        //get FXML for popup window (event-view.fxml)
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("event-view.fxml"));
        Parent eventViewParent = loader.load();

        //pass data to controller for that view
        EventController eventController = loader.getController();
        eventController.initData(location, rhEvent);

        //create a new stage for my popup window
        Stage popupStage = new Stage();

        //extra step: change modality of window (makes the new window the only active window, you can't interact with background window)
        popupStage.initModality(Modality.APPLICATION_MODAL);

        //set scene
        popupStage.setScene(new Scene(eventViewParent));

        //show scene
        popupStage.show();
    }

    @FXML
    protected void onSanFransicoCAButtonClick() throws IOException {
        RevisedHistoricalEvent sfEvent = new RevisedHistoricalEvent(
                "A minor riot between Black and white soldiers occured in the Presidio in San Francisco",
                new Date(5, 15, 1919),
                "A minor riot between Black and white soldiers occured in the Presidi in San Francisco after a dispute about a Thai...",
                "https://cdr.lib.unc.edu/downloads/1c18dn56n?locale=en");

      this.openPopupWindow("San Fransisco, CA", sfEvent);
    }

    @FXML
    protected void onBisbeeAZButtonClick() throws IOException {
        RevisedHistoricalEvent bisEvent = new RevisedHistoricalEvent(
                        "Local police in Bisbee, Arizona attacked the 10th U.S. Cavalry, an African-American unit known as the...",
                        new Date(7, 13, 1919),
                        "Although sources are limited, the attack occurred on the eve of celebrations meant to honor returning...",
                        "https://cdr.lib.unc.edu/downloads/1c18dm56n?locale=en");
        
        this.openPopupWindow("Bisbee, AZ", bisEvent);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package znpcp5stopwatchfxml2;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author zpierucci
 */
public class DigitalStopwatchModel {
    
    public double secondsElapsed;
    private Timeline timeline;
    private Label digitalLabel;
    
    public DigitalStopwatchModel() {
        secondsElapsed = 0.0;
        timeline = new Timeline(new KeyFrame(Duration.millis(1),
                (ActionEvent event) -> {
                    secondsElapsed += .001;
                    Date date = new Date((long)(secondsElapsed*1000));
                    String digitalTime = new SimpleDateFormat("mm:ss.SS").format(date);
                    digitalLabel.setText(digitalTime);
                })
        );
        
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    public void stop()
    {
        timeline.pause();
    }
    
    public void start()
    {
        timeline.play();
    }
    
    public void reset()
    {
        stop();
        secondsElapsed = 0;
    }
    
    public double getSecondsElapsed()
    {
        return secondsElapsed;
    }
    
    public boolean isRunning()
    {
        return (timeline.getStatus() == Animation.Status.RUNNING);
    }
    
    public void setLabel(Label label)
    {
        digitalLabel = label;
    }
}

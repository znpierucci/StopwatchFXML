/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package znpcp5stopwatchfxml2;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author zpierucci
 */
public class AnalogStopwatchModel {
    
    public double secondsElapsed;
    public double rotation;
    public int lapNumber;
    
    private Timeline timeline;
    private ImageView handImageView;
    
    public AnalogStopwatchModel() {
        secondsElapsed = 0.0;
        rotation = 0.0;
        lapNumber = 0;
        timeline = new Timeline(new KeyFrame(Duration.millis(100),
                (ActionEvent event) -> {
                    secondsElapsed += .1;
                    rotation = secondsElapsed * 6;
                    handImageView.setRotate(rotation);
                })
        );
        
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    public boolean isRunning()
    {
        return (timeline.getStatus() == Animation.Status.RUNNING);
    }
    
    public double getSecondsElapsed()
    {
        return secondsElapsed;
    }
    
    public void start()
    {
        timeline.play();
    }
    
    public void stop()
    {
        timeline.pause();
    }
    
    public void reset()
    {
        stop();
        setRotation(0);
        secondsElapsed = 0;
        setLap(0);
    }
    
    public int getLap() 
    {
        return lapNumber;
    }
    
    public void setLap(int num) 
    {
        lapNumber = num;
    }
    
    public void setRotation(double deg) 
    {
        handImageView.setRotate(deg);
    }

    public void setImageView(ImageView view) 
    {
        handImageView = view;
    }
}

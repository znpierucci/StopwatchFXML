/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package znpcp5stopwatchfxml2;

    import java.net.URL; 
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.ResourceBundle;  
    import javafx.event.ActionEvent; 
    import javafx.fxml.FXML; 
    import javafx.fxml.Initializable; 
    import javafx.scene.control.Button; 
    import javafx.scene.control.Label; 
    import javafx.scene.image.ImageView;

/**
 *
 * @author zpierucci
 */
public class FXMLDocumentController implements Initializable {
            
    private AnalogStopwatchModel analogModel; 
    private DigitalStopwatchModel digitalModel; 
    
    @FXML     
    private Label digitalLabel;         
    
    @FXML     
    private ImageView handImageView;
    
    @FXML     
    private Button startButton;         
    
    @FXML     
    private Button lapButton;          
    
    @Override     
    public void initialize(URL url, ResourceBundle rb) {         
        analogModel = new AnalogStopwatchModel();
        digitalModel = new DigitalStopwatchModel();   

        analogModel.setImageView(handImageView);
        digitalModel.setLabel(digitalLabel);
    }
    
    @FXML
    public void startButtonPressed(ActionEvent event)
    {
        if(!analogModel.isRunning())
        {
            analogModel.start();
            digitalModel.start();
            startButton.setText("Stop");
            lapButton.setText("Lap");
        }
        else
        {
            analogModel.stop();
            digitalModel.stop();
            startButton.setText("Start");
            lapButton.setText("Reset");
        }
    }
    
    @FXML
    public void lapButtonPressed(ActionEvent event)
    {
        if(analogModel.isRunning())
        {
            analogModel.setLap(analogModel.getLap() + 1);
            Date date = new Date((long)(digitalModel.getSecondsElapsed()*1000));
            String digitalTime = new SimpleDateFormat("mm:ss.SS").format(date);
            String timeString = "Lap " + analogModel.getLap() + ": " + digitalTime;
            System.out.println(timeString);
        }
        else
        {
            analogModel.reset();
            digitalModel.reset();
            digitalLabel.setText("00:00.00");
            lapButton.setText("Lap"); 
        }
    }

}

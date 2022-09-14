import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Make it pretty, lookup the components constructors and what you can do in them or not
Change action's listener's if-else for a switch-case? Maybe having the "is running" check in the right place would help it not be checked all the time?
Find a neater font, maybe
 */
public class Stopwatch extends JPanel implements ActionListener {

    //Stopwatch logic fields
    boolean started = false;
    long elapsedMilliseconds = 0;
    String millisecondsString;
    String secondsString;
    String minutesString;
    String hoursString;

    //GUI components
    JLabel timeLabel = new JLabel();
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");
    JButton resetButton = new JButton("Reset");
    JButton incrementButton = new JButton("Increment");
    int incrementNumber = 0;
    JTextArea incrementArea = new JTextArea();
    JScrollPane incrementPane = new JScrollPane(incrementArea);

    Stopwatch() {

        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));

        incrementPane.setBorder(BorderFactory.createTitledBorder("Increments:"));

        startButton.addActionListener(this);

        incrementButton.addActionListener(this);

        stopButton.addActionListener(this);

        resetButton.addActionListener(this);

        this.add(timeLabel);
        this.add(startButton);
        this.add(stopButton);
        this.add(resetButton);
        this.add(incrementButton);
        this.add(incrementPane);

        setTime();
        this.setVisible(true);
    }

    //Accuracy of this depends on the hardware running it, changing the delay, and the corresponding addition of milliseconds fixes it, but i don't like it, to be studied.
    Timer timer = new Timer(0, actionEvent -> {
        elapsedMilliseconds++;
        setTime();
    });

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == startButton) {
            if (!started) {
                timer.start();
                started = true;
                startButton.setText("Pause");
            }
            else {
                timer.stop();
                started = false;
                startButton.setText("Start");
            }
        }
        if (actionEvent.getSource() == stopButton){
            timer.stop();
            started = false;
            elapsedMilliseconds = 0;
            incrementNumber = 0;

            setTime();
            startButton.setText("Start");
            incrementArea.setText("");
        }
        if (actionEvent.getSource() == resetButton) {
            elapsedMilliseconds = 0;

            setTime();
            incrementNumber = 0;
            incrementArea.setText("");
        }
        if (actionEvent.getSource() == incrementButton && started){
                incrementNumber++;
                incrementArea.setText(incrementArea.getText()+ incrementNumber +" - "+timeLabel.getText()+"\n");
        }
    }
    void setTime(){

        millisecondsString = String.format("%03d",(elapsedMilliseconds)%1000);
        secondsString = String.format("%02d",(elapsedMilliseconds /1000)%60);
        minutesString = String.format("%02d",(elapsedMilliseconds /60000)%60);
        hoursString = String.format("%02d",(elapsedMilliseconds /3600000));

        timeLabel.setText(hoursString +":"+ minutesString +":"+ secondsString +":"+ millisecondsString);
    }
}
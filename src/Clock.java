import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock extends JPanel implements Runnable {

    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM, dd, yyyy");
    SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
    String date = dateFormat.format(Calendar.getInstance().getTime());
    String day = dayFormat.format(Calendar.getInstance().getTime());
    String time = timeFormat.format(Calendar.getInstance().getTime());
    static JLabel dateLabel = new JLabel();
    static JLabel dayLabel = new JLabel();
    static JLabel timeLabel = new JLabel();

    Clock() {

        this.setLayout(new FlowLayout());
        this.setSize(390, 290);

        this.add(timeLabel);
        timeLabel.setFont(new Font("Gothic", Font.PLAIN, 50));
        timeLabel.setForeground(Color.GREEN);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);

        this.add(dayLabel);
        dayLabel.setFont(new Font("verdana", Font.BOLD, 40));

        this.add(dateLabel);
        dateLabel.setFont(new Font("verdana", Font.PLAIN, 40));
    }

    @Override
    public void run() {
        while (true) {
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            try {Thread.sleep(1000);}
            catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
}
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Frame extends JFrame {

    JTabbedPane tabbedPane = new JTabbedPane();
    Clock clock = new Clock();
    Stopwatch stopwatch = new Stopwatch();

    Frame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 200);
        this.setLocationRelativeTo(null);
        this.setTitle("Relogiômetro! :D");

        this.add(tabbedPane);
        tabbedPane.addTab("Relógio", clock);
        tabbedPane.addTab("Cronômetro", stopwatch);

        this.setVisible(true);

        clock.run();
    }
}
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/*
JTabbedpane keeps fitting itself after the app opens, check that out
 */
public class Frame extends JFrame {

    JTabbedPane tabbedPane = new JTabbedPane();
    Clock clock = new Clock();
    Stopwatch stopwatch = new Stopwatch();

    Frame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Relogiômetro! :D");

        this.add(tabbedPane);
        tabbedPane.setSize(350,200);
        tabbedPane.addTab("Relógio", clock);
        tabbedPane.addTab("Cronômetro", stopwatch);

        this.setVisible(true);

        clock.run();
    }
}
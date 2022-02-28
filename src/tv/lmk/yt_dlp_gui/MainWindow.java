package tv.lmk.yt_dlp_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {

    static JPanel panel = new JPanel();
    static MainWindow window;

    public MainWindow() {
        setTitle("yt-dlp command generator");
        add(panel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(750, 750);
        setResizable(false);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(
                        new JFrame(), "Are you sure you want to exit?","Exit?",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else
                    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            }
        });
    }

    public static void main(String[] args) {
        initialize();
        run();
    }

    static OutputDirectorySelector outputDirectorySelector = new OutputDirectorySelector();
    static InputUrlContainer inputUrlContainer = new InputUrlContainer();

    private static void initialize() {
        GridBagConstraints center = new GridBagConstraints();
        center.gridx = 0;

        GridBagConstraints verticalOffsetUp = new GridBagConstraints();
        verticalOffsetUp.gridx = 0;
        verticalOffsetUp.insets = new Insets(0,0,25,0);

        GridBagConstraints verticalOffsetDown = new GridBagConstraints();
        verticalOffsetDown.gridx = 0;
        verticalOffsetDown.insets = new Insets(25,0,0,0);

        panel.setLayout(new GridBagLayout());
        panel.add(inputUrlContainer, verticalOffsetUp);
        panel.add(new DownloadOptionsContainer(), center);
        panel.add(outputDirectorySelector, center);
        panel.add(new GenerateOptionsContainer(), verticalOffsetDown);
        panel.add(new CommandOutputContainer(), verticalOffsetDown);
    }

    private static void run() {
        window = new MainWindow();
    }

}

package tv.lmk.yt_dlp_gui;

import javax.swing.*;

public class CommandOutputContainer extends JPanel {

    static JTextField commandOutput = new JTextField();
    static JLabel outputFieldLabel= new JLabel("Command: ");

    public CommandOutputContainer() {
        commandOutput.setColumns(35);

        add(outputFieldLabel);
        add(commandOutput);
    }
}

package tv.lmk.yt_dlp_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateOptionsContainer extends JPanel {

    static JButton generateCommandButton = new JButton("Generate Command");
    static JCheckBox generateScript = new JCheckBox("Generate run Script?");

    public GenerateOptionsContainer() {
        generateCommandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenerateCommand.generateCommand();
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.insets = new Insets(0,0,10, 0);

        setLayout(new GridBagLayout());
        add(generateScript, c);
        add(generateCommandButton, c);
    }

}

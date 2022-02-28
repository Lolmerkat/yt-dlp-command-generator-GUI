package tv.lmk.yt_dlp_gui;

import javax.swing.*;

public class InputUrlContainer extends JPanel {

    static JTextField inputUrl = new JTextField();

    public InputUrlContainer() {
        inputUrl.setColumns(30);

        add(new JLabel("URL to Download: "));
        add(inputUrl);
    }

}
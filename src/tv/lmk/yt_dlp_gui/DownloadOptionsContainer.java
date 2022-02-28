package tv.lmk.yt_dlp_gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DownloadOptionsContainer extends JPanel {

     static String[] formatList = {DownloadFormat.M4A.getFormatName(), DownloadFormat.MP3.getFormatName(),
            DownloadFormat.WAV.getFormatName(), "", DownloadFormat.AVI.getFormatName(),
            DownloadFormat.MOV.getFormatName(), DownloadFormat.MP4.getFormatName(),
            DownloadFormat.WEBM.getFormatName()};

     static String[] qualityList = {DownloadQuality.P240.getQualityName(), DownloadQuality.P360.getQualityName(),
             DownloadQuality.P480.getQualityName(), DownloadQuality.P720.getQualityName(),
             DownloadQuality.P1080.getQualityName() ,DownloadQuality.P1440.getQualityName(),
             DownloadQuality.P2160.getQualityName()};

    static JCheckBox isPlaylist = new JCheckBox("Playlist?");
    static JCheckBox embedMetadata = new JCheckBox("Embed Metadata?");
    static JComboBox<String> formats = new JComboBox<>(formatList);
    static JComboBox<String> qualities = new JComboBox<>(qualityList);
    static JPanel dropdownPanel = new JPanel();

    public DownloadOptionsContainer() {
        GridBagConstraints vertical = new GridBagConstraints();
        vertical.gridx = 0;
        vertical.insets = new Insets(3,0,3,0);

        dropdownPanel.add(formats);
        dropdownPanel.add(qualities);

        setLayout(new GridBagLayout());
        add(isPlaylist, vertical);
        add(dropdownPanel,vertical);
        add(embedMetadata, vertical);

        qualities.setEnabled(false);
        formats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qualities.setEnabled(formats.getSelectedItem() == "avi" || formats.getSelectedItem() == "mov"
                        || formats.getSelectedItem() == "mp4" || formats.getSelectedItem() == "webm");
            }
        });
    }

}

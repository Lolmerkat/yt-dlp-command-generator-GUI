package tv.lmk.yt_dlp_gui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;

public class OutputDirectorySelector extends JFileChooser {

    String outputDirectory;

    public OutputDirectorySelector() {
        setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Directories Only!";
            }
        });
        setControlButtonsAreShown(false);
        setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        setMaximumSize(new Dimension(750, 450));
    }

    public String getOutputDirectory() {
        outputDirectory = getSelectedFile().getPath();
        return outputDirectory;
    }
}

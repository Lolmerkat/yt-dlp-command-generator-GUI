package tv.lmk.yt_dlp_gui;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Objects;

public class GenerateCommand {

    static String command, outputPath, invalidInputUrlMessage;

    public static void generateCommand() {
        CommandOutputContainer.commandOutput.setText("");
        command = "yt-dlp";

        if (InputUrlContainer.inputUrl.getText().contains(" ")) {
            invalidInputUrlMessage = "The URL you put in is invalid as it contains spaces.";
            displayInvalidUrlError();
            return;
        }

        if (InputUrlContainer.inputUrl.getText().isEmpty()) {
            invalidInputUrlMessage = "You need to enter an URL to download.";
            displayInvalidUrlError();
            return;
        }

        if (DownloadOptionsContainer.isPlaylist.isSelected())
            command = command + " --is-playlist";

        if (DownloadOptionsContainer.qualities.isEnabled())
            switch ((String) Objects.requireNonNull(DownloadOptionsContainer.qualities.getSelectedItem())) {
                case "240p" -> command = command + DownloadQuality.P240.getCommandOption();
                case "360p" -> command = command + DownloadQuality.P360.getCommandOption();
                case "480p" -> command = command + DownloadQuality.P480.getCommandOption();
                case "720p" -> command = command + DownloadQuality.P720.getCommandOption();
                case "1080p" -> command = command + DownloadQuality.P1080.getCommandOption();
                case "1440p" -> command = command + DownloadQuality.P1440.getCommandOption();
                case "2160p" -> command = command + DownloadQuality.P2160.getCommandOption();
            }

        switch ((String) Objects.requireNonNull(DownloadOptionsContainer.formats.getSelectedItem())) {
            case "m4a" -> command = command + DownloadFormat.M4A.getCommandOption();
            case "mp3" -> command = command + DownloadFormat.MP3.getCommandOption();
            case "wav" -> command = command + DownloadFormat.WAV.getCommandOption();
            case "avi" -> command = command + DownloadFormat.AVI.getCommandOption();
            case "mov" -> command = command + DownloadFormat.MOV.getCommandOption();
            case "mp4" -> command = command + DownloadFormat.MP4.getCommandOption();
            case "webm" -> command = command + DownloadFormat.WEBM.getCommandOption();
            default -> {
                JOptionPane.showMessageDialog(new JFrame(), "Please select a valid Format.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (DownloadOptionsContainer.embedMetadata.isSelected())
            command = command + " --embed-metadata";

        try {
            outputPath = MainWindow.outputDirectorySelector.getSelectedFile().getPath();
        } catch (NullPointerException e) {
            outputPath = "%userprofile%\\Downloads";
        }
        command = command + " -o \"" + outputPath + "\\%(title)s.%(ext)s\" " + InputUrlContainer.inputUrl.getText();

        if (GenerateOptionsContainer.generateScript.isSelected()) {
            PrintStream ps;
            try {
                ps = new PrintStream(".\\command.bat");
                ps.print(command);
                ps.close();
            } catch (FileNotFoundException ignored) {}
        }

        CommandOutputContainer.commandOutput.setText(command);
    }

    private static void displayInvalidUrlError() {
        JOptionPane.showMessageDialog(new JFrame(), invalidInputUrlMessage, "Error",
                JOptionPane.ERROR_MESSAGE);
    }

}

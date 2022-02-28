package tv.lmk.yt_dlp_gui;

public enum DownloadFormat {

    MP4("mp4"," --merge-output-format mp4", "video"),
    WEBM("webm"," --merge-output-format webm", "video"),
    MOV("mov"," --merge-output-format mov", "video"),
    AVI("avi"," --merge-output-format avi", "video"),

    MP3("mp3"," --extract-audio --audio-format mp3", "audio"),
    M4A("m4a"," --extract-audio --audio-format m4a", "audio"),
    WAV("wav"," --extract-audio --audio-format wav", "audio");

    private DownloadFormat(String formatName, String commandOption, String type) {
        this.formatName = formatName;
        this.commandOption = commandOption;
        this.type = type;
    };

    private final String formatName, commandOption, type;

    public String getFormatName() {
        return formatName;
    }

    public String getCommandOption() {
        return commandOption;
    }
}


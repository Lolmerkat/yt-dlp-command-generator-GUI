package tv.lmk.yt_dlp_gui;

public enum DownloadQuality {

    P240("240p", " --format \"bestvideo[height<=240]+bestaudio\""),
    P360("360p", " --format \"bestvideo[height<=360]+bestaudio\""),
    P480("480p", " --format \"bestvideo[height<=480]+bestaudio\""),
    P720("720p", " --format \"bestvideo[height<=720]+bestaudio\""),
    P1080("1080p", " --format \"bestvideo[height<=1080]+bestaudio\""),
    P1440("1440p"," --format \"bestvideo[height<=1440]+bestaudio\""),
    P2160("2160p"," --format \"bestvideo[height<=2160]+bestaudio\"");

    private DownloadQuality(String qualityName, String commandOption) {
        this.qualityName = qualityName;
        this.commandOption = commandOption;
    }

    private String qualityName, commandOption;

    public String getQualityName() {
        return qualityName;
    }

    public String getCommandOption() {
        return commandOption;
    }

}

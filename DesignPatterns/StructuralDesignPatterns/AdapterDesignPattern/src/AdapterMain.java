public class AdapterMain {
    public static void main(String[] args) {
        LegacyMp3Player legacyMp3Player = new LegacyMp3Player();
        MediaPlayer mediaPlayer = new MediaPlayer(legacyMp3Player);

        mediaPlayer.play("mp3");
        mediaPlayer.play("vlc");
        mediaPlayer.play("mp4");
    }
}

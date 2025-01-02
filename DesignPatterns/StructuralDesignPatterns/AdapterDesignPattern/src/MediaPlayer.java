public class MediaPlayer {
    private final LegacyMp3Player legacyMp3Player;

    public MediaPlayer(LegacyMp3Player legacyMp3Player) {
        this.legacyMp3Player = legacyMp3Player;
    }

    public void play(String type){
        if(type.equalsIgnoreCase("mp3")){
            legacyMp3Player.play(type);
        }else {
            MediaAdapter mediaAdapter = new MediaAdapter(type);
            mediaAdapter.play(type);
        }
    }

}

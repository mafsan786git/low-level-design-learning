public class MediaAdapter {
    private final AdvanceMediaPlayer advanceMediaPlayer;
    public MediaAdapter(String audioType){
        if (audioType.equalsIgnoreCase("vlc")){
            advanceMediaPlayer = new VLCMediaPlayer();
            return;
        }
        if (audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer = new Mp4MediaPlayer();
            return;
        }
        throw new IllegalArgumentException("Unsupported audio type");
    }

    public void play(String name){
        advanceMediaPlayer.play(name);  //Delegates to the concrete class that implements the AdvanceMediaPlayer interface.  This allows the MediaAdapter to support different types of media players.
    }


}

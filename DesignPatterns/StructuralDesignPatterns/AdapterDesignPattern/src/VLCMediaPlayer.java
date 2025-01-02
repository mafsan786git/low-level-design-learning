public class VLCMediaPlayer implements AdvanceMediaPlayer{
    @Override
    public void play(String name) {
        System.out.println("Playing VLC  fileName: " + name);
    }
}

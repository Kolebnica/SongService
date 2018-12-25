package pojo;

import entities.Song;
import entities.Stream;

public class UploadForm {

    private Song song;

    private byte[] stream;

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public byte[] getStream() {
        return stream;
    }

    public void setStream(byte[] stream) {
        this.stream = stream;
    }
}

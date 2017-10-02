package br.com.fatec.rockchords;

/**
 * Created by MEGAS on 28/08/2017.
 */

public class Music {

    private String chords;
    private String band;
    private String musicName;

    public Music(String chords, String band, String musicName){
        this.chords = chords;
        this.band = band;
        this.musicName = musicName;
    }

    public String getChords(){
        return this.chords;
    }

    public String getBand(){
        return this.band;
    }

    public String getMusicName(){
        return this.musicName;
    }
}

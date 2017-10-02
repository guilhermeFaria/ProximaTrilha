package br.com.fatec.proximatrilha.util;

/**
 * Created by MEGAS on 03/09/2017.
 */

public class Marker {

    private Double lat;
    private Double lon;
    private String description;

    public Marker(Double l, Double lo, String desc){
        lat = l;
        lon = lo;
        description = desc;
    }

    public Double getLat(){
        return lat;
    }

    public Double getLon(){
        return lon;
    }

    public String getDesc() { return description; }

}

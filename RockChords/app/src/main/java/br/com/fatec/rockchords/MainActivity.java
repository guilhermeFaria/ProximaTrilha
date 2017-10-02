package br.com.fatec.rockchords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MusicList musics = new MusicList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musics.getMusics();

        List<String> bands = musics.returnAllBands();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, bands);

        final Spinner spinnerBand = (Spinner) findViewById(R.id.chooseBand);

        final Spinner spinnerMusic = (Spinner) findViewById(R.id.chooseMusic);

        spinnerBand.setAdapter(adapter);

        spinnerBand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String selectedBand = String.valueOf(spinnerBand.getSelectedItem());

                List<String> musicNames = musics.returnMusicsByBand(selectedBand);

                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, musicNames);


                spinnerMusic.setAdapter(adapter2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
}

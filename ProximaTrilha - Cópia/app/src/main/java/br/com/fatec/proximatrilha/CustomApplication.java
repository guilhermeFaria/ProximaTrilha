package br.com.fatec.proximatrilha;

import android.app.Application;

import com.google.firebase.FirebaseApp;

/**
 * Created by MEGAS on 11/09/2017.
 */

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }

}

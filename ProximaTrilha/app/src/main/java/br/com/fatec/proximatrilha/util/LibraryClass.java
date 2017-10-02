package br.com.fatec.proximatrilha.util;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
/**
 * Created by MEGAS on 11/09/2017.
 */

public class LibraryClass {

    private static DatabaseReference firebase;
    private static final String STORAGE_URL = "https://proximatrilha-16532.firebaseio.com/";


    private LibraryClass(){}

    public static DatabaseReference getFirebase(){
        if( firebase == null ){
            firebase = FirebaseDatabase.getInstance().getReference();
        }

        return( firebase );
    }

}

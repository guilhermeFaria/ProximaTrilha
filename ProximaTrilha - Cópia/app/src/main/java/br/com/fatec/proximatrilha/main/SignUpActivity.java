package br.com.fatec.proximatrilha.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import br.com.fatec.proximatrilha.model.User;
import br.com.fatec.proximatrilha.util.LibraryClass;


/**
 * Created by MEGAS on 11/09/2017.
 */

public class SignUpActivity extends CommonActivity implements DatabaseReference.CompletionListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private DatabaseReference firebase;
    private User user;
    private AutoCompleteTextView name;
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        firebase = LibraryClass.getFirebase();
        initViews();
    }

    protected void initViews() {
        name = (AutoCompleteTextView) findViewById(R.id.name);
        email = (AutoCompleteTextView) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.sign_up_progress);

    }

    protected void initUser() {
        user = new User();
        user.setName(name.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        //user.generatedCryptPassword();
    }

    public void sendSignUpData(View view) {
        openProgressBar();
        initUser();
    }

    private void saveUser() {
        mAuth.createUserWithEmailAndPassword(
                user.getEmail(),
                user.getPassword()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if( !task.isSuccessful() ){
                    closeProgressBar();
                }
            }
        })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        FirebaseCrash.report( e );
                        showSnackBar( e.getMessage() );
                    }
                });
    }
*/
    @Override
    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
        //mAuth.signOut();

        showToast( "Conta criada com sucesso!" );
        closeProgressBar();
        finish();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initUser() {

    }
}

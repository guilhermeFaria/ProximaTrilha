package br.com.fatec.proximatrilha.main;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import br.com.fatec.proximatrilha.model.User;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends CommonActivity {
    @Override
    protected void initViews() {

    }

    @Override
    protected void initUser() {

    }
/*
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    protected void initViews() {
        email = (AutoCompleteTextView) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
    }

    protected void initUser() {
        user = new User();
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        //user.generatedCryptPassword();
    }

    public void callSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void sendLoginData(View view) {
        openProgressBar();
        initUser();
    }
*/
}
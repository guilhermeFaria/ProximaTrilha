package br.com.fatec.proximatrilhav1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String DEBUG ="DEBUG";
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText mEmailField;
    private EditText mPasswordField;
    private EditText mPasswordFieldTeste;
    EditText editLogin;
    EditText editPassword;
    Button btnLoginRegister;
    ProgressDialog progressLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmailField = (EditText) findViewById(R.id.register_text_email);
        mPasswordField = (EditText) findViewById(R.id.register_text_password);

        firebaseAuth = FirebaseAuth.getInstance();
        editLogin = (EditText) findViewById(R.id.action_text_email);
        editPassword = (EditText) findViewById(R.id.action_text_password);
        btnLoginRegister = (Button) findViewById(R.id.register_button);
        progressLogin = new ProgressDialog(this);
        btnLoginRegister.setOnClickListener(this);

    }
/*
    public void onClick() {
        mAuth.createUserWithEmailAndPassword(mEmailField, mPasswordField)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(DEBUG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, R.string.auth_failed,
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }
*/
    private boolean validateForm() {
        boolean valid = true;

        String email = mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }

        return valid;
    }

    private void registerUser(){
        String email = editLogin.getText().toString().trim();
        String password  = editPassword.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, R.string.enter_your_email,Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, R.string.enter_your_password,Toast.LENGTH_LONG).show();
            return;
        }
        progressLogin.setMessage(getString(R.string.registering_user));
        progressLogin.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, R.string.successfully_registred,Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("nome", editLogin.getText().toString().trim());
                            startActivity(intent);
                        }else{
                            Toast.makeText(RegisterActivity.this, R.string.registration_error,Toast.LENGTH_LONG).show();
                        }
                        progressLogin.dismiss();
                    }
                });
    }
    @Override
    public void onClick(View v) {
        registerUser();
    }
}

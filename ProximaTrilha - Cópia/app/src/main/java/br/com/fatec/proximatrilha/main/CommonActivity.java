package br.com.fatec.proximatrilha.main;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by MEGAS on 11/09/2017.
 */

public abstract class CommonActivity extends AppCompatActivity {

    protected AutoCompleteTextView email;
    protected EditText password;
    protected ProgressBar progressBar;

    protected void showSnackBar(String message){
        Snackbar.make(progressBar,
                message,
                Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    protected void openProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }
    protected void closeProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    abstract protected void initViews();

    abstract protected void initUser();



}

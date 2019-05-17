package com.example.wael_pc.myapplication.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wael_pc.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private EditText emailEt, passwordEt;
    private Button signInBtn;
    private TextView signUpTv;

    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialisationFields();

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String emailStr = emailEt.getText().toString();
                String passwordStr = passwordEt.getText().toString();
                if (emailStr.isEmpty())
                {
                    emailEt.setError(getString(R.string.focus_email));
                    emailEt.requestFocus();
                }else if (passwordStr.isEmpty())
                {
                    passwordEt.setError(getString(R.string.focus_password));
                    passwordEt.requestFocus();
                }else
                    progressDialog.setTitle(getString(R.string.title_progressDialog));
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.setMessage(getString(R.string.message_progressDialog));
                    progressDialog.show();
            }
        });

        signUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserToSignUpActivity();
            }
        });
    }

    private void sendUserToSignUpActivity()
    {
        Intent signUpActivity = new Intent(this, SignUpActivity.class);
    }

    private void initialisationFields()
    {
        emailEt = findViewById(R.id.email);
        passwordEt = findViewById(R.id.password);
        signInBtn = findViewById(R.id.btn_connecter);
        signUpTv = findViewById(R.id.tv_signIn);

        progressDialog = new ProgressDialog(this);
    }
}

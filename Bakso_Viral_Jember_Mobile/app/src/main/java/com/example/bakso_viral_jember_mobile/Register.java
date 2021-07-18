package com.example.bakso_viral_jember_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bakso_viral_jember_mobile.user.LoginActivity;

public class Register extends AppCompatActivity {
    private EditText mViewUser, mViewPass, mViewRepass;
    Button toLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         /* Menginisialisasi variable dengan Form User, Form Password, dan Form Repassword
        dari Layout RegisterActivity */
        mViewUser = findViewById(R.id.et_emailSignup);
        mViewPass = findViewById(R.id.et_passwordSignup);
        mViewRepass = findViewById(R.id.et_passwordSignup2);
        toLog = findViewById(R.id.toLogin);

        toLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, LoginActivity.class);
                startActivity(i);
            }
        });
        /* Menjalankan Method razia() jika merasakan tombol SignUp di keyboard disentuh */
        mViewRepass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL){
                    razia();
                    return true;
                }
                return false;
            }
        });
        /* Menjalankan Method razia() jika merasakan tombol SignUp disentuh */
        findViewById(R.id.button_signupup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                razia();
            }
        });
    }

    /** Men-check inputan User dan Password dan Memberikan akses ke MainActivity */
    private  void razia(){
        /* Mereset semua Error dan fokus menjadi default */
        mViewUser.setError(null);
        mViewPass.setError(null);
        mViewRepass.setError(null);
        View fokus = null;
        boolean cancel = false;

        /* Mengambil text dari Form User, Password, Repassword dengan variable baru bertipe String*/
        String repass = mViewRepass.getText().toString();
        String user = mViewUser.getText().toString();
        String pass = mViewPass.getText().toString();

        /* Jika form user kosong atau MEMENUHI kriteria di Method cekUser() maka, Set error di Form-
         * User dengan menset variable fokus dan error di Viewnya juga cancel menjadi true*/
        if (TextUtils.isEmpty(user)){
            mViewUser.setError("This fiels is required");
            fokus = mViewUser;
            cancel = true;
        } else if (cekUser(user)){
            mViewUser.setError("This username already exist");
            fokus = mViewUser;
            cancel = true;
        }

        /* Jika form password kosong dan MEMENUHI kriteria di Method cekPassword maka,
         * Reaksinya sama dengan percabangan User di atas. Bedanya untuk Password dan Repassword*/
        if (TextUtils.isEmpty(pass)){
            mViewPass.setError("This field is required");
            fokus = mViewPass;
            cancel = true;
        }else if (!cekPass(pass,repass)){
            mViewRepass.setError("This password is incorrect");
            fokus = mViewRepass;
            cancel = true;
        }

        /** Jika cancel true, variable fokus mendapatkan fokus. Jika false, maka
         *  Kembali ke LoginActivity dan Set User dan Password untuk data yang terdaftar */
        if (cancel){
            fokus.requestFocus();
        } else {
            preferences.setRegisteredUser(getBaseContext(),user);
            preferences.setRegisteredPass(getBaseContext(),pass);
            finish();
        }
    }

    /** True jika parameter password sama dengan parameter repassword */
    private boolean cekPass(String pass, String repass){
        return pass.equals(repass);
    }

    /** True jika parameter user sama dengan data user yang terdaftar dari Preferences */
    private boolean cekUser( String user){
        return user.equals(preferences.getRegisteredUser(getBaseContext()));
    }
}

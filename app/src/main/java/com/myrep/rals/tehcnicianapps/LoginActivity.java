package com.myrep.rals.tehcnicianapps;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.myrep.rals.tehcnicianapps.Utility.CustomFont;
import com.myrep.rals.tehcnicianapps.Utility.SessionManager;
import com.myrep.rals.tehcnicianapps.model.LogStatus;
import com.myrep.rals.tehcnicianapps.service.ApiClient;
import com.myrep.rals.tehcnicianapps.service.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button loginbtn;
    private String emailstatic ="technician@technician.com";
    private String passwordstatic = "technician";
    private Context ctx;
    private TextView register;
    private Intent movetoregister;
    private Intent movetomainmenu;
    private CustomFont changefont;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        ctx = this;
        initialize();
    }

    private void initialize()
    {
        changefont = new CustomFont();
        email = (EditText)findViewById(R.id.emailtxt);
        password = (EditText)findViewById(R.id.passwordtxt);
        loginbtn = (Button)findViewById(R.id.loginbtn);
        sessionManager = new SessionManager(ctx);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailstatic = email.getText().toString();
                passwordstatic = password.getText().toString();
                ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<LogStatus> statusCall = apiInterface.postLogin(emailstatic,passwordstatic);
                statusCall.enqueue(new Callback<LogStatus>() {
                    @Override
                    public void onResponse(Call<LogStatus> call, Response<LogStatus> response) {
                        LogStatus logStatus = response.body();
                        if(logStatus.getStatus().equalsIgnoreCase("Ok")){
                            sessionManager.CreateLoginSession(emailstatic,logStatus.getAuthorization());
                            movetomainmenu = new Intent(ctx, HomeActivity.class);
                            startActivity(movetomainmenu);
                            finish();
                        }else {
                            Toast.makeText(ctx, "There is something wrong with the application.", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LogStatus> call, Throwable t) {
                        Toast.makeText(ctx, "There is something wrong with the application.", Toast.LENGTH_LONG).show();
                    }
                });
//                if(email.getText().toString().equals(emailstatic) && password.getText().toString().equals(passwordstatic))
//                {
//                    movetomainmenu = new Intent(ctx, HomeActivity.class);
//                    startActivity(movetomainmenu);
//                    finish();
//                  //  destroy();
//                } else {
//                    Toast.makeText(ctx, "Incorrect password or email", Toast.LENGTH_LONG).show();
//                }
            }
        });


        changefont.EditTextFont(ctx, email);
        changefont.EditTextFont(ctx, password);
        changefont.ButtonFont(ctx,loginbtn);
    }


}

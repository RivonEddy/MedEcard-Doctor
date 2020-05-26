package com.medecard.user.medecard_doctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class LoginActivity extends AppCompatActivity {

    TextView textView, textView1;
    Intent intent;
    ImageView image_back;
    Button button;
    TextInputLayout email, password;
    TextInputEditText mEmail, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView = (TextView) findViewById(R.id.register_text);
        textView1 = (TextView) findViewById(R.id.forgot_passwd);
        image_back = (ImageView) findViewById(R.id.back_btn);
        button = (Button) findViewById(R.id.login_btn);
        mEmail = (TextInputEditText) findViewById(R.id.email_login);
        mPassword = (TextInputEditText) findViewById(R.id.password_login);
        email = (TextInputLayout) findViewById(R.id.textInputEmailLogin);
        password = (TextInputLayout) findViewById(R.id.textInputPasswordLogin);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent (LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent (LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent (LoginActivity.this, LogRegActivity.class);
                startActivity(intent);
            }
        });

        // initiate progress bar and start button
        final ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);

        PushDownAnim.setPushDownAnimTo(button)
                .setScale(MODE_STATIC_DP, 20)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_RELEASE_DURATION)
                .setInterpolatorPush(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setInterpolatorRelease(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mEmail.getText().toString().isEmpty() ||
                                !mEmail.getText().toString().endsWith("@gmail.com") &&
                                        !mEmail.getText().toString().endsWith("@yahoo.com")) {
                            email.setError("Invalid email type");
                        } else if (mPassword.getText().toString().isEmpty() &&
                                mPassword.getText().length() < 6) {
                            password.setError("Input valid password");
                        } else {

                            // -------- HardCoding the Login ---------- \\
                            if(mEmail.getText().toString().equals("user@gmail.com") && mPassword.getText()
                                    .toString().equals("password")){
                                simpleProgressBar.setVisibility(View.VISIBLE);
                                showToast("Logged In Successfully");
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            } else{
                                showToast("Incorrect login details");
                            }
                        }
                    }
                });

    }


    public void showToast(final String Text){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this,
                        Text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.prio.messenger;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class LoginActivity extends Activity {
    Button sendOTP;
    EditText edtOTP,edtMobileNumber;
    LinearLayout otpLL;
    boolean isSendedOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sendOTP = findViewById(R.id.sendOTP);
        edtMobileNumber = findViewById(R.id.edtMobileNumber);
        edtOTP = findViewById(R.id.edtOTP);
        otpLL = findViewById(R.id.otpLL);

        edtMobileNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() == 10) {
                    sendOTP.setBackgroundColor(Color.GREEN);
                } else {
                    sendOTP.setBackgroundColor(Color.parseColor("#5A6267"));
                }
            }
        });

        edtOTP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() == 4) {
                    sendOTP.setBackgroundColor(Color.GREEN);
                } else {
                    sendOTP.setBackgroundColor(Color.parseColor("#5A6267"));
                }
            }
        });

        sendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isSendedOtp){
                    isSendedOtp = true;
                    if(edtMobileNumber.getText().length() < 10){
                        edtMobileNumber.setError("Please Enter Correct Mobile Number.");
                    } else {
//                        Call Send OTP
                        otpLL.setVisibility(View.VISIBLE);
                        sendOTP.setText("LOGIN");
                    }
                } else {
                    if(edtOTP.getText().length() < 10){
                        edtOTP.setError("Please Enter OTP with Minimum 4 Numbers.");
                    } else {
//                        Call Login API

                    }
                }
            }
        });
    }
}

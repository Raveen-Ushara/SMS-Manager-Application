package com.example.smsmanager;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSendSms;
    EditText textPhoneNum;
    EditText textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        btnSendSms = findViewById(R.id.send_btn);
        textPhoneNum = findViewById(R.id.phone_num);
        textMessage = findViewById(R.id.message);

        btnSendSms.setOnClickListener(view -> {
            //Get Phone Number and Message
            String phoneNum = textPhoneNum.getText().toString();
            String msg = textMessage.getText().toString();

            if (!phoneNum.isEmpty() && !msg.isEmpty())
            {
                sendSMS(phoneNum, msg);
            }
            else //if phone number or message is empty
                {
                    Toast.makeText(getBaseContext(), "Please enter both phone number and message", Toast.LENGTH_SHORT).show();
                }
        });
        }

    // Function to send SMS
    private void sendSMS(String phoneNumber, String message ) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
}
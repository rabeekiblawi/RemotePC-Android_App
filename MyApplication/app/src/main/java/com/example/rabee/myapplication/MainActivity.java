package com.example.rabee.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    EditText ipET,codeET;
    Button sendbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ipET=(EditText)findViewById(R.id.ipEditText);
        codeET=(EditText)findViewById(R.id.editTextBash);
        sendbutton=(Button)findViewById(R.id.Senbutton);

        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "sending"+codeET.getText().toString();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Thread t=new Thread(new Runnable() {
                    public void run() {
                        try {



                            Socket socket= new Socket(ipET.getText().toString() ,5005);
                            DataOutputStream dOS= new DataOutputStream(socket.getOutputStream());
                            dOS.writeUTF(codeET.getText().toString());
                            dOS.flush();



                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                    t.start();
            }
        });

    }
}

package com.example.raksa.usingresultreceiver;

import android.content.Intent;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startServiceButton;
    TextView resultTextView;
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startServiceButton = (Button) findViewById(R.id.button);
        resultTextView = (TextView) findViewById(R.id.textView);


        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyResultReceiver myResultReceiver = new MyResultReceiver(null);

                Intent startIntentServiceIntent = new Intent(MainActivity.this,MyIntentService.class);
                startIntentServiceIntent.putExtra("receiver",myResultReceiver);

                startService(startIntentServiceIntent);

            }
        });

    }

    private class MyResultReceiver extends ResultReceiver {


        public MyResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultData != null && resultCode == 101 ){
                final int result = resultData.getInt("result",0);

                Log.i("Result From Service", String.valueOf(result));

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        resultTextView.setText(Integer.toString(result));
                    }
                });


            }
        }
    }


}





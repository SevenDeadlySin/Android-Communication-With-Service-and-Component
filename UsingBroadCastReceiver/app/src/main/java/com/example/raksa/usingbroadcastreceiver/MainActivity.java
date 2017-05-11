package com.example.raksa.usingbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = (TextView) findViewById(R.id.textView);

    }


    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.service.to.activity");
        registerReceiver(myServiceReceiver,intentFilter);
    }

    private BroadcastReceiver myServiceReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
                int result = intent.getIntExtra("result",0);
                resultTextView.setText(String.valueOf(result));

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myServiceReceiver);
    }

    public void onStartServiceButton(View view) {

        Intent startServiceIntent = new Intent(MainActivity.this,MyService.class);
        startService(startServiceIntent);


    }
}

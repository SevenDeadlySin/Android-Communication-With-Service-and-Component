package com.example.raksa.usingbroadcastreceiver;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Random;

public class MyService extends IntentService {

    Random random = new Random();

    public MyService() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


        int randomNumber1 = random.nextInt(1000);
        int randomNumber2 = random.nextInt(1000);

        int result = randomNumber1 + randomNumber2 ;

        Intent broadcastIntent = new Intent("action.service.to.activity");
        broadcastIntent.putExtra("result",result);
        sendBroadcast(broadcastIntent);

    }
}


package com.example.raksa.usingresultreceiver;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by Raksa on 5/2/2017.
 */

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {


        int Result = 500 + 5;

        ResultReceiver myResultReceiver = intent.getExtras().getParcelable("receiver");

        Bundle bundle = new Bundle();
        bundle.putInt("result",Result);
        myResultReceiver.send(101,bundle);

    }
}

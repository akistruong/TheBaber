package com.example.thebaber.Helpers;

import android.content.Context;

//import com.cloudinary.android.MediaManager;

import com.cloudinary.android.MediaManager;

import java.util.HashMap;
import java.util.Map;

public class CloudHelper {
    static Map config = new HashMap();
    static Context context;
    public CloudHelper(Context context) {
        this.context = context;
    }
    public static  void initCloud()
    {
        Map config = new HashMap();
        config.put("cloud_name", "akistruong");
        config.put("api_key", "182598294733339");
        config.put("api_secret", "fa3Za_WvvqpWPI68ua1FRcqItVk");
        config.put("secure", true);
        MediaManager.init(context, config);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}

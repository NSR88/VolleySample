package com.example.volleysample.volleysample.helper;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by adisoft2 on 25/8/15.
 */
public class FontCache {

    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();

    public static Typeface get(String name, Context context) {
        Typeface tf = fontCache.get(name);
        if(tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), name);
                tf  = tf.DEFAULT_BOLD;
            }
            catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }
}
package com.mtaj.mtaj_08.cableplus_new;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by MTAJ-08 on 10/27/2016.
 */
public class MyCustomTextView extends TextView {

    public MyCustomTextView(Context context, AttributeSet attrs)
    {
        super(context,attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"font/mangal.ttf"));
    }

}

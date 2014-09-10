package com.example.sercangok.edad.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by sercangok on 03/09/14.
 */
public class TextView700 extends TextView {

    public TextView700(Context context) {
        super(context);
        if (!isInEditMode()) init();
    }

    public TextView700(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) init();
    }

    public TextView700(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) init();
    }

    private void init() {
        Typeface tempTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/MuseoSansRounded-700.otf");
        setTypeface(tempTypeface);
    }
}

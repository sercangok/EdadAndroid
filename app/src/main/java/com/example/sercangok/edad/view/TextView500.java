package com.example.sercangok.edad.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by sercangok on 03/09/14.
 */
public class TextView500 extends TextView {
    public TextView500(Context context) {
        super(context);
        if (!isInEditMode())
            init();
    }

    public TextView500(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            init();
    }

    public TextView500(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode())
            init();
    }

    public void init() {
        Typeface tempTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/MuseoSansRounded-500.otf");
        setTypeface(tempTypeface);
    }
}

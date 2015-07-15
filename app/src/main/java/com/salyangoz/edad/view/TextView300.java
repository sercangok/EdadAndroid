package com.salyangoz.edad.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by sercangok on 02/09/14.
 */
public class TextView300 extends TextView {

    public TextView300(Context context) {
        super(context);
        if (!isInEditMode())
            init();
    }

    public TextView300(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            init();
    }

    public TextView300(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode())
            init();
    }

    public void init() {
        Typeface tempTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/MuseoSansRounded-300.otf");
        setTypeface(tempTypeface);
    }
}

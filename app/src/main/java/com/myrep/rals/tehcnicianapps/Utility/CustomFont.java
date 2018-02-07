package com.myrep.rals.tehcnicianapps.Utility;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Rals-PC on 8/10/2016.
 */
public class CustomFont {

   // Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Mockup-Bold.otf");
    private String fontname = "fonts/Roboto-Light.otf";
    private Typeface font;

    public CustomFont() {
        super();
    }

    public void TextViewFont(Context ctx, TextView txt)
    {
        font = Typeface.createFromAsset(ctx.getAssets(),fontname);
        txt.setTypeface(font);
    }

    public void ButtonFont(Context ctx, Button btn)
    {
        font = Typeface.createFromAsset(ctx.getAssets(),fontname);
        btn.setTypeface(font);
    }

    public void EditTextFont(Context ctx, EditText editText)
    {
        font = Typeface.createFromAsset(ctx.getAssets(),fontname);
        editText.setTypeface(font);
    }
}

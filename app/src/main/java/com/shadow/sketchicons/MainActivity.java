package com.shadow.sketchicons;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    int dp(float v) { return (int)(v * getResources().getDisplayMetrics().density + .5f); }
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        getWindow().setStatusBarColor(Color.BLACK);
        getWindow().setNavigationBarColor(Color.BLACK);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(24),dp(32),dp(24),dp(24));
        root.setBackgroundColor(Color.rgb(5,5,5));
        TextView title = new TextView(this);
        title.setText("SHADOW SKETCH");
        title.setTextColor(Color.WHITE); title.setTextSize(27);
        title.setTypeface(Typeface.create("sans-serif-condensed",Typeface.BOLD));
        root.addView(title);
        TextView accent = new TextView(this);
        accent.setText("HAND-DRAWN • MONOCHROME / RED");
        accent.setTextColor(Color.rgb(240,74,45)); accent.setTextSize(11);
        accent.setPadding(0,dp(8),0,dp(22)); root.addView(accent);
        TextView body = new TextView(this);
        body.setText("A dark, sketch-inspired icon concept for your anime wallpaper.\n\nThis preview app is offline and requests no permissions.\n\nNext: add the icon-pack resources and validate Niagara's icon-pack support before using it as a launcher pack.");
        body.setTextColor(Color.rgb(220,220,220)); body.setTextSize(15);
        body.setLineSpacing(dp(5),1f); root.addView(body);
        TextView sample = new TextView(this);
        sample.setText("✎   ◉   ⌁   ⌂   ◇   ⚙");
        sample.setTextColor(Color.WHITE); sample.setTextSize(28);
        sample.setGravity(Gravity.CENTER); sample.setPadding(0,dp(36),0,dp(36));
        root.addView(sample);
        setContentView(root);
    }
}

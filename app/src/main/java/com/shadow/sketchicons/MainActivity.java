package com.shadow.sketchicons;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.ActivityNotFoundException;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
    int dp(float v) { return (int)(v * getResources().getDisplayMetrics().density + .5f); }

    private void applyToNiagara() {
        Intent intent = new Intent("bitpit.launcher.APPLY_ICONS");
        intent.setPackage("bitpit.launcher");
        intent.putExtra("packageName", getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Open Niagara Launcher and choose Shadow Sketch from its icon settings.", Toast.LENGTH_LONG).show();
        }
    }

    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        getWindow().setStatusBarColor(Color.BLACK);
        getWindow().setNavigationBarColor(Color.BLACK);
        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(Color.rgb(5,5,5));
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(22),dp(28),dp(22),dp(24));
        scroll.addView(root);
        TextView title = new TextView(this);
        title.setText("SHADOW SKETCH");
        title.setTextColor(Color.WHITE); title.setTextSize(26);
        title.setTypeface(Typeface.create("sans-serif-condensed",Typeface.BOLD));
        root.addView(title);
        TextView accent = new TextView(this);
        accent.setText("HAND-DRAWN  •  MONOCHROME / RED");
        accent.setTextColor(Color.rgb(240,74,45)); accent.setTextSize(11);
        accent.setPadding(0,dp(6),0,dp(18)); root.addView(accent);
        TextView note = new TextView(this);
        note.setText("A rough sketch icon collection for a dark anime wallpaper. White pencil-like lines with restrained red marks. This app works offline and requests no permissions.");
        note.setTextColor(Color.rgb(205,205,205)); note.setTextSize(14);
        note.setLineSpacing(dp(3),1f); root.addView(note);

        Button apply = new Button(this);
        apply.setText("APPLY TO NIAGARA");
        apply.setAllCaps(false);
        apply.setTextColor(Color.WHITE);
        apply.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.rgb(150,28,28)));
        LinearLayout.LayoutParams applyLp = new LinearLayout.LayoutParams(-1, dp(52));
        applyLp.topMargin = dp(18);
        root.addView(apply, applyLp);
        apply.setOnClickListener(v -> applyToNiagara());

        TextView section = new TextView(this);
        section.setText("ICON PREVIEW"); section.setTextColor(Color.WHITE);
        section.setTypeface(Typeface.DEFAULT_BOLD); section.setTextSize(13);
        section.setPadding(0,dp(22),0,dp(8)); root.addView(section);
        String[] names = {"Phone","Messages","Camera","Chrome","YouTube","Instagram","Settings","Clock","Files","Contacts","Google","Gmail","GitHub","Play Store","ChatGPT","Music","WhatsApp","VS Code"};
        int[] ids = {R.drawable.ic_phone,R.drawable.ic_messages,R.drawable.ic_camera,R.drawable.ic_chrome,R.drawable.ic_youtube,R.drawable.ic_instagram,R.drawable.ic_settings,R.drawable.ic_clock,R.drawable.ic_files,R.drawable.ic_contacts,R.drawable.ic_google,R.drawable.ic_gmail,R.drawable.ic_github,R.drawable.ic_playstore,R.drawable.ic_chatgpt,R.drawable.ic_music,R.drawable.ic_whatsapp,R.drawable.ic_vscode};
        GridLayout grid = new GridLayout(this); grid.setColumnCount(3); root.addView(grid);
        for(int i=0;i<names.length;i++){
            LinearLayout cell = new LinearLayout(this); cell.setOrientation(LinearLayout.VERTICAL); cell.setGravity(Gravity.CENTER);
            cell.setPadding(dp(3),dp(10),dp(3),dp(10));
            ImageView image = new ImageView(this); image.setImageResource(ids[i]);
            cell.addView(image,new LinearLayout.LayoutParams(dp(56),dp(56)));
            TextView label = new TextView(this); label.setText(names[i]); label.setTextColor(Color.rgb(210,210,210));
            label.setTextSize(11); label.setGravity(Gravity.CENTER); label.setPadding(0,dp(5),0,0); cell.addView(label);
            GridLayout.LayoutParams lp = new GridLayout.LayoutParams(); lp.width=0; lp.columnSpec=GridLayout.spec(GridLayout.UNDEFINED,1f);
            grid.addView(cell,lp);
        }
        TextView foot = new TextView(this);
        foot.setText("If Niagara does not open its icon picker, use Niagara Settings > Themes > Edit Current Theme > App icons. This pack is still being tested on-device.");
        foot.setTextColor(Color.rgb(175,175,175)); foot.setTextSize(12); foot.setLineSpacing(dp(3),1f);
        foot.setPadding(0,dp(22),0,0); root.addView(foot);
        setContentView(scroll);
    }
}
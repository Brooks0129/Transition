package com.lsd.transition;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        View root = findViewById(R.id.root);
        Scene sceneColor1 = Scene.getSceneForLayout((ViewGroup) root, R.layout.color1, this);
        final Scene sceneColor2 = Scene.getSceneForLayout((ViewGroup) root, R.layout.color2, this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TransitionManager.go(sceneColor2, new ChangeColor());
            }
        }, 3000);
    }
}

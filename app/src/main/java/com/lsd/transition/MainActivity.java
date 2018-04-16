package com.lsd.transition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ViewGroup mSceneRoot;
    private Scene mScene1;
    private Scene mScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSceneRoot = findViewById(R.id.scene_root);
        Button button = findViewById(R.id.button);
        mScene1 = Scene.getSceneForLayout(mSceneRoot, R.layout.sence1, this);
        mScene2 = Scene.getSceneForLayout(mSceneRoot, R.layout.sence2, this);
        mScene1.setEnterAction(new Runnable() {
            @Override
            public void run() {
                Log.d("MyTransition", "mScene1 enter");
            }
        });
        mScene1.setExitAction(new Runnable() {
            @Override
            public void run() {
                Log.d("MyTransition", "mScene1 exit");
            }
        });
        mScene2.setEnterAction(new Runnable() {
            @Override
            public void run() {
                Log.d("MyTransition", "mScene2 enter");
            }
        });
        mScene2.setExitAction(new Runnable() {
            @Override
            public void run() {
                Log.d("MyTransition", "mScene2 exit");
            }
        });
        final boolean[] mCurrentSence1 = {true};
        final Transition changeBounds = new ChangeBounds();
        changeBounds.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {

            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyTransition", "click to change layout:" + (mCurrentSence1[0] ? "from Scene1 to Scene2" : "from Scene2 to Scene1"));
                TransitionManager.go(mCurrentSence1[0] ? mScene2 : mScene1, changeBounds);
                mCurrentSence1[0] = !mCurrentSence1[0];
            }
        });
    }

}

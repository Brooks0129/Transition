package com.lsd.transition;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.transition.Fade.IN;
import static android.transition.Fade.OUT;

public class SecondActivity extends AppCompatActivity {
    private TextView mLabelText;
    private ViewGroup mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mLabelText.isAttachedToWindow()){
                    TransitionManager.beginDelayedTransition(mRootView, new Fade(IN));
                    mRootView.addView(mLabelText);
                }else {
                    TransitionManager.beginDelayedTransition(mRootView, new Fade(OUT));
                    mRootView.removeView(mLabelText);
                }

            }
        });
        // Load the layout

        mLabelText = new TextView(this);
        mLabelText.setText("Label");
        mLabelText.setTextColor(Color.BLACK);
        mLabelText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        mRootView = findViewById(R.id.mainLayout);


    }
}

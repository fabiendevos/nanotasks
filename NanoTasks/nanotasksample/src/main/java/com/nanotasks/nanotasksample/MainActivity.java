package com.nanotasks.nanotasksample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nanotasks.BackgroundWork;
import com.nanotasks.Completion;
import com.nanotasks.Tasks;

import java.util.concurrent.TimeUnit;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgress();
                Tasks.executeInBackground(v.getContext(), new BackgroundWork<String>() {
                    @Override
                    public String doInBackground() throws Exception {
                        final int DELAY = 3;
                        Thread.sleep(TimeUnit.SECONDS.toMillis(DELAY));
                        return "Worked hard for " + DELAY + " seconds";
                    }
                }, new Completion<String>() {
                    @Override
                    public void onSuccess(Context context, String result) {
                        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
                        hideProgress();
                    }

                    @Override
                    public void onError(Context context, Exception e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                        hideProgress();
                    }
                });
            }
        });
    }

    private void showProgress() {
        findViewById(R.id.progress).setVisibility(View.VISIBLE);
        findViewById(R.id.button).setVisibility(View.INVISIBLE);
    }
    private void hideProgress() {
        findViewById(R.id.progress).setVisibility(View.INVISIBLE);
        findViewById(R.id.button).setVisibility(View.VISIBLE);
    }
}

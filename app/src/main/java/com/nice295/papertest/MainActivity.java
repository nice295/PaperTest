package com.nice295.papertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton;
    private TextView mTvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Paper.init(this); //khlee

        mButton = (Button)findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mTvText = (TextView)findViewById(R.id.textView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String name = Paper.book().read(Constants.NAME, "No name");
        Integer age = Paper.book().read(Constants.AGE, 0);
        mTvText.setText(name + ", " + age);
    }


    @Override
    protected void onDestroy() {
        //Paper.book().destroy(); //khlee
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        Paper.book().write(Constants.NAME, "Kyuho");
        Paper.book().write(Constants.AGE, 38);

        startActivity(new Intent(this, DetailActivity.class));
    }
}


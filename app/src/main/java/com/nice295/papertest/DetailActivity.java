package com.nice295.papertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.paperdb.Paper;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton;
    private EditText mEtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        mButton = (Button)findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mEtText = (EditText)findViewById(R.id.editText);

        //khlee
        String name = Paper.book().read("name");
        Integer age = Paper.book().read("age");
        mEtText.setText(name + ", " + age);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        Paper.book().write(Constants.NAME, mEtText.getText().toString());
        Paper.book().write(Constants.AGE, 20);
        finish();
    }
}

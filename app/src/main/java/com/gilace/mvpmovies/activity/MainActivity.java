package com.gilace.mvpmovies.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gilace.mvpmovies.R;
import com.gilace.mvpmovies.mvp.MainActivityVP;
import com.gilace.mvpmovies.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityVP.View, View.OnClickListener {

    Button searchbtn;
    EditText searchTxt;
    MainActivityPresenter presenter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchbtn = findViewById(R.id.search_btn);
        searchbtn.setOnClickListener(this);
        searchTxt = findViewById(R.id.search_text);
        presenter = new MainActivityPresenter(this);

        presenter.getFragment(0,"");


    }

    @Override
    public void setFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .commit();
    }

    @Override
    public Activity getActivity() {
        return null;
    }

    @Override
    public Context getAppContext() {
        return this;
    }

    @Override
    public void onClick(View view) {
        presenter.getFragment(1,searchTxt.getText().toString());
    }
}

package com.wxl.rxjet;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.wxl.gainjet.JetBaseActivity;
import com.wxl.gainjet.PresenterFactory;

public class MainActivity extends JetBaseActivity {

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = PresenterFactory.create(this, MainPresenter.class);
    }

    public void onTextClick(View view) {
        presenter.setTextView((TextView) view);
    }
}

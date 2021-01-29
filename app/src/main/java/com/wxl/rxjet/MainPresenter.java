package com.wxl.rxjet;

import android.widget.TextView;

import androidx.lifecycle.Observer;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.wxl.gainjet.AbsPresenter;
import com.wxl.gainjet.ViewModelFactory;

/**
 * create file time : 2021/1/29
 * create user : wxl
 * subscribe :
 */
public class MainPresenter extends AbsPresenter {

    TextView mTextView;
    MainViewModel mMainViewModel;

    @Override
    public void onCreated(RxAppCompatActivity context, Object... args) {
        super.onCreated(context, args);
        mMainViewModel = ViewModelFactory.create(context, MainViewModel.class, new Observer<String>() {
            @Override
            public void onChanged(String data) {
                mTextView.setText(data);
            }
        });
    }

    public void setTextView(TextView mTextView) {
        this.mTextView = mTextView;
        mMainViewModel.refresh("ajdhbcakudsbcvadusfbc");
    }
}

package com.wxl.gainjet;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * create file time : 2021/1/29
 * create user : wxl
 * subscribe :
 */
public class ViewModelFactory {

    private RxAppCompatActivity mRxAppCompatActivity;

    private ViewModelFactory(RxAppCompatActivity mRxAppCompatActivity) {
        this.mRxAppCompatActivity = mRxAppCompatActivity;
    }

    private <T extends AbsViewModel> T observer(Class<T> viewModel, Observer observer) {
        final T t = new ViewModelProvider(mRxAppCompatActivity, new ViewModelProvider.NewInstanceFactory()).get(viewModel);
        if(observer != null ) {
            t.getLiveData().observe(mRxAppCompatActivity, observer);
        }
        t.setOnClearedCallback(new AbsViewModel.OnViewModelClearedCallback() {
            @Override
            public void onCleared(AbsLiveData data) {
                if(observer != null) {
                    data.removeObservers(mRxAppCompatActivity);
                }
                mRxAppCompatActivity = null;
            }
        });
        return t;
    }


    /**
     * 创建一个ViewModel
     * @param context
     * @param viewModel
     * @param observer
     * @param <T>
     * @return
     */
    public static <T extends AbsViewModel> T create(RxAppCompatActivity context, Class<T> viewModel, Observer observer) {
        return new ViewModelFactory(context).observer(viewModel, observer);
    }

    /**
     * 创建一个ViewModel
     * @param context
     * @param viewModel
     * @param <T>
     * @return
     */
    public static <T extends AbsViewModel> T create(RxAppCompatActivity context, Class<T> viewModel) {
        return new ViewModelFactory(context).observer(viewModel, null);
    }
}


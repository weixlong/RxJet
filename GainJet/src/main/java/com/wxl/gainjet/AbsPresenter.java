package com.wxl.gainjet;


import androidx.annotation.CallSuper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * create file time : 2021/1/29
 * create user : wxl
 * subscribe :
 */
public abstract class AbsPresenter extends ViewModel implements LifecycleObserver {

    private RxAppCompatActivity mContext;

    protected String TAG = AbsPresenter.class.getSimpleName();

    /**
     * 创建Presenter后调用
     *
     * @param context
     */
    @CallSuper
    public void onCreated(RxAppCompatActivity context,Object... args) {
        mContext = context;
        TAG = getClass().getSimpleName();
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Loog.d(TAG, "onCreate");
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Loog.d(TAG, "onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Loog.d(TAG, "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Loog.d(TAG, "onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Loog.d(TAG, "onStop");
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @CallSuper
    public void onDestroy() {
        Loog.d(TAG, "onDestroy");
        if (mContext != null) {
            mContext.getLifecycle().removeObserver(this);
            mContext = null;
        }
    }


}

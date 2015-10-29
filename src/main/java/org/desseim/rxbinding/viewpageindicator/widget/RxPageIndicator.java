package org.desseim.rxbinding.viewpageindicator.widget;

import android.view.View;

import com.viewpagerindicator.PageIndicator;

import rx.Observable;

public class RxPageIndicator {
    public static  <T extends View & PageIndicator> Observable<PageIndicatorPageChangeEvent<T>> pageChangeEvents(T view) {
        return Observable.create(new PageIndicatorPageChangeOnSubscribe<>(view));
    }
}

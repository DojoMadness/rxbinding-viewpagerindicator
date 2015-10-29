package org.desseim.rxbinding.viewpageindicator.widget;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.jakewharton.rxbinding.internal.MainThreadSubscription;
import com.viewpagerindicator.PageIndicator;

import rx.Observable;
import rx.Subscriber;

import static com.jakewharton.rxbinding.internal.Preconditions.checkUiThread;

public class PageIndicatorPageChangeOnSubscribe <T extends View & PageIndicator> implements Observable.OnSubscribe<PageIndicatorPageChangeEvent<T>> {
    private final T view;

    public PageIndicatorPageChangeOnSubscribe(final T view) {
        this.view = view;
    }

    @Override
    public void call(final Subscriber<? super PageIndicatorPageChangeEvent<T>> subscriber) {
        checkUiThread();

        final ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(PageIndicatorPageScrollEvent.create(view, position, positionOffset, positionOffsetPixels));
                }
            }

            @Override
            public void onPageSelected(final int position) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(PageIndicatorPageSelectionEvent.create(view, position));
                }
            }

            @Override
            public void onPageScrollStateChanged(final int state) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(PageIndicatorPageScrollStateChangeEvent.create(view, state));
                }
            }
        };

        subscriber.add(new MainThreadSubscription() {
            @Override
            protected void onUnsubscribe() {
                view.setOnPageChangeListener(null);
            }
        });

        view.setOnPageChangeListener(listener);
    }
}

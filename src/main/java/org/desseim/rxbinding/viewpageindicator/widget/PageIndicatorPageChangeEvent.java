package org.desseim.rxbinding.viewpageindicator.widget;

import android.support.annotation.NonNull;
import android.view.View;

import com.jakewharton.rxbinding.view.ViewEvent;
import com.viewpagerindicator.PageIndicator;

public abstract class PageIndicatorPageChangeEvent <T extends View & PageIndicator> extends ViewEvent<T> {
    protected PageIndicatorPageChangeEvent(@NonNull final T view) {
        super(view);
    }
}

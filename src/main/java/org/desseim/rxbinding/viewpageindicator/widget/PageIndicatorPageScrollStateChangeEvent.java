package org.desseim.rxbinding.viewpageindicator.widget;

import android.support.annotation.NonNull;
import android.view.View;

import com.viewpagerindicator.PageIndicator;

public class PageIndicatorPageScrollStateChangeEvent<T extends View & PageIndicator> extends PageIndicatorPageChangeEvent<T> {
    public static <T extends View & PageIndicator> PageIndicatorPageScrollStateChangeEvent<T> create(T view, final int state) {
        return new PageIndicatorPageScrollStateChangeEvent<>(view, state);
    }

    private final int state;

    private PageIndicatorPageScrollStateChangeEvent(@NonNull final T view, final int state) {
        super(view);

        this.state = state;
    }

    public int getState() {
        return state;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + view().hashCode();
        result = result * 37 + state;
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof PageIndicatorPageScrollStateChangeEvent)) return false;

        final PageIndicatorPageScrollStateChangeEvent<?> other = (PageIndicatorPageScrollStateChangeEvent<?>)o;

        return other.view() == view() && other.getState() == state;
    }

    @Override
    public String toString() {
        return "PageIndicatorPageScrollEvent{" +
                "state=" + state +
                ", view=" + view() +
                '}';
    }
}

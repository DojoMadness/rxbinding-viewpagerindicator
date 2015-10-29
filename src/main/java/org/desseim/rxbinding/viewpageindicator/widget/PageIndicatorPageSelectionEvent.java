package org.desseim.rxbinding.viewpageindicator.widget;

import android.support.annotation.NonNull;
import android.view.View;

import com.viewpagerindicator.PageIndicator;

public class PageIndicatorPageSelectionEvent<T extends View & PageIndicator> extends PageIndicatorPageChangeEvent<T> {
    public static <T extends View & PageIndicator> PageIndicatorPageSelectionEvent<T> create(T view, final int position) {
        return new PageIndicatorPageSelectionEvent<>(view, position);
    }

    private final int position;

    private PageIndicatorPageSelectionEvent(@NonNull final T view, final int position) {
        super(view);

        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + view().hashCode();
        result = result * 37 + position;
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof PageIndicatorPageSelectionEvent)) return false;

        final PageIndicatorPageSelectionEvent<?> other = (PageIndicatorPageSelectionEvent<?>)o;

        return other.view() == view() && other.getPosition() == position;
    }

    @Override
    public String toString() {
        return "PageIndicatorPageScrollEvent{" +
                "position=" + position +
                ", view=" + view() +
                '}';
    }
}

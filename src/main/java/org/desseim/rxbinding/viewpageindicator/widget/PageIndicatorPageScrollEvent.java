package org.desseim.rxbinding.viewpageindicator.widget;

import android.support.annotation.NonNull;
import android.view.View;

import com.viewpagerindicator.PageIndicator;

public class PageIndicatorPageScrollEvent<T extends View & PageIndicator> extends PageIndicatorPageChangeEvent<T> {
    public static <T extends View & PageIndicator> PageIndicatorPageScrollEvent<T> create(T view, final int position, final float positionOffset, final int positionOffsetPixels) {
        return new PageIndicatorPageScrollEvent<>(view, position, positionOffset, positionOffsetPixels);
    }

    private final int position;
    private final float positionOffset;
    private final int positionOffsetPixels;

    private PageIndicatorPageScrollEvent(@NonNull final T view, final int position, final float positionOffset, final int positionOffsetPixels) {
        super(view);

        this.position = position;
        this.positionOffset = positionOffset;
        this.positionOffsetPixels = positionOffsetPixels;
    }

    public int getPosition() {
        return position;
    }

    public float getPositionOffset() {
        return positionOffset;
    }

    public int getPositionOffsetPixels() {
        return positionOffsetPixels;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + view().hashCode();
        result = result * 37 + position;
        result = result * 37 + (positionOffset != +0.0f ? Float.floatToIntBits(positionOffset) : 0);
        result = result * 37 + positionOffsetPixels;
        return result;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof PageIndicatorPageScrollEvent)) return false;

        final PageIndicatorPageScrollEvent<?> other = (PageIndicatorPageScrollEvent<?>)o;

        return other.view() == view() &&
                position == other.getPosition() &&
                Float.compare(other.getPositionOffset(), positionOffset) == 0 &&
                positionOffsetPixels == other.getPositionOffsetPixels();
    }

    @Override
    public String toString() {
        return "PageIndicatorPageScrollEvent{" +
                "position=" + position +
                ", positionOffset=" + positionOffset +
                ", positionOffsetPixels=" + positionOffsetPixels +
                ", view=" + view() +
                '}';
    }
}

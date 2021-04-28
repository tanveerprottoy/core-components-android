package com.tanveershafeeprottoy.corecomponents.components;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemSpaceDecoration
    extends RecyclerView.ItemDecoration {
    private final int space;

    public ItemSpaceDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(
        @NonNull Rect outRect,
        @NonNull View view,
        @NonNull RecyclerView parent,
        @NonNull RecyclerView.State state
    ) {
        outRect.set(
            space,
            space,
            space,
            space
        );
    }
}

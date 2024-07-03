package com.ultimobiletools.commons.interfaces;

import com.ultimobiletools.commons.adapters.CustomRecyclerViewAdapter;

public interface ItemTouchHelperContract {

    void onRowMoved(int fromPosition, int toPosition);

    void onRowSelected(CustomRecyclerViewAdapter.ViewHolder myViewHolder);

    void onRowClear(CustomRecyclerViewAdapter.ViewHolder myViewHolder);
}

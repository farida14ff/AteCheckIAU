package com.example.electrionicsproject.mainChekersList;

import com.example.electrionicsproject.adaptes.CheckerAdapter;
import com.example.electrionicsproject.models.Checker;

import java.util.ArrayList;

public interface CheckersListContract {

    interface CheckersListView {
        void hideProgressBar();
        void showStudentsTableActivity(Checker checker);
        void stopRefreshingOrders();
        void showError();
        void showEmptyView();
    }

    interface CheckersListPresenter {
    }

    interface OnItemClickListener  {
        void onItemClick(Checker checker);
    }


}

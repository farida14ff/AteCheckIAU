package com.example.electrionicsproject.mainChekersList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.electrionicsproject.data.CHeckersRoomDataBase;
import com.example.electrionicsproject.data.CheckersDao;
import com.example.electrionicsproject.models.Checker;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CheckersListPresenter implements CheckersListContract.CheckersListPresenter {

    CheckersListContract.CheckersListView checkersListView;


    public CheckersListPresenter(CheckersListContract.CheckersListView checkersListView) {
        this.checkersListView = checkersListView;
    }





//
//
//        Call<List<Checker>> call = service.getOrdersForType(BaseActivity.authToken);
//        call.enqueue(new Callback<List<Order>>() {
//            @Override
//            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
//                if (response.body() != null && response.body().size() > 0) {
//                    checkersListView.setOrders(response.body());
//                    checkersListView.hideProgressBar();
//                } else {
//                    checkersListView.setOrders(response.body());
//                    checkersListView.showEmptyView();
//                }
//                checkersListView.stopRefreshingOrders();
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Checker>> call, Throwable t) {
//                checkersListView.showError();
//            }
//        });
//    }
}

package com.example.electrionicsproject.mainChekersList;

import android.content.Intent;
import android.os.Bundle;

import com.example.electrionicsproject.main.BaseActivity;
import com.example.electrionicsproject.main.BaseContract;
import com.example.electrionicsproject.R;
import com.example.electrionicsproject.adaptes.CheckerAdapter;
import com.example.electrionicsproject.data.CHeckersRoomDataBase;
import com.example.electrionicsproject.data.CheckersDao;
import com.example.electrionicsproject.models.Checker;
import com.example.electrionicsproject.networking.DB;
import com.example.electrionicsproject.newCheckerAdding.AddNewCheckerActivity;
import com.example.electrionicsproject.studentsTable.StudentsTableActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class CheckersListActivity extends BaseActivity implements CheckersListContract.CheckersListView {

    private CheckersListContract.CheckersListPresenter presenter;
    private RecyclerView recyclerView;
    ArrayList<Checker> checkers = new ArrayList<>();
    //    private ProgressBar progressBar;
//    private SwipeRefreshLayout swipeRefreshLayout;
    public CheckerAdapter adapter;
    private CheckersDao dao;
    private CHeckersRoomDataBase db;

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkers_list_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = CHeckersRoomDataBase.getDatabase(this);
        dao = db.checkersDao();

        checkers = (ArrayList<Checker>) dao.getAllCheckers();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckersListActivity.this, AddNewCheckerActivity.class);
                startActivity(intent);
            }
        });



        //progressBar = findViewById(R.id.progress_bar);
        //initSwipeRefreshLayout();
        initRecyclerViewWithAdapter();
    }


//    private void initSwipeRefreshLayout() {
//        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
//        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary));
//        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                //presenter.populateOrders();
//            }
//        });
//    }


    private void initRecyclerViewWithAdapter() {

        checkers.add(new Checker(name));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (adapter == null) {
            recyclerView.setVisibility(View.GONE);
            //progressBar.setVisibility(CheckersListView.VISIBLE);
            adapter = new CheckerAdapter(new BaseContract.OnItemClickListener() {
                @Override
                public void onItemClick(Checker checker) {
                    showStudentsTableActivity(checker);
                }
            });
            presenter = new CheckersListPresenter(this);
            //presenter.populateOrders();
        }

        adapter.setValues(DB.getChekers());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }


    @Override
    public void hideProgressBar() {
        //progressBar.setVisibility(CheckersListView.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        //emptyView.setVisibility(CheckersListView.GONE);
    }

    @Override
    public void showStudentsTableActivity(Checker checker) {
        Intent intent = new Intent(this, StudentsTableActivity.class);
        intent.putExtra("checker", (Parcelable) checker);
        startActivityForResult(intent, 100);
    }

    @Override
    public void stopRefreshingOrders() {
        //swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Невозможно получить список", Toast.LENGTH_LONG).show();
        //swipeRefreshLayout.setRefreshing(false);
        adapter.setValues(null);
        //progressBar.setVisibility(CheckersListView.GONE);
//        emptyView.setVisibility(CheckersListView.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showEmptyView() {

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.example.lenovo.pagination;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

 RecyclerView recyclerview;
 RecyclerView.LayoutManager layoutManager;
 ProgressBar progressBar;
 RecyclerAdapter adapter;
 ArrayList<String> mlist;
 Boolean isScrolling =false;
 int currentitem,tottal,scrolledout;

 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        progressBar=(ProgressBar)findViewById(R.id.progress);

        recyclerview.setHasFixedSize(false);

        String s[]={"rtwert","reytwey","trywetry","ywrety","wyrwetry","reyw","rywery","yrwery","rywry","reywy","rywe","atqre"};

        mlist=new ArrayList<>(Arrays.asList(s));

        adapter=new RecyclerAdapter(this,mlist);

        recyclerview.setAdapter(adapter);

        layoutManager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);

// Adding Scroll Listener in the recycler view
        recyclerview.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){

                    isScrolling=true;
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentitem=layoutManager.getChildCount();
                tottal=layoutManager.getItemCount();

                scrolledout=((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();


                if(isScrolling && (currentitem+scrolledout==tottal)){
                    isScrolling=false;
                    dummyDataFetc();
                }


            }
        });

    }
    private void dummyDataFetc() {
        progressBar.setVisibility(View.VISIBLE);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<3;i++){
                    mlist.add(Math.floor(Math.random()*1000)+"");
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }
        }, 3000);

    }

}

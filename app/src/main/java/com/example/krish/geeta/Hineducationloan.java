package com.example.krish.geeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Hineducationloan extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference myref;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hineducationloan);
        progressBar=(ProgressBar)findViewById(R.id.hineducationloanprogressbar);
        recyclerView=(RecyclerView)findViewById(R.id.hineducationloanrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myref= FirebaseDatabase.getInstance().getReference().child("Hindi educationloan");
        progressBar.setVisibility(View.VISIBLE);
        FirebaseRecyclerAdapter<hineducationloan_blog,Hineducationloan.BlogViewHolder> recyclerAdapter=new FirebaseRecyclerAdapter<hineducationloan_blog,BlogViewHolder>(
                hineducationloan_blog.class,
                R.layout.hineducationloan_individual,
                Hineducationloan.BlogViewHolder.class,
                myref
        ) {
            @Override
            protected void populateViewHolder(Hineducationloan.BlogViewHolder viewHolder, hineducationloan_blog model, int position) {
                progressBar.setVisibility(View.GONE);
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDescription(model.getDescription());

            }
        };
        recyclerView.setAdapter(recyclerAdapter);
    }
    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView textView_title;
        //TextView textView_decription;
        ReadMoreTextView textView_decription;

        public BlogViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
            textView_title = (TextView)itemView.findViewById(R.id.hineducationloantitle);
            //textView_decription = (TextView) itemView.findViewById(R.id.description);
            textView_decription = (ReadMoreTextView) itemView.findViewById(R.id.hineducationloandescription);

        }
        public void setTitle(String title)
        {
            textView_title.setText(title+"");
        }
        public void setDescription(String description)
        {
            textView_decription.setText(description);
        }

    }
    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
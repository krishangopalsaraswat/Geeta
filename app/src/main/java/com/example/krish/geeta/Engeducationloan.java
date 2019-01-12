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

public class Engeducationloan extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference myref;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engeducationloan);
        progressBar=(ProgressBar)findViewById(R.id.engeducationloanprogressbar);
        recyclerView=(RecyclerView)findViewById(R.id.engeducationloanrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myref= FirebaseDatabase.getInstance().getReference().child("English educationloan");
        progressBar.setVisibility(View.VISIBLE);
        FirebaseRecyclerAdapter<Engeducationloan_blog,BlogViewHolder> recyclerAdapter=new FirebaseRecyclerAdapter<Engeducationloan_blog,Engeducationloan.BlogViewHolder>(
                Engeducationloan_blog.class,
                R.layout.engeducationloan_individual,
                Engeducationloan.BlogViewHolder.class,
                myref
        ) {
            @Override
            protected void populateViewHolder(Engeducationloan.BlogViewHolder viewHolder, Engeducationloan_blog model, int position) {
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
            textView_title = (TextView)itemView.findViewById(R.id.engeducationloantitle);
            //textView_decription = (TextView) itemView.findViewById(R.id.description);
            textView_decription = (ReadMoreTextView) itemView.findViewById(R.id.engeducationloandescription);

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
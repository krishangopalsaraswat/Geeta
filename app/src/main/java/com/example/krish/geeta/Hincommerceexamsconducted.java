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

public class Hincommerceexamsconducted extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference myref;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hincommerceexamsconducted);
        progressBar=(ProgressBar)findViewById(R.id.hincommerceceprogressbar);
        recyclerView=(RecyclerView)findViewById(R.id.hincommercecerecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myref= FirebaseDatabase.getInstance().getReference().child("Hindi commerce conducted exams");
        progressBar.setVisibility(View.VISIBLE);
        FirebaseRecyclerAdapter<Hincommercece_blog,BlogViewHolder> recyclerAdapter=new FirebaseRecyclerAdapter<Hincommercece_blog,Hincommerceexamsconducted.BlogViewHolder>(
                Hincommercece_blog.class,
                R.layout.hincommercece_individual,
                Hincommerceexamsconducted.BlogViewHolder.class,
                myref
        ) {
            @Override
            protected void populateViewHolder(Hincommerceexamsconducted.BlogViewHolder viewHolder, Hincommercece_blog model, int position) {
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
            textView_title = (TextView)itemView.findViewById(R.id.hincommercecetitle);
            //textView_decription = (TextView) itemView.findViewById(R.id.description);
            textView_decription = (ReadMoreTextView) itemView.findViewById(R.id.hincommercecedescription);

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

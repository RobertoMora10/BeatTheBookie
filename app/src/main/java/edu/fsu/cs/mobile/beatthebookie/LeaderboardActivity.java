package edu.fsu.cs.mobile.beatthebookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LeaderboardActivity extends AppCompatActivity {
    private ListView list;
    private Button button;
    private  CustomAdapter mAdapter;
    DatabaseReference databaseBet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        databaseBet = FirebaseDatabase.getInstance().getReference("bets");
        list = (ListView) findViewById(R.id.listview);
        button=(Button) findViewById(R.id.button2);
        mAdapter = new CustomAdapter(LeaderboardActivity.this, R.layout.row);
        list.setAdapter(mAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LeaderboardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseBet.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //have to clear the listview
                for(DataSnapshot betSnapshot: dataSnapshot.getChildren())
                {
                    Bet bet=betSnapshot.getValue(Bet.class);
                    mAdapter.add(bet);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

package edu.fsu.cs.mobile.beatthebookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LeaderboardActivity extends AppCompatActivity {
    private ListView list;
    private Button button;
    private  CustomAdapter mAdapter;
    private Spinner mSpinner;
    DatabaseReference databaseBet;
    SimpleDateFormat dateFormat;
    Date date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        databaseBet = FirebaseDatabase.getInstance().getReference("bets");
        list = (ListView) findViewById(R.id.listview);
        button=(Button) findViewById(R.id.button2);
        mAdapter = new CustomAdapter(LeaderboardActivity.this, R.layout.row);
        mSpinner=(Spinner)findViewById(R.id.spinner);
        list.setAdapter(mAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LeaderboardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {


                if(position==0)
                {
                    //sort by votes
                }

                else if(position==1)
                {
                    //sort by earliest
                }

                else
                {
                    //sort by expiration date
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),
                        "You didn't select anything" ,
                        Toast.LENGTH_SHORT).show();
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
                    try {
                         date =dateFormat.parse(bet.getValidUntil());
                         //Toast.makeText(LeaderboardActivity.this,date.toString(),Toast.LENGTH_LONG).show();

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Date currentTime= Calendar.getInstance().getTime();
                    Toast.makeText(LeaderboardActivity.this,currentTime.toString(),Toast.LENGTH_LONG).show();

                    if(date.after(currentTime))
                        mAdapter.add(bet);
                    // Toast.makeText(LeaderboardActivity.this,bet.getID(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

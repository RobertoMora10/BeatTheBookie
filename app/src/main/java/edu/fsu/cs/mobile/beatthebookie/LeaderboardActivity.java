package edu.fsu.cs.mobile.beatthebookie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class LeaderboardActivity extends AppCompatActivity {
    private ListView list;
    private Button button;
    private  CustomAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        list = (ListView) findViewById(R.id.listview);
        button=(Button) findViewById(R.id.button2);
        mAdapter = new CustomAdapter(LeaderboardActivity.this, R.layout.row);
        list.setAdapter(mAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bet bet= new Bet();
                mAdapter.add(bet);
            }
        });
    }
}

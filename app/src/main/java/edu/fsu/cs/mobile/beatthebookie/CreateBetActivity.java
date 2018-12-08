package edu.fsu.cs.mobile.beatthebookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateBetActivity extends AppCompatActivity {

    EditText mBet;
    EditText mPayout;
    EditText mWebsite;
    Button button;

    DatabaseReference databaseBet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bet);
        mBet=(EditText) findViewById(R.id.BetEdit);
        mPayout=(EditText) findViewById(R.id.PayoutEdit);
        mWebsite=(EditText) findViewById(R.id.WebsiteEdit);
        button=(Button) findViewById(R.id.AddBetButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bet = mBet.getText().toString();
                String payout =mPayout.getText().toString();
                String website= mWebsite.getText().toString();

                databaseBet=FirebaseDatabase.getInstance().getReference("bets");


                if(!TextUtils.isEmpty(bet)){
                    String id=databaseBet.push().getKey();
                    Bet bet1= new Bet(id,bet,Double.valueOf(payout),website);
                    databaseBet.child(id).setValue(bet1);
                    Intent intent= new Intent(CreateBetActivity.this,LeaderboardActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(CreateBetActivity.this, "Enter a bet",  Toast.LENGTH_LONG).show();
                }

                if(!TextUtils.isEmpty(payout)){

                }
                else
                {
                    Toast.makeText(CreateBetActivity.this, "Enter a payout",  Toast.LENGTH_LONG).show();
                }


                if(!TextUtils.isEmpty(website)){

                }
                else
                {
                    Toast.makeText(CreateBetActivity.this, "Enter a website",  Toast.LENGTH_LONG).show();
                }



            }
        });

    }
}

package edu.fsu.cs.mobile.beatthebookie;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateBetActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{

    EditText mBet;
    EditText mPayout;
    EditText mWebsite;
    Button button;
    Button DateButton;

    DatabaseReference databaseBet;

    int day, month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bet);
        mBet=(EditText) findViewById(R.id.BetEdit);
        mPayout=(EditText) findViewById(R.id.PayoutEdit);
        mWebsite=(EditText) findViewById(R.id.WebsiteEdit);
        button=(Button) findViewById(R.id.AddBetButton);
        DateButton=(Button) findViewById(R.id.DateButton);

        DateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

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
                    Toast.makeText(CreateBetActivity.this,bet1.getID(),Toast.LENGTH_LONG).show();

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

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

    }
}

package edu.fsu.cs.mobile.beatthebookie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateBetActivity extends AppCompatActivity {

    EditText mBet;
    EditText mPayout;
    EditText mWebsite;
    Button button;

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
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World!");
            }
        });

    }
}

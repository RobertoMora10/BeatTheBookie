package edu.fsu.cs.mobile.beatthebookie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseUser currentUser;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();



    }

    @Override
    protected void onStart() {
        super.onStart();

        if (currentUser == null) {
            Intent intent =   new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        else
        {

        }
    }
}

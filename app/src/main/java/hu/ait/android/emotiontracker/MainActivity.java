package hu.ait.android.emotiontracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionButton();

        feelButton();
    }

    private void actionButton() {
        Button btnAction = (Button) findViewById(R.id.btnAction);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(MainActivity.this, ActionActivity.class);
                startActivity(newIntent);
            }
        });
    }


    private void feelButton() {

        Button btnFeel = (Button) findViewById(R.id.btnFeel);
        btnFeel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(MainActivity.this, FeelActivity.class);
                startActivity(newIntent);
            }
        });
    }

}

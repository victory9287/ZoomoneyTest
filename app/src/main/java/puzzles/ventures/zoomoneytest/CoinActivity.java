package puzzles.ventures.zoomoneytest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CoinActivity extends AppCompatActivity {

    String phone;
    TextView phoneView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);

        init();
    }

    public void init() {
        Intent intent = getIntent();
        phone = intent.getStringExtra("PHONE_NUM");
        phoneView = (TextView) findViewById(R.id.coinPhoneNumber);
        phoneView.setText(phone);
    }

    public void viewClick(View view) {
        finish();
    }
}

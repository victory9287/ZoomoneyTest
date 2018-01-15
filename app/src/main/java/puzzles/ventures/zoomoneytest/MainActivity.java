package puzzles.ventures.zoomoneytest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    int[] imageIDs = {R.drawable.starbucks, R.drawable.puzzels};

    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        imageView = (ImageView) findViewById(R.id.imageView);
        handler = new Handler();
        runnable = new Runnable() {
            int i = 0;
            @Override
            public void run() {
                imageView.setImageResource(imageIDs[i]);
                i++;
                if (i > imageIDs.length - 1)
                    i = 0;
                handler.postDelayed(this, 3000);
            }
        };
        handler.post(runnable);
    }

    public void viewClick(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }
}

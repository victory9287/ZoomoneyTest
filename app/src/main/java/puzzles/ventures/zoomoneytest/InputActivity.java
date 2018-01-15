package puzzles.ventures.zoomoneytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {

    TextView phoneView;
    String phone;

    int[] btnIDs = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        init();
    }

    public void init() {

        phone = "";
        phoneView = (TextView) findViewById(R.id.inputPhoneNumber);
    }

    public void btnClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnOK:
                Intent intent = new Intent(InputActivity.this, CoinActivity.class);
                intent.putExtra("PHONE_NUM", "010 - "+phone);
                startActivity(intent);
                finish();
                break;
            case R.id.btnDelete:
                if (phone.length() <= 0)
                    break;
                if (phone.length() == 8) {
                    phone = phone.substring(0, 4);
                } else {
                    phone = phone.substring(0, phone.length()-1);
                }
                phoneView.setText(phone);
                Log.d("phoneCheck", phone+", "+String.valueOf(phone.length()));
                break;
            default: // 숫자 버튼의 경우
                if (phone.length() == 4)
                    phone += " - ";
                for (int i = 0; i < 10; i++) {
                    if (id == btnIDs[i]) {
                        phone += String.format("%d", i);
                        Log.d("phoneCheck1", phone+", "+String.valueOf(phone.length()));
                        phoneView.setText(phone);
                        break;
                    }
                }
                Log.d("phoneCheck", phone+", "+String.valueOf(phone.length()));
                break;
        }

    }
}

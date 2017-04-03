package ro.pub.cs.systems.eim.practicaltest01var04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private EditText editText = null;
    private Button topLeft = null;
    private Button topRight = null;
    private Button center = null;
    private Button bottomLeft = null;
    private Button bottomRight = null;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private Integer nrClicks = 0;

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String current = editText.getText().toString();
            switch(view.getId()) {
                case R.id.top_left:
                    nrClicks++;
                    if (current.equals("")) {
                        editText.setText("Top Left");
                    } else {
                        editText.setText(current + ",Top Left");
                    }
                    break;
                case R.id.top_right:
                    nrClicks++;
                    if (current.equals("")) {
                        editText.setText("Top Right");
                    } else {
                        editText.setText(current + ",Top Right");
                    }
                    break;
                case R.id.bottom_right:
                    nrClicks++;
                    if (current.equals("")) {
                        editText.setText("Bottom Right");
                    } else {
                        editText.setText(current + ",Bottom Right");
                    }
                    break;
                case R.id.bottom_left:
                    nrClicks++;
                    if (current.equals("")) {
                        editText.setText("Bottom Left");
                    } else {
                        editText.setText(current + ",Bottom Left");
                    }
                    break;
                case R.id.center:
                    nrClicks++;
                    if (current.equals("")) {
                        editText.setText("Center");
                    } else {
                        editText.setText(current + ",Center");
                    }
                    break;
                case R.id.navigate_to_secondary_activity_button:
                    break;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        editText = (EditText)findViewById(R.id.edit_text);
        editText.setText("");
        topLeft = (Button)findViewById(R.id.top_left);
        topRight = (Button)findViewById(R.id.top_right);
        center = (Button)findViewById(R.id.center);
        bottomLeft = (Button)findViewById(R.id.bottom_left);
        bottomRight = (Button)findViewById(R.id.bottom_right);

        topLeft.setOnClickListener(buttonClickListener);
        topRight.setOnClickListener(buttonClickListener);
        center.setOnClickListener(buttonClickListener);
        bottomLeft.setOnClickListener(buttonClickListener);
        bottomRight.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            nrClicks = Integer.valueOf(savedInstanceState.get("clicks").toString());
            Toast.makeText(this, savedInstanceState.get("clicks").toString(), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("clicks", nrClicks.toString());
    }
}

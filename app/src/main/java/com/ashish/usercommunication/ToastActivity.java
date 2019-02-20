package com.ashish.usercommunication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity
    implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        findViewById(R.id.btnShowToast).setOnClickListener(this);
        findViewById(R.id.btnShowCustomToast).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShowToast:
                showToast();
                break;
            case R.id.btnShowCustomToast:
                showCustomToast();
                break;
        }
    }

    private void showToast() {
        int toastDuration;
        RadioButton rbShort = (RadioButton)findViewById(R.id.rbShort);
        if (rbShort.isChecked())
            toastDuration = Toast.LENGTH_SHORT;
        else
            toastDuration = Toast.LENGTH_LONG;

        // Create and show the toast message
        Toast toast = Toast.makeText(this, "This is a toast", toastDuration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private void showCustomToast() {
        int toastDuration;
        RadioButton rbShort = (RadioButton)findViewById(R.id.rbShort);
        if (rbShort.isChecked())
            toastDuration = Toast.LENGTH_SHORT;
        else
            toastDuration = Toast.LENGTH_LONG;

        // Get the custom layout and inflate it
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout,
                (ViewGroup) findViewById(R.id.customToastLayout));

        // Build a toast message that uses the custom layout
        TextView tv = (TextView)layout.findViewById(R.id.textContent);
        tv.setText("This is a custom toast");
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(toastDuration);
        toast.setGravity(Gravity.BOTTOM | Gravity.START, 100, 100);
        toast.setView(layout);
        toast.show();
    }
}

package net.chi6rag.android.intentstest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class ViewToast extends ActionBarActivity {

    Button button_popup_toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_toast);
        button_popup_toast = (Button) findViewById(R.id.button_popup_toast);
        button_popup_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L.m("Clicked Button");
                Toast toast = new Toast(ViewToast.this);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);

                LayoutInflater layoutInflater = getLayoutInflater();
                View appearence = layoutInflater.inflate(R.layout.toast, (ViewGroup)findViewById(R.id.toast_root));
                toast.setView(appearence);
                toast.show();
            }
        });
    }
}

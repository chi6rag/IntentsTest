package net.chi6rag.android.intentstest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    Button button_activity_toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_activity_toast = (Button) findViewById(R.id.button_activity_toast);
        button_activity_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L.m("This should take me to ViewToast Activity");
                Intent intent = new Intent(MainActivity.this, ViewToast.class);
                startActivity(intent);
            }
        });

    }

    public void process(View view) {
        Intent intent = null, chooser = null;
        switch(view.getId()){
            case R.id.button_launch_map:
                Log.d("chi6rag", "Clicked button_launch_map");
                intent = new Intent(android.content.Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:27.77,19.99"));
                chooser = Intent.createChooser(intent, "Select Map Application");
                startActivity(chooser);
                break;
            case R.id.button_launch_market:
                Log.d("chi6rag", "Clicked button_launch_market");
                intent = new Intent(android.content.Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=com.pango.PANSAM"));
                chooser = Intent.createChooser(intent, "Choose Store Application");
                startActivity(chooser);
                break;
            case R.id.button_send_email:
                Log.d("chi6rag", "Clicked button_send_email");
                intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String[] to = {"chi6rag@gmail.com", "me@chi6rag.net"};
                intent.putExtra(Intent.EXTRA_EMAIL, to);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Trying to send Email via Android");
                intent.putExtra(Intent.EXTRA_TEXT, "Lorem Ipsum Dolor");
                intent.setType("message/rfc822");
                chooser = Intent.createChooser(intent, "Select Email App");
                startActivity(chooser);
                break;
            case R.id.button_send_image:
                Log.d("chi6rag", "Clicked button_send_image");
                Uri imageUri = Uri.parse("http://res.cloudinary.com/chi6rag/image/upload" +
                        "/v1433233110/General/Screen_Shot_2015-06-02_at_1.47.59_PM.png");
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_STREAM, imageUri);
                intent.putExtra(Intent.EXTRA_TEXT, "Hey! I have attached this image");
                chooser = Intent.createChooser(intent, "Choose App to Send Image");
                startActivity(chooser);
                break;
            case R.id.button_send_images:
                L.m("Clicked button_send_images");
                File pictures = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String[] listOfPictures = pictures.list();
                System.out.println(listOfPictures);
                ArrayList<Uri> arrayList = new ArrayList<Uri>();
                Uri uri = null;
                if(listOfPictures != null){
                    for(String picture : listOfPictures){
                        uri = Uri.parse("file://" + pictures.toString() + picture);
                        arrayList.add(uri);
                    }
                    intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                    intent.putExtra(Intent.EXTRA_STREAM, arrayList);
                    intent.setType("image/*");
                    chooser = Intent.createChooser(intent, "Send Multiple Images");
                    startActivity(chooser);
                }else{
                    L.s(this, "No images inside the SD Card");
                }
                break;
            default:
                Log.d("chi6rag", "Clicked unidentified button");
                break;
        }
    }
}

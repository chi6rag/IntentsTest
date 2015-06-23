package net.chi6rag.android.intentstest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by chiragaggarwal on 23/06/15.
 */
public class L {

    public static void m(String message){
        Log.d("chi6rag", message);
    }

    public static void s(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}

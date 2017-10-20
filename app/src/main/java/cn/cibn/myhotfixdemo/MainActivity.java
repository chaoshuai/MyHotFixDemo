package cn.cibn.myhotfixdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;

import cn.cibn.hostlibrary.HostClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HostClass.getInstance(this).showLog();
        Log.d("MainActivity_app",Environment
                .getExternalStorageDirectory().toString()
                + File.separator
                + "plug.jar");
    }
}

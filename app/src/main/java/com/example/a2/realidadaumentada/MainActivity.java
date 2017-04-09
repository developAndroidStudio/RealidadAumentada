package com.example.a2.realidadaumentada;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wikitude.architect.ArchitectStartupConfiguration;
import com.wikitude.architect.ArchitectView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ArchitectView architectView;

    public static final String WIKITUDE_SDK_KEY =
            "APQmD88XXllY5daBE+pNPr8GsBjOUVRsGMCz4edtf7NUjh8YWM6RLnf2TueWkE28GbvgVTC1SR6S" +
                    "/C/QHwArsqQf00RRAFc6q3xFo/1ua7dsrtGclZ02Y3ynMizL3GxXa3xjaDE0VrA3W6jLsRNJZhg7S/" +
                    "4vMuBs/nqyWeXTY79TYWx0ZWRfX93JBsy8F3dPwsXMWfQhJLdM8x/MeImHpBG7B8uTWKreVA/" +
                    "9GgTAcWdtnSQrhsOVyX5YvGZRHla345goPkTJ+/xeJtJZRRwAEZW8jhhIamQyxWsYLT3BYC2HKLj4VkgBsD0oKBBAGre5nfbWRtWnCu0+ge5kqt/" +
                    "jFL88D4YfTU7VAhI6uMVMi0nrWMTDwcNzLZkbroMLql/HtVm2iwNI0WWZpDUidcNqzTvzJP1vchUJuVGtUFyzEFuj4ELKOau0Xjo8BRGD5bV7nRbp0Q5BbHmvKVfol6G8Zdy/" +
                    "HyNpYLWIjtCs6ZnOgKKi8PuVU45m8Nyys0rFlO0SBYIratoHFA5QYsxe7LYUWaysrr4KreO/Nz+8viAQFj5aShBQldQ8gPkFOuCRfPO2iECKhOty0ZbIJvqTa36WJgJUYhYbZwCSlQCDZCloKsoW3yzN/" +
                    "z4Ga6pIPbVvI8xRLHTMOoiBrS+6dcAK1xpqhge2yY7Zn0MK3xQ+vcyAN4E=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.architectView = (ArchitectView) findViewById(R.id.architectView);
       final ArchitectStartupConfiguration config=new ArchitectStartupConfiguration();
        config.setLicenseKey(WIKITUDE_SDK_KEY);

        try{
            this.architectView.onCreate(config);
        }catch (Exception e){
            Toast.makeText(this, "No se ha podido crear la vista",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (architectView != null) {
            architectView.onPostCreate();
        }
        try {
            if (architectView != null) {
                architectView.load("videoAR/index.html");
            } else {
                Toast.makeText(this, "Architect View nulo", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            Log.e("AR", e.toString());
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.architectView != null) {
            this.architectView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (this.architectView != null) {
            this.architectView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.architectView != null) {
            this.architectView.onDestroy();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (this.architectView != null) {
            this.architectView.onLowMemory();
        }
    }
}

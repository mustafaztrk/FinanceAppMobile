package com.example.FinanceMobileApp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Test extends AppCompatActivity {
    private Button btn_cek;
    private ImageView imageView;
    private static final int CAMERA_REQUEST=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);




        btn_cek = findViewById(R.id.btn_cek);
        imageView = findViewById(R.id.imageView);

        btn_cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
        {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(image);
        }
    }
}
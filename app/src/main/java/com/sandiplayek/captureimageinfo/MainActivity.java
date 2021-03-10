package com.sandiplayek.captureimageinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sandiplayek.imagedetailslib.ImageInformation;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    ImageView ivPreview;
    Button btnCamera;
    TextView tvResult;
    private static final int CAMERA_REQUEST = 1888;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPreview = findViewById(R.id.ivPreview);
        btnCamera = findViewById(R.id.btnCamera);
        tvResult = findViewById(R.id.tvResult);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            ImageInformation imageInformation = new ImageInformation(MainActivity.this);

            // IF YOU WANT TO SET IMAGE TO IMAGE VIEW
            Bitmap bitmapPhoto = imageInformation.setImageToImageView(ivPreview,data);

            // IF YOU ONLY GET BITMAP IMAGE THEN YOU SET MANUALLY
            Bitmap bitmapPhoto1 = imageInformation.getBitmapFormatImage(data);

            Uri uri = imageInformation.getImageUri(bitmapPhoto);
            // SET DYNAMIC QUALITY
            Uri uriDynamicQuality = imageInformation.getImageUri(bitmapPhoto,50);

            String realPath = imageInformation.getRealPathFromURI(uri);
            File file = imageInformation.getActualPath(realPath);
            byte[] fileInBytes = imageInformation.getFileInByteArray(realPath);

            // IMAGE PROP SECTION CALL
            long size = imageInformation.getFileSizeInKB(file);
            int height = imageInformation.getImageFileHeight(bitmapPhoto);
            int width = imageInformation.getImageFileWidth(bitmapPhoto);
            String ext = imageInformation.getFileExtension(realPath);
            String fileName = imageInformation.getFileName(realPath);

            String note =
                    "RealPath: "+realPath+
                    "\nSize: "+size+
                    "\nHeight: "+height+
                    "\nWidth: "+width+
                    "\nExtension: "+ext+
                    "\nFile Name: "+fileName;

            tvResult.setText(note);
        }
    }
}
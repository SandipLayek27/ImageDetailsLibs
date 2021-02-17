package com.sandiplayek.imagedetailslib;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageInformation {
    Context context;
    public ImageInformation(Context context) {
        this.context = context;
    }

    public Uri getImageUri(Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        String path = "";
        if (context.getContentResolver() != null) {
            Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                path = cursor.getString(idx);
                cursor.close();
            }
        }
        return path;
    }

    public File getActualPath(String realpath){
        File finalFile = new File(realpath);
        return finalFile;
    }

    public Bitmap setImageToImageView(ImageView iv, Intent data){
        Bitmap photo = (Bitmap) data.getExtras().get("data");
        iv.setImageBitmap(photo);
        return photo;
    }

    public long getFileSizeInKB(File file){
        long length = file.length();
        length = length/1024;
        return length;
    }

    public int getImageFileHeight(Bitmap bitmap){
        int h = bitmap.getHeight();
        return h;
    }

    public int getImageFileWidth(Bitmap bitmap){
        int w = bitmap.getWidth();
        return w;
    }

    public String getFileExtension(String filePath){
        String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
        return extension;
    }

    public String getFileName(String filePath){
        String filename = filePath.substring(filePath.lastIndexOf("/")+1);
        return  filename;
    }

    public ExifInterface imageCaptureDate(String filePath){
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exif;
    }
}
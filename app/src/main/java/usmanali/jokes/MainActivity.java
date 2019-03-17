package usmanali.jokes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    int[] images = new int[]{R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4, R.drawable.h5, R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10, R.drawable.h12, R.drawable.h13, R.drawable.h14, R.drawable.h15, R.drawable.h16, R.drawable.h17, R.drawable.h18, R.drawable.h19, R.drawable.h20, R.drawable.h21, R.drawable.h22, R.drawable.h23, R.drawable.h24, R.drawable.h25, R.drawable.h26, R.drawable.h27, R.drawable.h28, R.drawable.h29, R.drawable.h30, R.drawable.h31, R.drawable.h32, R.drawable.h33, R.drawable.h34, R.drawable.h35, R.drawable.h36, R.drawable.h37, R.drawable.h38, R.drawable.h39, R.drawable.h40, R.drawable.h41, R.drawable.h42, R.drawable.h43, R.drawable.h44, R.drawable.h45, R.drawable.h46, R.drawable.h47, R.drawable.h48, R.drawable.h49, R.drawable.h50, R.drawable.h51, R.drawable.h52, R.drawable.h53, R.drawable.h54, R.drawable.h55, R.drawable.h56, R.drawable.h11, R.drawable.h57, R.drawable.h58, R.drawable.h59, R.drawable.h60, R.drawable.h61, R.drawable.h62, R.drawable.h63, R.drawable.h64, R.drawable.h65, R.drawable.h66, R.drawable.h67, R.drawable.h68, R.drawable.h69, R.drawable.h70, R.drawable.h71, R.drawable.h72, R.drawable.h73, R.drawable.h74, R.drawable.h75, R.drawable.h76, R.drawable.h77, R.drawable.h78, R.drawable.h79, R.drawable.h80, R.drawable.h81, R.drawable.h82, R.drawable.h83, R.drawable.h84, R.drawable.h85, R.drawable.h86, R.drawable.h87, R.drawable.h88, R.drawable.h89, R.drawable.h90, R.drawable.h91, R.drawable.h92, R.drawable.h93, R.drawable.h94, R.drawable.h95, R.drawable.h96, R.drawable.h97, R.drawable.h98, R.drawable.h99, R.drawable.h100, R.drawable.h101, R.drawable.h102, R.drawable.h103, R.drawable.h104, R.drawable.h105, R.drawable.h106, R.drawable.h107, R.drawable.h108, R.drawable.h109, R.drawable.h110, R.drawable.h111, R.drawable.h112, R.drawable.h113, R.drawable.h114, R.drawable.h115, R.drawable.h116, R.drawable.h117, R.drawable.h118, R.drawable.h119, R.drawable.h120, R.drawable.h121, R.drawable.h122, R.drawable.h123, R.drawable.h124, R.drawable.h125, R.drawable.h126, R.drawable.h127, R.drawable.h128, R.drawable.h129, R.drawable.h130, R.drawable.h131, R.drawable.h132, R.drawable.h133, R.drawable.h134, R.drawable.h135, R.drawable.h136, R.drawable.h137, R.drawable.h138, R.drawable.h139, R.drawable.h150, R.drawable.h151, R.drawable.h152, R.drawable.h153, R.drawable.h154, R.drawable.h155, R.drawable.h156, R.drawable.h157, R.drawable.h158, R.drawable.h159, R.drawable.h160, R.drawable.h161, R.drawable.h162, R.drawable.h163, R.drawable.h164, R.drawable.h165, R.drawable.h166, R.drawable.h167, R.drawable.h168, R.drawable.h169, R.drawable.h170, R.drawable.h171, R.drawable.h172, R.drawable.h173, R.drawable.h174, R.drawable.h175, R.drawable.h176, R.drawable.h177, R.drawable.h178, R.drawable.h179, R.drawable.h180, R.drawable.h181, R.drawable.h182, R.drawable.h183, R.drawable.h184, R.drawable.h185, R.drawable.h186, R.drawable.h187, R.drawable.h188, R.drawable.h189, R.drawable.h190, R.drawable.h191, R.drawable.h192, R.drawable.h193, R.drawable.h194, R.drawable.h195, R.drawable.h196, R.drawable.h197, R.drawable.h198, R.drawable.h199, R.drawable.h200, R.drawable.h201, R.drawable.h202, R.drawable.h203, R.drawable.h204, R.drawable.h205, R.drawable.h206, R.drawable.h207, R.drawable.h208, R.drawable.h209, R.drawable.h210, R.drawable.h211, R.drawable.h212, R.drawable.h213, R.drawable.h214, R.drawable.h215, R.drawable.h216, R.drawable.h217, R.drawable.h218, R.drawable.h219, R.drawable.h220, R.drawable.h221, R.drawable.h222, R.drawable.h223, R.drawable.h224, R.drawable.h225, R.drawable.h226, R.drawable.h227, R.drawable.h228, R.drawable.h229, R.drawable.h230, R.drawable.h231, R.drawable.h232, R.drawable.h233, R.drawable.h234, R.drawable.h235, R.drawable.h236};
    ImageView iv;
    int length=images.length;
    int counter =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=(ImageView)findViewById(R.id.imageSwitcher);
    }
    public void share_image(View v){
        Bitmap bitmap = ((BitmapDrawable) this.iv.getDrawable()).getBitmap();
        File sharefile = new File(getApplicationContext().getExternalCacheDir(), "toshare.png");
        try {
            FileOutputStream out = new FileOutputStream(sharefile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
        }
        Intent share = new Intent("android.intent.action.SEND");
        share.setType("image/*");
        share.putExtra("android.intent.extra.STREAM", Uri.parse("file://" + sharefile));
        try {
            startActivity(Intent.createChooser(share, "Share photo"));
        } catch (Exception e2) {
        }

    }
    public void save_image(View v){
        if (ContextCompat.checkSelfPermission(MainActivity.this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
            return;
        }
        this.iv.setDrawingCacheEnabled(true);
        Bitmap bitmap = ((BitmapDrawable) this.iv.getDrawable()).getBitmap();
        File newFile = new File(Environment.getExternalStorageDirectory().toString() + "/images");
        newFile.mkdirs();
        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(new File(newFile, String.format("%d.jpg", new Object[]{Long.valueOf(System.currentTimeMillis())})));
        } catch (Exception e) {
            e.printStackTrace();
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outStream);
        try {
            outStream.flush();
            Toast.makeText(getApplicationContext(), "Image Saved Successfully", Toast.LENGTH_LONG).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            outStream.close();
        } catch (Exception e22) {
            e22.printStackTrace();
        }

    }
    public void next_image(View v){
        if(counter<length-1){
            counter++;
            iv.setImageResource(images[counter]);
        }else{
            counter=0;
            iv.setImageResource(images[counter]);
        }
}
public void previous_image(View v){
    if(counter>0){
     counter--;
        iv.setImageResource(images[counter]);
    }else if(counter==0){
        iv.setImageResource(images[counter]);
    }
}

}

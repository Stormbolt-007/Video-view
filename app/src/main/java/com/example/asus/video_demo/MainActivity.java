package com.example.asus.video_demo;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button b1;
    VideoView vw;
    MediaController mc;
    Uri u1;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        u1=data.getData();
        vw.setVideoURI(u1);
        vw.setMediaController(mc);
        mc.setAnchorView(vw);
        vw.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        vw=(VideoView)findViewById(R.id.videoView);
        mc=new MediaController(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,0);
            }
        });
    }
}

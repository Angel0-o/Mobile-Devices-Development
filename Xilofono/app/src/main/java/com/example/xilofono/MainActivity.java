package mx.ipn.cic.geo.clase_xilofono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.xilofono.R;

import java.io.FileDescriptor;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        playSound();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playSound() {

        try {
            AssetFileDescriptor assetFileDescriptor = getResources().openRawResourceFd(R.raw.note1);
            FileDescriptor fileDescriptor = assetFileDescriptor.getFileDescriptor();

            MediaPlayer player = new MediaPlayer();
            player.setDataSource(fileDescriptor, assetFileDescriptor.getStartOffset(),
                    assetFileDescriptor.getLength());
            player.setLooping(false);
            player.prepare();
            player.start();
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    // TODO Auto-generated method stub
                    mediaPlayer.release();
                }
            });
        } catch (IOException exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
    }
}

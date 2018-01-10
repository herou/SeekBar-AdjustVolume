package comqueues.example.user.seekbarvolume;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.VideoView;



public class MainActivity extends AppCompatActivity implements MainView{

    SeekBar seekbar_volume;
    FrameLayout framelayout;
    VideoView videoview_camera_sv_preview;

    MainPresenter mainPresenter;

    AudioManager audioManager;

    AnimateSeekBar animate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoview_camera_sv_preview = findViewById(R.id.videoview_camera_sv_preview);
        framelayout = findViewById(R.id.framelayout);
        seekbar_volume = findViewById(R.id.seekbar_volume);

        mainPresenter = new MainPresenter(this);
        mainPresenter.playVideo();

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        mainPresenter.initSeekBar();

        seekbar_volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mainPresenter.onProgressChanged(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mainPresenter.onStartTrackingTouch();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                framelayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mainPresenter.onStopTrackingTouch();
                    }
                });
            }
        });

        framelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.setAnimationToSeekBar();
            }
        });
    }

    @Override
    public void play(String link) {
        videoview_camera_sv_preview.setVideoPath(link);
        videoview_camera_sv_preview.start();
    }

    @Override
    public void startAnimationToSeekBarShow() {
        startAnimationToShowSeekBar();
    }

    @Override
    public void setVolume(int i) {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
    }

    @Override
    public void startAnimationToSeekBarHide() {
        animate = new AnimateSeekBar(getApplicationContext());
        seekbar_volume.setAnimation(animate.getAnimFadeOut());
        animate.setFadeOutDuration();
        seekbar_volume.setVisibility(View.INVISIBLE);
    }

    @Override
    public void startAnimationToSeekBarShowOnClick() {
        startAnimationToShowSeekBar();
    }

    @Override
    public void initializeSeekBar() {
        seekbar_volume.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekbar_volume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
    }

    @Override
    public void startAnimationToShowSeekBar(){
        seekbar_volume.setVisibility(View.VISIBLE);
        animate = new AnimateSeekBar(getApplicationContext());
        seekbar_volume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        seekbar_volume.setAnimation(animate.getAnimFadeIn());
        seekbar_volume.setAnimation(animate.getAnimFadeOut());
        animate.setFadeOutDuration();
        seekbar_volume.setVisibility(View.INVISIBLE);
    }
}

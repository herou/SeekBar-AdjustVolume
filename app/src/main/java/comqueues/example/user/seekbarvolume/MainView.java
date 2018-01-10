package comqueues.example.user.seekbarvolume;

/**
 * Created by user on 1/9/2018.
 */

public interface MainView {

    void play(String s);

    void startAnimationToSeekBarShow();

    void setVolume(int i);

    void startAnimationToSeekBarHide();

    void startAnimationToSeekBarShowOnClick();

    void initializeSeekBar();

    void startAnimationToShowSeekBar();
}

package comqueues.example.user.seekbarvolume;

/**
 * Created by user on 1/9/2018.
 */

public class MainPresenter {

    MainActivity mainActivity;
    MainPresenter(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    public void playVideo(){
        mainActivity.play(Utils.Link);
    }

    public void setAnimationToSeekBar() {
        mainActivity.startAnimationToSeekBarShow();
    }

    public void onProgressChanged(int i) {
        mainActivity.setVolume(i);
    }

    public void onStartTrackingTouch() {
        mainActivity.startAnimationToSeekBarHide();
    }

    public void onStopTrackingTouch() {
        mainActivity.startAnimationToSeekBarShowOnClick();
    }

    public void initSeekBar() {
        mainActivity.initializeSeekBar();
    }
}

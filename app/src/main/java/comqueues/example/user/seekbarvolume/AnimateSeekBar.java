package comqueues.example.user.seekbarvolume;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by user on 1/10/2018.
 */

public class AnimateSeekBar {

    Animation animFadeOut;
    Animation animFadeIn;

    public AnimateSeekBar(Context context) {
        this.animFadeOut = AnimationUtils.loadAnimation(context, android.R.anim.fade_out);
        this.animFadeIn = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
    }

    public Animation getAnimFadeOut() {
        return animFadeOut;
    }

    public void setAnimFadeOut(Animation animFadeOut) {
        this.animFadeOut = animFadeOut;
    }

    public Animation getAnimFadeIn() {
        return animFadeIn;
    }

    public void setAnimFadeIn(Animation animFadeIn) {
        this.animFadeIn = animFadeIn;
    }

    public void setFadeOutDuration(){
        animFadeOut.setDuration(3000);
    }
}

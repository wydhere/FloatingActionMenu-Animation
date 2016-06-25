package toan.android.floatingactionmenu;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.view.ViewPropertyAnimator;

/**
 * Created by Toan Vu on 6/23/16.
 */
public class FabAnimationUtils {
    public static final int ANIM_NONE = 0;
    public static final int ANIM_TRANSLATION_Y = 1;
    public static final int ANIM_SCALE = 2;
    //time animation when scrolling
    private static final int TRANSLATE_DURATION_MILLIS = 250;
    private static final Interpolator mInterpolator = new AccelerateDecelerateInterpolator();


    static void scale(View group, View view, boolean visible) {
        AnimListener animListener = new AnimListener(group, visible);
        float scale = visible ? 1 : 0;
        ViewPropertyAnimator.animate(view).setInterpolator(mInterpolator)
                .setDuration(TRANSLATE_DURATION_MILLIS)
                .scaleX(scale);
        ViewPropertyAnimator.animate(view).setInterpolator(mInterpolator)
                .setDuration(TRANSLATE_DURATION_MILLIS)
                .scaleY(scale).setListener(animListener);

    }

    static void translationY(View view, boolean visible, int height, int marginBottom) {
        int translationY = visible ? 0 : height + marginBottom;
        ViewPropertyAnimator.animate(view).setInterpolator(mInterpolator)
                .setDuration(TRANSLATE_DURATION_MILLIS)
                .translationY(translationY);
    }

    //TODO: later
    static void rotate(View view, boolean visible, int height, int marginBottom) {
        float rotateXBy = visible ? 500 : -500;
        float rotateX = visible ? -30 : -30;
        float rotateYBy = visible ? 0 : 0;
        float rotateY = visible ? 30 : 390;
//        ViewPropertyAnimator.animate(view).setInterpolator(mInterpolator)
//                .setDuration(TRANSLATE_DURATION_MILLIS)
//                .rotation(rotateXBy);
//        ViewPropertyAnimator.animate(view).setInterpolator(mInterpolator)
//                .setDuration(TRANSLATE_DURATION_MILLIS)
//                .rotationYBy(rotateYBy).rotationY(rotateY);

        translationY(view, visible, height, marginBottom);
    }


    static class AnimListener implements Animator.AnimatorListener {
        private View view;
        private boolean visible;

        public AnimListener(View view, boolean visible) {
            this.view = view;
            this.visible = visible;
        }

        @Override
        public void onAnimationStart(Animator animation) {
            view.setVisibility(View.VISIBLE);
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            view.setVisibility(visible ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    }

}
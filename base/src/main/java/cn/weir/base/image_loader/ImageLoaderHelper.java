package cn.weir.base.image_loader;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import cn.weir.base.GlideApp;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;

public class ImageLoaderHelper {

    /**
     * 加载图片
     *
     * @param context 上下文
     * @param url     图片地址
     * @param view    目标View
     */
    public final void displayImage(Context context, String url, ImageView view) {
        GlideApp.with(context).load(url).into(view);
    }

    /**
     * 加载图片
     *
     * @param context  上下文
     * @param url      图片地址
     * @param view     目标View
     * @param errorRes 错误加载图
     */
    public final void displayImage(Context context, String url, ImageView view, @DrawableRes int errorRes) {
        GlideApp.with(context).load(url).error(errorRes).into(view);
    }

    /**
     * 加载灰度图片
     *
     * @param context  上下文
     * @param url      图片地址
     * @param view     目标View
     * @param errorRes 错误加载图
     */
    public final void displayGrayscaleImage(Context context, String url, ImageView view, @DrawableRes int errorRes) {
        GlideApp.with(context).load(url).optionalTransform(new GrayscaleTransformation()).error(errorRes).into(view);
    }

}
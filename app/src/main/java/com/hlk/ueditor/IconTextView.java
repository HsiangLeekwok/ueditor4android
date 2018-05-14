package com.hlk.ueditor;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;


/**
 * <b>功能描述：</b><br />
 * <b>创建作者：</b>Hsiang Leekwok <br />
 * <b>创建时间：</b>2018/05/14 23:09 <br />
 * <b>作者邮箱：</b>xiang.l.g@gmail.com <br />
 * <b>最新版本：</b>version: 1.0.0 <br />
 * <b>修改时间：</b>2017/10/04 18:50 <br />
 * <b>修改人员：</b><br />
 * <b>修改备注：</b><br />
 */
public class IconTextView extends AppCompatTextView {

    public IconTextView(Context context) {
        super(context);
        resetTypeface(context);
    }

    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        resetTypeface(context);
    }

    public IconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        resetTypeface(context);
    }

    private void resetTypeface(Context context) {
        setTypeface(TypefaceHelper.get(context, "fonts/material-icons-regular.ttf"));
    }
}

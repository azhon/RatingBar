package com.azhong.ratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/*
 * 项目名:    RattingBar
 * 文件名:    RattingBar
 * 创建者:    ZSYr
 * 创建时间:  2017/4/16 on 15:26
 * 描述:     TODO 自定义评分控件
 */
public class RatingBar extends LinearLayout implements View.OnClickListener {
    /**
     * 填充的图片
     */
    private Drawable starDrawable;
    /**
     * 默认显示的图片
     */
    private Drawable unStarDrawable;
    /**
     * 图片的总数
     */
    private int starCount;
    /**
     * 填充的图片数量
     */
    private int star;
    /**
     * 图片宽度
     */
    private float width;
    /**
     * 图片高度(默认为正方形)
     */
    private float height;
    /**
     * 图片之间的间距
     */
    private float imagePadding;
    /**
     * 图片是否可以点击
     */
    private boolean clickable;

    public RatingBar(Context context) {
        super(context);
        init(context, null);
    }

    public RatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    /**
     * 初始化操作
     */
    private void init(Context context, AttributeSet attrs) {
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.a_zhon);
            starDrawable = array.getDrawable(R.styleable.a_zhon_star_img);
            unStarDrawable = array.getDrawable(R.styleable.a_zhon_unstar_img);
            width = array.getDimension(R.styleable.a_zhon_image_width, dip2px(context, 36));
            height = array.getDimension(R.styleable.a_zhon_image_height, dip2px(context, 36));
            imagePadding = array.getDimension(R.styleable.a_zhon_image_padding, 5);
            clickable = array.getBoolean(R.styleable.a_zhon_clickable, true);
            starCount = array.getInt(R.styleable.a_zhon_star_count, 5);
            star = array.getInt(R.styleable.a_zhon_star, 0);
            array.recycle();
        }
        for (int i = 0; i < starCount; i++) {
            ImageView view = getImageView(context, width, height);
            //设置ImageView的下标
            view.setTag(i);
            addView(view);
            //可以点击评分
            if (clickable)
                view.setOnClickListener(this);
        }
        if (star != 0) {
            if (star <= starCount) {
                //填充图片
                fillingImage(star - 1);
            } else {
                throw new RuntimeException("star填充数量不能大于总数star_count!");
            }
        }
    }

    /**
     * 创建默认的5个ImageView
     *
     * @param context 上下文
     * @param width   宽度
     * @param height  高度
     * @return ImageView
     */
    private ImageView getImageView(Context context, float width, float height) {
        ImageView view = new ImageView(context);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(Math.round(width), Math.round(height));
        view.setLayoutParams(params);
        view.setPadding(dip2px(context, imagePadding), 0, 0, 0);
        if (unStarDrawable == null) {
            throw new NullPointerException("请先设置默认的图片资源!");
        } else {
            view.setImageDrawable(unStarDrawable);
        }
        return view;
    }

    /**
     * 图片的点击事件
     */
    @Override
    public void onClick(View v) {
        fillingImage((Integer) v.getTag());
    }

    /**
     * 填充图片
     *
     * @param i 点击的图片下标
     */
    private void fillingImage(int i) {
        //首先将所有的背景都设置为默认背景图片
        for (int j = 0; j < starCount; j++) {
            ImageView view = (ImageView) getChildAt(j);
            if (unStarDrawable == null) {
                throw new NullPointerException("请先设置默认的图片资源!");
            } else {
                view.setImageDrawable(unStarDrawable);
            }
        }
        //填充选中的等级
        for (int j = 0; j <= i; j++) {
            ImageView view = (ImageView) getChildAt(j);
            if (starDrawable == null) {
                throw new NullPointerException("请先设置填充的图片资源!");
            } else {
                view.setImageDrawable(starDrawable);
            }
        }
    }

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    private int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 设置当前填充数量
     *
     * @param star 数量
     */
    public void setStar(int star) {
        if (star > starCount) {
            throw new RuntimeException("star填充数量不能大于总数starCount");
        }
        this.star = star;
        if (star != 0) {
            if (star <= starCount) {
                //填充图片
                fillingImage(star - 1);
            } else {
                throw new RuntimeException("star填充数量不能大于总数starCount!");
            }
        }
    }

    /**
     * 获得当前评分数
     */
    public int getStar() {
        return star;
    }

    /**
     * 设置总数量
     *
     * @param starCount 总数量
     */
    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    /**
     * 设置是否可以点击
     *
     * @param clickable true|false
     */
    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }
}

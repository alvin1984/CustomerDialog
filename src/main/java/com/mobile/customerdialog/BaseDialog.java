package com.mobile.customerdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by pxy on 2018/3/20.
 */

public class BaseDialog extends Dialog implements DialogInterface.OnDismissListener {

    private Context mContext;
    /**
     * 存放内容的容器
     */
    private FrameLayout container;
    /**
     * 存放按钮的容器(按钮必须是button)
     */
    private LinearLayout btnPanel;

    /**
     * 控制窗口显示时长的handler
     */
    private Handler handler;

    /**
     * 右上角的关闭按钮
     */
    private ImageView closeIV;

    /**
     * 内容容器与按钮容器之间的分隔线
     */
    private View divider;

    public BaseDialog(@NonNull Context context) {
        super(context, R.style.Base_Library_Dialog_Fullscreen);
        mContext = context;
        handler = new Handler(context.getMainLooper());
        initView();
    }

    private void initView() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.base_library_dialog_base, null, false);
        divider = rootView.findViewById(R.id.divider);
        setContentView(rootView);

        container = rootView.findViewById(R.id.container);
        btnPanel = rootView.findViewById(R.id.button_panel);
        closeIV = rootView.findViewById(R.id.base_lib_iv_close);

        setOnDismissListener(this);
    }

    public BaseDialog setContainerView(int layoutResId) {
        LayoutInflater.from(mContext).inflate(layoutResId, container, true);
        return this;
    }

    public BaseDialog setContainerView(View view) {
        container.addView(view, view.getLayoutParams());
        return this;
    }

    public BaseDialog showCloseBtn() {
        closeIV.setVisibility(View.VISIBLE);
        closeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return this;
    }

    public BaseDialog setCloseBtnClickListener(View.OnClickListener listener) {
        closeIV.setOnClickListener(listener);
        return this;
    }

    public BaseDialog showCloseBtn(View.OnClickListener listener) {
        showCloseBtn();
        return setCloseBtnClickListener(listener);
    }

    public BaseDialog setDialogRadius(int radiusDP) {
        ((CardView) findViewById(R.id.card_view))
                .setRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, radiusDP, mContext.getResources().getDisplayMetrics()));
        return this;
    }

    public BaseDialog showFromBottom() {
        setGravity(Gravity.BOTTOM);
        setWindowAnimation(R.style.Base_Library_Dialog_Animation);
        return this;
    }

    /**
     * 是否已经添加过一个按钮的标记位，如果已经添加过一个按钮，则要添加
     * 按钮之间的分隔线
     */
    private boolean hadBtn;

    public BaseDialog addBtn(String title, int textColorId, View.OnClickListener listener) {
        if (hadBtn) {
            addDivider();
        } else {
            hadBtn = true;
            divider.setVisibility(View.VISIBLE);

        }


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, mContext.getResources().getDisplayMetrics()));
        layoutParams.weight = 1.0f;

        Button button = new Button(mContext);
        button.setTextColor(textColorId);
        button.setTextSize(18);
        button.setText(title);
        button.setAllCaps(false);
        button.setOnClickListener(listener);
        button.setBackgroundResource(R.drawable.base_library_dialog_btn_selector);
        btnPanel.addView(button, layoutParams);

        return this;
    }

    private void addDivider() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(1, LinearLayout.LayoutParams.MATCH_PARENT);
        View divider = new View(mContext);
        divider.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFA6A6AD")));
        btnPanel.addView(divider, layoutParams);
    }

    /**
     * 添加否定按钮
     * @param title 按钮的标题
     * @param listener 按钮的点击事件
     * @return 当前窗口对象
     */
    public BaseDialog addNegativeBtn(String title, View.OnClickListener listener) {
        if (hadBtn) {
            addDivider();
        } else {
            hadBtn = true;
            divider.setVisibility(View.VISIBLE);

        }

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, mContext.getResources().getDisplayMetrics()));
        layoutParams.weight = 1.0f;

        Button button = new Button(mContext);
        button.setTextColor(Color.parseColor("#000000"));
        button.setTextSize(18);
        button.setText(title);
        button.setAllCaps(false);
        button.setOnClickListener(listener);
        button.setBackgroundResource(R.drawable.base_library_dialog_btn_selector);
        btnPanel.addView(button, layoutParams);
        return this;
    }

    /**
     * 添加确认按钮
     * @param title 按钮的标题
     * @param listener 按钮的点击事件
     * @return 当前窗口对象
     */
    public BaseDialog addPositiveBtn(String title, View.OnClickListener listener) {
        if (hadBtn) {
            addDivider();
        } else {
            hadBtn = true;
            divider.setVisibility(View.VISIBLE);

        }


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, mContext.getResources().getDisplayMetrics()));
        layoutParams.weight = 1.0f;

        Button button = new Button(mContext);
        button.setTextColor(Color.parseColor("#000000"));
        button.setTextSize(18);
        button.setText(title);
        button.setAllCaps(false);
        button.setOnClickListener(listener);
        button.setBackgroundResource(R.drawable.base_library_dialog_btn_selector);
        btnPanel.addView(button, layoutParams);
        return this;
    }

    /**
     * 添加按钮面板，可以添加自定义的按钮布局（按钮必须是button,否则无法绑定点击事件）
     * @param layoutId 自定义按钮布局
     * @param listener 按钮的点击事件
     * @return 当前窗口对象
     */
    public BaseDialog addBtnPanel(int layoutId, View.OnClickListener listener) {
        divider.setVisibility(View.VISIBLE);
        ViewGroup parent = (ViewGroup) LayoutInflater.from(mContext).inflate(layoutId, null, false);
        btnPanel.addView(parent, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        if (listener != null){
            for (int i = 0; i < parent.getChildCount(); i++) {
                View child = parent.getChildAt(i);
                if (child instanceof Button) {
                    child.setOnClickListener(listener);
                }
            }
        }
        return this;
    }

//    public BaseDialog addBtnPanel(int layoutId) {
//        divider.setVisibility(View.VISIBLE);
//        ViewGroup parent = (ViewGroup) LayoutInflater.from(mContext).inflate(layoutId, null, false);
//        btnPanel.addView(parent, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//        return this;
//    }

    /**
     * 设置窗口的动画（进场与退场动画）
     * @param style 动画
     * @return 当前窗口对象
     */
    public BaseDialog setWindowAnimation(int style) {
        getWindow().setWindowAnimations(style);
        return this;
    }


    public BaseDialog setWindowBackground(int color) {
        container.setBackgroundColor(color);
        btnPanel.setBackgroundColor(color);
        return this;
    }

    /**
     * 设置窗口的显示位置
     * @param gravity 上、下、左和右的位置
     * @return 当前窗口对象
     */
    public BaseDialog setGravity(int gravity) {
        getWindow().setGravity(gravity);
        return this;
    }

    public BaseDialog setIsCancelable(boolean isCancelable) {
        setCancelable(isCancelable);
        return this;
    }

    public BaseDialog setCanCancelOutside(boolean isCan) {
        setCanceledOnTouchOutside(isCan);
        return this;
    }

    /**
     * 设置已添加布局中的某个id控件的背景色
     * @param viewId 某控件的id
     * @param resId 背景资源id
     * @return 当前窗口对象
     */
    public BaseDialog setBackgroundResource(int viewId, int resId) {
        findViewById(viewId).setBackgroundResource(resId);
        return this;
    }

    /**
     * 设置已添加布局中的某个id控件显示的文本
     * @param viewId 某控件的id
     * @param textId 文本id
     * @return 当前窗口对象
     */
    public BaseDialog setText(int viewId, int textId) {
        ((TextView) findViewById(viewId)).setText(textId);
        return this;
    }

    /**
     * 设置已添加布局中的某个id控件显示的文本
     * @param viewId 某控件的id
     * @param text 文本字符串
     * @return 当前窗口对象
     */
    public BaseDialog setText(int viewId, String text) {
        ((TextView) findViewById(viewId)).setText(text);
        return this;
    }

    /**
     * 设置已添加布局中的某个id控件显示的文本颜色
     * @param viewId 某控件的id
     * @param colorId 文本颜色id
     * @return 当前窗口对象
     */
    public BaseDialog setTextColor(int viewId, int colorId) {
        ((TextView) findViewById(viewId)).setTextColor(colorId);
        return this;
    }

    /**
     * 设置已添加布局中的某个id控件(ImageView)显示的文本颜色
     * @param viewId 某个ImageView控件的id
     * @param resId 图片id
     * @return 当前窗口对象
     */
    public BaseDialog setImageResource(int viewId, int resId) {
        ((ImageView) findViewById(viewId)).setImageResource(resId);
        return this;
    }

    /**
     * 设置已添加布局中的某个id控件点击事件
     * @param viewId 某个ImageView控件的id
     * @param listener 点击事件
     * @return 当前窗口对象
     */
    public BaseDialog setViewOnClickListener(int viewId, final View.OnClickListener listener) {
        findViewById(viewId).setOnClickListener(listener);
        return this;
    }

    /**
     * 是否已经设置过窗口的大小的标记位
     */
    private boolean setDialogSize;

    /**
     * 存放设置窗口后的宽度值
     */
    private int dialogWidth;

    /**
     * 存放设置窗口后的高度值
     */
    private int dialogHeight;

    public BaseDialog setDialogSize(final float widthDP, final float heightDP) {
        setDialogSize = true;
        dialogWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, widthDP, mContext.getResources().getDisplayMetrics());
        dialogHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, heightDP, mContext.getResources().getDisplayMetrics());
        return this;
    }

    private BaseDialog setDialogSize(final int width, final int height) {
        setDialogSize = true;
        dialogHeight = height;
        dialogWidth = width;
        return this;
    }

    public BaseDialog setDialogWidthSizeWithRate(float widthRate) {
        setDialogSize = true;
        DisplayMetrics d = mContext.getResources().getDisplayMetrics();
        dialogWidth = (int) (d.widthPixels * widthRate);
        return this;
    }

    public BaseDialog setDialogWidthSize(float widthDP) {
        setDialogSize = true;
        dialogWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, widthDP, mContext.getResources().getDisplayMetrics());
        return this;
    }

    private BaseDialog setDialogWidthSize(int width) {
        setDialogSize = true;
        dialogWidth = width;
        return this;
    }

    /**
     * 设置窗口宽度占满整个屏幕，高度是自适应
     * @return 当前窗口对象
     */
    public BaseDialog setMatchParent() {
        CardView cardView = findViewById(R.id.card_view);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) cardView.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        cardView.setLayoutParams(layoutParams);
        setDialogSize = true;
        dialogWidth = mContext.getResources().getDisplayMetrics().widthPixels;
        return this;
    }

    /**
     * 存放窗口的显示时长
     */
    private int lifeTime;

    /**
     * 设置窗口的显示时长，时间一到窗口自动消失
     * @param seconds 时长（秒）
     * @return
     */
    public BaseDialog setLifeTime(int seconds) {
        lifeTime = seconds;
        return this;
    }

    @Override
    public void show() {
        super.show();
        //启动倒计时，时间到后窗口自动消失
        if (lifeTime > 0) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dismiss();
                }
            }, lifeTime * 1000);
        }

        //使用者在窗口所添加的布局（通过setContentView方法添加进来的布局）
        View child = container.getChildAt(0);
        if (child == null){
            return;
        }
        CardView cardView = findViewById(R.id.card_view);
        FrameLayout.LayoutParams cardViewLayoutParams = (FrameLayout.LayoutParams) cardView.getLayoutParams();
        //如果显示关闭按钮，则窗口的左右必须设置17dp的外间距，以保证窗口的内容在屏幕是居中的
        if (closeIV.getVisibility() == View.VISIBLE){
            cardViewLayoutParams.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 17, mContext.getResources().getDisplayMetrics());
            cardViewLayoutParams.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 17, mContext.getResources().getDisplayMetrics());
        }else{//如果不显示关闭按钮，则设置窗口左右的外间距为0
            cardViewLayoutParams.leftMargin = 0;
            cardViewLayoutParams.rightMargin = 0;
        }
        cardView.setLayoutParams(cardViewLayoutParams);

        //如果用户设置过窗口的大小，则使用用户设置的大小来设置窗口
        if (setDialogSize) {
            LinearLayout rootView = findViewById(R.id.root_view);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) rootView.getLayoutParams();
            layoutParams.width = dialogWidth;
            if (dialogHeight > 0) {
                layoutParams.height = dialogHeight;
            } else {
                layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            }

            rootView.setLayoutParams(layoutParams);
        } else {//用户没有设置过窗口的大小，则根据布局的约束来控制窗口的显示大小
            if (child.getLayoutParams().width == LinearLayout.LayoutParams.MATCH_PARENT) {
                setMatchParent();
                LinearLayout rootView = findViewById(R.id.root_view);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) rootView.getLayoutParams();
                layoutParams.width = dialogWidth;
                if (dialogHeight > 0) {
                    layoutParams.height = dialogHeight;
                } else {
                    layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                }

                rootView.setLayoutParams(layoutParams);

            } else if (child.getLayoutParams().width == LinearLayout.LayoutParams.WRAP_CONTENT){
                DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
                child.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, View.MeasureSpec.AT_MOST),
                        View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, View.MeasureSpec.AT_MOST));

                LinearLayout rootView = findViewById(R.id.root_view);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) rootView.getLayoutParams();
                layoutParams.width = child.getMeasuredWidth();
                layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                rootView.setLayoutParams(layoutParams);
            }else{
                LinearLayout rootView = findViewById(R.id.root_view);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) rootView.getLayoutParams();
                layoutParams.width = child.getLayoutParams().width;
                layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                rootView.setLayoutParams(layoutParams);
            }
        }

    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        handler.removeCallbacksAndMessages(null);
    }
}

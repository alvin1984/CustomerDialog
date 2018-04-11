package com.mobile.customerdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

/**
 * Created by pxy on 2018/3/20.
 */

public class CustomerDialog {

    private BaseDialog mBaseDialog;

    public CustomerDialog(Context context){
        mBaseDialog = new BaseDialog(context);
    }

    public CustomerDialog setContainerView(int layoutResId){
        mBaseDialog.setContainerView(layoutResId);
        return this;
    }

    public CustomerDialog setContainerView(View view){
        mBaseDialog.setContainerView(view);
        return this;
    }



    public CustomerDialog addBtn(String title,int textColorId, final DialogClickListener listener){
        mBaseDialog.addBtn(title,textColorId, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(mBaseDialog,v);
            }
        });
        return this;
    }
    public CustomerDialog show(){
        mBaseDialog.show();
        return this;
    }

    public void dismiss(){
        mBaseDialog.dismiss();
    }


    public CustomerDialog addPositiveBtn(String title, final DialogClickListener listener){
        mBaseDialog.addPositiveBtn(title, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(mBaseDialog,v);
            }
        });
        return this;
    }

    public CustomerDialog addBtnPanel(int layoutId,final DialogClickListener listener){
        mBaseDialog.addBtnPanel(layoutId, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(mBaseDialog,v);
            }
        });
        return this;
    }

    public CustomerDialog addBtnPanel(int layoutId){
        mBaseDialog.addBtnPanel(layoutId);
        return this;
    }

    public CustomerDialog addNegativeBtn(String title, final DialogClickListener listener){
        mBaseDialog.addNegativeBtn(title,new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(mBaseDialog,v);
            }
        });
        return this;
    }

    public CustomerDialog setDialogRadius(int radiusDP){
        mBaseDialog.setDialogRadius(radiusDP);
        return this;
    }

    public CustomerDialog showFromBottom(){
        mBaseDialog.showFromBottom();
        return this;
    }

    /**
     * 设置弹窗出现动画
     * @param style 动画样式
     * @return 当前窗口对象
     */
    public CustomerDialog setWindowAnimation(int style){
        mBaseDialog.setWindowAnimation(style);
        return this;
    }

    /**
     * 窗口大小与屏幕保持一致，高度自适应
     * @return 当前窗口对象
     */
    public CustomerDialog setMatchParent() {
        mBaseDialog.setMatchParent();
        return this;
    }

    public CustomerDialog setDialogWidthSizeWithRate(float widthRate){
        mBaseDialog.setDialogWidthSizeWithRate(widthRate);
        return this;
    }

//    public CustomerDialog setWrapContentParent(){
//        mBaseDialog.setWrapContentParent();
//        return this;
//    }

    /**
     * 设置弹窗的显示时间
     * @param seconds 显示时间
     * @return 当前窗口对象
     */
    public CustomerDialog setLifeTime(int seconds){
        mBaseDialog.setLifeTime(seconds);
        return this;
    }

    public CustomerDialog setGravity(int gravity) {
        mBaseDialog.setGravity(gravity);
        return this;
    }

    public CustomerDialog setIsCancelable(boolean isCancelable) {
        mBaseDialog.setIsCancelable(isCancelable);
        return this;
    }

    public CustomerDialog setCanCancelOutside(boolean isCan){
        mBaseDialog.setCanCancelOutside(isCan);
        return this;
    }

    public CustomerDialog setBackgroundResource(int viewId, int resId) {
        mBaseDialog.setBackgroundResource(viewId,resId);
        return this;
    }

    /**
     * 设置指定view的显示文字内容
     * @param viewId 需要显示文字内容的view id
     * @param textId 文字的引用
     * @return 当前窗口对象
     */
    public CustomerDialog setText(int viewId, int textId) {
        mBaseDialog.setText(viewId,textId);
        return this;
    }

    /**
     * 设置指定view的显示文字内容
     * @param viewId 需要显示文字内容的view id
     * @param text 文字
     * @return 当前窗口对象
     */
    public CustomerDialog setText(int viewId, String text) {
        mBaseDialog.setText(viewId,text);
        return this;
    }

    /**
     * 设置指定view的显示文字颜色
     * @param viewId 需要显示文字内容的view id
     * @param colorId 文字颜色
     * @return 当前窗口对象
     */
    public CustomerDialog setTextColor(int viewId, int colorId) {
        mBaseDialog.setTextColor(viewId,colorId);
        return this;
    }

    /**
     * 设置指定view的显示图案
     * @param viewId 需要显示图案的view id
     * @param resId 图案的资源索引
     * @return 当前窗口对象
     */
    public CustomerDialog setImageResource(int viewId, int resId) {
        mBaseDialog.setImageResource(viewId,resId);
        return this;
    }

    public CustomerDialog setWindowBackground(int color){
        mBaseDialog.setWindowBackground(color);
        return this;
    }

    public CustomerDialog showCloseBtn(){
        mBaseDialog.showCloseBtn();
        return this;
    }

    public CustomerDialog setCloseBtnClickListener(final DialogClickListener listener){
        mBaseDialog.setCloseBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(mBaseDialog,v);
            }
        });
        return this;
    }

    public CustomerDialog showCloseBtn(final DialogClickListener clolseListener){
        mBaseDialog.showCloseBtn(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clolseListener.onClick(mBaseDialog,v);
            }
        });
        return this;
    }


    /**
     * 设置指定view的设置点击事件监听器
     * @param viewId 需要显示图案的view id
     * @param listener 点击事件监听器
     * @return 当前窗口对象
     */
    public CustomerDialog setViewOnClickListener(int viewId, final DialogClickListener listener) {
        mBaseDialog.setViewOnClickListener(viewId, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(mBaseDialog,v);
            }
        });
        return this;
    }

    public CustomerDialog setDialogSize(float widthDP,float heightDP){
        mBaseDialog.setDialogSize(widthDP,heightDP);
        return this;
    }
    public CustomerDialog setDialogWidthSize(float widthDP){
        mBaseDialog.setDialogWidthSize(widthDP);
        return this;
    }

    public interface DialogClickListener{
        void onClick(Dialog dialog, View v);
    }
}

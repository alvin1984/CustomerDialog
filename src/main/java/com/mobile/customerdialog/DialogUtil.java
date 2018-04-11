package com.mobile.customerdialog;

import android.content.Context;
import android.view.Gravity;

/**
 * Created by pxy on 2018/3/21.
 */

public class DialogUtil {

    public static CustomerDialog showProgressDialog(Context context){

        return new CustomerDialog(context)
                .setContainerView(R.layout.base_library_dialog_progress)
                .setDialogRadius(5)
                .setCanCancelOutside(false)
//                .showCloseBtn()
//                .setMatchParent()
//                .setDialogWidthSizeWithRate(0.8f)
                .setDialogSize(200,200)
//                .setWrapContentParent()
                .addBtnPanel(R.layout.base_library_dialog_btn_panel)
                .show();

    }

    public static CustomerDialog showFingerPrintDialog(Context context,CustomerDialog.DialogClickListener listener){
        return new CustomerDialog(context)
                .setContainerView(R.layout.base_library_dialog_customer)
                .setDialogRadius(10)
                .setDialogWidthSizeWithRate(0.9f)
                .setCanCancelOutside(false);
    }

    public static CustomerDialog showFingerPrintDialogFromBottom(Context context,CustomerDialog.DialogClickListener listener){
        return new CustomerDialog(context)
                .setContainerView(R.layout.base_library_dialog_customer)
                .setDialogRadius(0)
                .setGravity(Gravity.CENTER)
//                .setWindowAnimation(R.style.Base_Library_Dialog_Animation)
//                .setDialogSize(200,200)
//                .showCloseBtn(listener)
//                .setDialogWidthSizeWithRate(1f)
//                .addBtnPanel(R.layout.base_library_dialog_btn_panel)
                .addNegativeBtn("取消",listener)
                .addPositiveBtn("确定",listener)
                .setCanCancelOutside(false)
                .show();
    }

    public static CustomerDialog showFingerPrintDialog(Context context){
        return new CustomerDialog(context)
                .setContainerView(R.layout.base_library_dialog_customer)
                .setDialogRadius(0)
//                .setDialogWidthSize(200)
//                .setMatchParent()
//                .setWrapContentParent()
//                .setDialogSize(200,200)
//                .showCloseBtn()
                .setCanCancelOutside(false)
                .addBtnPanel(R.layout.base_library_dialog_btn_panel)
                .show();
    }

}

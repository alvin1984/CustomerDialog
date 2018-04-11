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
                .show();

    }

    public static CustomerDialog showFingerPrintDialog(Context context,CustomerDialog.DialogClickListener listener){
        return new CustomerDialog(context)
                .setContainerView(R.layout.base_library_dialog_customer)
                .setDialogRadius(10)
                .setDialogWidthSizeWithRate(0.8f)
                .setCanCancelOutside(false);
    }

    public static CustomerDialog showFingerPrintDialogFromBottom(Context context,CustomerDialog.DialogClickListener listener){
        return new CustomerDialog(context)
                .setContainerView(R.layout.base_library_dialog_customer)
                .setDialogRadius(0)
                .setGravity(Gravity.BOTTOM)
                .addNegativeBtn("取消",listener)
                .addPositiveBtn("确定",listener)
                .setMatchParent()
                .setCanCancelOutside(false)
                .show();
    }

    public static CustomerDialog showFingerPrintDialog(Context context){
        return new CustomerDialog(context)
                .setContainerView(R.layout.base_library_dialog_customer)
                .setDialogRadius(0)
                .setCanCancelOutside(false)
                .show();
    }

}

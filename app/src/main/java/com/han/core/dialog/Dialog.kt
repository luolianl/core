package com.han.core.dialog

import android.app.Activity

class Dialog {
}

fun Activity.showDialog(title: String, sure:String = "确定", cancel:String = "取消",sureCancel:Boolean=true, onNegative:(()->Unit)?=null, onPositive:()->Unit){
    NormalDialog(this).showDialog {
        title(text = title)
        sure(text = sure) {
            onPositive.invoke()
            if(sureCancel){
                dismiss()
            }
        }
        cancel(text =  cancel) {
            dismiss()
            onNegative?.invoke()
        }
    }
}


fun assertOneSet(
    method: String,
    b: Any?,
    a: Int?
) {
    if (a == null && b == null) {
        throw IllegalArgumentException("$method: You must specify a resource ID or literal value")
    }
}

package com.han.core.dialog

import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import com.han.core.R
import com.han.core.databinding.DialogNormalBinding
typealias DialogCallback = (NormalDialog) -> Unit
class NormalDialog(context: Context) : BaseDialog(context) {
   private lateinit var bind: DialogNormalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DialogNormalBinding.inflate(layoutInflater)
        setContentView(bind.root)
    }


    inline fun showDialog(func: NormalDialog.() -> Unit): NormalDialog = apply {
        this.show()
        this.func()
    }


    fun title(@StringRes res: Int? = null,
              text: String? = null): NormalDialog = apply{
        assertOneSet("title",text,res)

        if(res!=null) {
            bind.tvTitle.setText(res)
        }else{
            bind.tvTitle.text = text
        }
    }

    fun content(@StringRes res: Int? = null,
              text: String? = null): NormalDialog = apply{
        assertOneSet("title",text,res)

        if(res!=null) {
            bind.tvContent.setText(res)
        }else{
            bind.tvContent.text = text
        }
    }

    fun sure(
        @StringRes res: Int? = null,
        text: CharSequence? = null,
        click: DialogCallback? = null
    ): NormalDialog = apply {

        assertOneSet("title",text,res)

        if(res!=null) {
            bind.btnSure.setText(res)
        }else{
            bind.btnSure.text = text
        }

        bind.btnSure.setOnClickListener {
            click?.invoke(this)
        }
    }

    fun cancel(
        @StringRes res: Int? = null,
        text: CharSequence? = null,
        click: DialogCallback? = null
    ): NormalDialog = apply {

        assertOneSet("title",text,res)

        if(res!=null) {
            bind.btnCancel.setText(res)
        }else{
            bind.btnCancel.text = text
        }

        bind.btnCancel.setOnClickListener {
            click?.invoke(this)
        }

    }



}
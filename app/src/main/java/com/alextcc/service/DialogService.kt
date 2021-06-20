package com.alextcc.service

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.text.Editable
import android.text.InputType
import android.text.method.DigitsKeyListener
import android.widget.EditText
import com.alextcc.global.GlobalVariable
import kotlinx.coroutines.GlobalScope

class DialogService {

    private val globalVariable = GlobalVariable.getInstance()

    fun showdialog(context: Context){
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(context)
        builder.setTitle("Digite o IP :")

        val input = EditText(context)
        input.text = Editable.Factory.getInstance().newEditable(globalVariable.ipValue)
        input.setHint("***.***.***.***")
        input.inputType = InputType.TYPE_CLASS_NUMBER
        input.setKeyListener(DigitsKeyListener.getInstance("0123456789."));
        builder.setView(input)

// Set up the buttons
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            var ipValue = input.text.toString()
            globalVariable.ipValue = ipValue
        })
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        builder.show()
    }

}
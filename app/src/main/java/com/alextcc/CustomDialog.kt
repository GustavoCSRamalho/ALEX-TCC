package com.alextcc

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.os.StrictMode
import android.view.LayoutInflater
import android.widget.Toast
import com.alextcc.databinding.CustomDialogBinding
import com.alextcc.global.GlobalVariable
import java.lang.Exception
import java.net.URL


class CustomDialog(context: Context) : Dialog(context) {

    private lateinit var bindingDialog: CustomDialogBinding

    private val globalVariable = GlobalVariable.getInstance()

    init {
        setCancelable(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        bindingDialog = CustomDialogBinding.inflate(LayoutInflater.from(context));
        setContentView(bindingDialog.getRoot());

        bindingDialog.unlock.setOnClickListener {

            try {
                URL("http://${globalVariable.ipValue}/HIGH").readText()
                Toast.makeText(
                    context, "Destrancado!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                showError(context)
            }
        }

        bindingDialog.lock.setOnClickListener {

//            URL("http://192.168.43.11/LOW").readText()
            try {
                URL("http://${globalVariable.ipValue}/LOW").readText()
                Toast.makeText(
                    context, "Trancado!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } catch (e: Exception) {
                showError(context)
            }
        }

        bindingDialog.btnClose.setOnClickListener {
            dismiss()
        }
    }

    fun showError(context: Context) {
        Toast.makeText(
            context, "Erro ao executar comando",
            Toast.LENGTH_SHORT
        )
            .show()
    }
}
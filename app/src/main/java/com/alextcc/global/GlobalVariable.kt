package com.alextcc.global

class GlobalVariable {

    internal var ipValue : String = ""

    companion object{
        val globalVariable = GlobalVariable()

        fun getInstance(): GlobalVariable {
            return globalVariable
        }
    }
}
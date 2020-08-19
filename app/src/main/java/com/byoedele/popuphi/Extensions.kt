package com.byoedele.popuphi

import android.content.Context
import android.widget.Toast



/**
 *  This is an extended function to show toasts on the Context class.
 *  It abstract away the boilerplate code.
 */
fun Context.showToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
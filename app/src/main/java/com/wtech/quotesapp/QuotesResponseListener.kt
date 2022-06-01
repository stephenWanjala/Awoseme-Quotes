package com.wtech.quotesapp

import java.security.MessageDigest

interface QuotesResponseListener {

    fun didAfetch(response:List<QuotesResponse>,mesaage:String)
    fun didError(message:String)
}
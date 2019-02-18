package com.safecam.easyquote.presenter

import com.google.firebase.auth.FirebaseAuth
import com.safecam.easyquote.presenter.contract.LoginActivityContract

/**
 * @author Darien
 */
class LoginActivityPresenter(val view: LoginActivityContract.View, private val auth: FirebaseAuth) : LoginActivityContract.Presenter {

    override fun isLoggedIn(): Boolean {
        return auth.currentUser?.let { true } ?: false
    }

    override fun isEmailVerified(): Boolean {
        return auth.currentUser?.let {
            return it.isEmailVerified
        } ?: false
    }

    override fun logIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                view.navigateToMain()
            } else {
                view.showAuthenticationFailure()
            }
        }
    }
}
package com.safecam.easyquote.presenter

import com.google.firebase.auth.FirebaseAuth
import com.safecam.easyquote.presenter.contract.CreateAccountContract

/**
 * Create Account Presenter
 *
 * @author Darien
 */
class CreateAccountPresenter(val view: CreateAccountContract.View, private val auth: FirebaseAuth) : CreateAccountContract.Presenter {

    override suspend fun createAccount(email: String, password: String) {
        val firebaseUser = auth.createUserWithEmailAndPassword(email, password).result?.user

        if (firebaseUser != null) {
            // show success message
            view.userCreatedSuccessfully()
        } else {
            // show error message
            view.showErrorMessage()
        }
    }
}
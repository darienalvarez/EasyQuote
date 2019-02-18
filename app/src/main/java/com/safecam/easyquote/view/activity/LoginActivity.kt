package com.safecam.easyquote.view.activity

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.safecam.easyquote.R
import com.safecam.easyquote.presenter.contract.LoginActivityContract
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.ParameterList

/**
 * Login Activity
 *
 * @author Darien
 */
class LoginActivity: BaseActivity(), LoginActivityContract.View {

    val presenter: LoginActivityContract.Presenter by inject{ ParameterList(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (presenter.isLoggedIn()) {
            // navigate inside the app
            navigateToMain()
        }

        loginBtn.setOnClickListener { onLoginClick(emailEditText.text.toString(), passwordEditText.text.toString()) }
        recoverPasswordBtn.setOnClickListener { navigateToRecoverPassword() }
        signUpBtn.setOnClickListener { navigateToCreateAccount() }
    }

    private fun onLoginClick(email: String, password: String) {
        presenter.logIn(email, password)
    }

    override fun showAuthenticationFailure() {
        Snackbar.make(rootView, R.string.authenticationFails, Snackbar.LENGTH_LONG).show()
    }

    override fun navigateToMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun navigateToCreateAccount() {
        startActivity(Intent(this, AccountCreateActivity::class.java))
    }

    override fun navigateToRecoverPassword() {
        startActivity(Intent(this, AccountRecoveryActivity::class.java))
    }

    override fun navigateToAccountNotVerified() {

    }
}
package com.safecam.easyquote.view.activity

import android.app.AlertDialog
import android.os.Bundle
import com.safecam.easyquote.R
import com.safecam.easyquote.presenter.contract.CreateAccountContract
import com.safecam.easyquote.util.ProgressUtil
import com.safecam.easyquote.util.isValidEmail
import com.safecam.easyquote.util.isValidPassword
import kotlinx.android.synthetic.main.activity_account_create.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class AccountCreateActivity : BaseActivity(), CreateAccountContract.View {

    val presenter: CreateAccountContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_create)

        createAccountBtn.setOnClickListener { onCreateAccountClick() }
    }

    override suspend fun userCreatedSuccessfully() = withContext(Dispatchers.Main) {
        hideProgress()

        AlertDialog.Builder(this@AccountCreateActivity)
                .setCancelable(false)
                .setTitle(R.string.info)
                .setMessage(R.string.user_created)
                .setPositiveButton(R.string.ok) { dialog, _ ->
                    dialog.dismiss()
                    finish()
                }
                .create()
                .show()
    }

    override suspend fun showErrorMessage() = withContext(Dispatchers.Main) {
        hideProgress()

        AlertDialog.Builder(this@AccountCreateActivity)
                .setCancelable(false)
                .setTitle(R.string.error)
                .setMessage(R.string.error_user_creation)
                .setPositiveButton(R.string.ok) { dialog, _ ->
                    dialog.dismiss()
                    finish()
                }
                .create()
                .show()
    }

    private fun onCreateAccountClick() = launch(Dispatchers.Main) {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val passConfirm = confirmPasswordEditText.text.toString()

        if (validate(email, password, passConfirm)) {
            showProgress()

            withContext(Dispatchers.IO) {
                presenter.createAccount(email, password)
            }
        }
    }

    private fun validate(email: String, password: String, passConfirm: String): Boolean {
        var isValid = true

        emailEditText.error = null
        if (!email.isValidEmail()) {
            // show error
            emailEditText.error = getString(R.string.error_email_invalid)
            isValid = false
        }

        passwordEditText.error = null
        if (!password.isValidPassword()) {
            // show error
            emailEditText.error = getString(R.string.error_pass_invalid)
            isValid = false
        }

        confirmPasswordEditText.error = null
        if (password != passConfirm) {
            // show error
            confirmPasswordEditText.error = getString(R.string.error_pass_not_match)
            isValid = false
        }

        return isValid
    }

    private fun showProgress() {
        ProgressUtil.showLoading(this)
    }

    private fun hideProgress() {
        ProgressUtil.hideLoading(this)
    }
}

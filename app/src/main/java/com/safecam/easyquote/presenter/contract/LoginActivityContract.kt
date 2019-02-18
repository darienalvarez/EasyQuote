package com.safecam.easyquote.presenter.contract

/**
 * Login activity Contract
 *
 * @author Darien
 */
interface LoginActivityContract {

    interface View: BaseView, Navigation {

        /**
         * On authentication fails
         */
        fun showAuthenticationFailure()
    }

    interface Presenter: BasePresenter<View> {

        /**
         * Check if the user is already logged in
         */
        fun isLoggedIn(): Boolean

        /**
         * Check if the user's email is verified
         */
        fun isEmailVerified(): Boolean

        /**
         * Log in user
         */
        fun logIn(email: String, password: String)
    }

    interface Navigation {

        fun navigateToMain()

        fun navigateToCreateAccount()

        fun navigateToRecoverPassword()

        fun navigateToAccountNotVerified()
    }

}
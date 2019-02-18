package com.safecam.easyquote.presenter.contract

/**
 * @author Darien
 */
interface CreateAccountContract {

    interface View: BaseView {

        suspend fun userCreatedSuccessfully()

        suspend fun showErrorMessage()
    }

    interface Presenter: BasePresenter<View> {

        suspend fun createAccount(email: String, password: String)
    }
}
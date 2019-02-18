package com.safecam.easyquote.presenter.di

import com.google.firebase.auth.FirebaseAuth
import com.safecam.easyquote.presenter.LoginActivityPresenter
import com.safecam.easyquote.presenter.contract.LoginActivityContract

/**
 * Presenter module will provide instances of Presenters
 * @author Darien
 */
class PresenterModule {

    companion object {
        val module = org.koin.dsl.module.module {
            factory<LoginActivityContract.Presenter> { parameterList -> LoginActivityPresenter(parameterList[0], get()) }
        }
    }
}
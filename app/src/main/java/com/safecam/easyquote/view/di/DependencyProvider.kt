package com.safecam.easyquote.view.di

import com.safecam.easyquote.presenter.di.PresenterModule
import com.safecam.easyquote.repository.di.RepositoryModule

/**
 * @author Darien
 */
class DependencyProvider {

    companion object {
        val modules = listOf(PresenterModule.module, RepositoryModule.module)
    }
}
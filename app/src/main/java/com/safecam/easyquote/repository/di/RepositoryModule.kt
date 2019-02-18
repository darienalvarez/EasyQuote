package com.safecam.easyquote.repository.di

import com.google.firebase.auth.FirebaseAuth

/**
 * Repository Module
 * @author Darien
 */
class RepositoryModule {

    companion object {
        val module = org.koin.dsl.module.module {
            single { FirebaseAuth.getInstance() }
        }
    }
}
package com.example.employeeviewer.ui.main

import com.example.employeeviewer.App
import com.example.employeeviewer.navigation.Screens
import moxy.MvpPresenter

class MainPresenter : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        App.INSTANCE.router.newRootScreen(Screens.specialty())
    }
}
package com.dicoding.mysimplelogin

import org.junit.Assert.*
import org.junit.*
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class MainActivityTest : KoinTest {

    private val userRepository: UserRepository by inject()
    private val username = "Ahmad Rudi"

    @Before
    fun before() {
        loadKoinModules(storageModule)
        userRepository.loginUser(username)
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun getUsernameFromRepository() {
        val requestedUsername = userRepository.getUser()
        assertEquals(username, requestedUsername)
    }
}
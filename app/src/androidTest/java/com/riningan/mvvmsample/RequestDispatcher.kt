package com.riningan.mvvmsample

import androidx.test.platform.app.InstrumentationRegistry
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.io.IOException
import java.nio.charset.Charset


class RequestDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest) = MockResponse().apply {
        when {
            request.path.contains("/pokemon?offset=0&limit=10") -> setResponseCode(200).setBody(readAsset("pokemon_offset_0_limit_10.json"))
            request.path.contains("/pokemon?offset=10&limit=10") -> setResponseCode(200).setBody(readAsset("pokemon_offset_10_limit_10.json"))
            request.path.contains("/pokemon?offset=20&limit=10") -> setResponseCode(200).setBody(readAsset("pokemon_offset_20_limit_10.json"))
            request.path.contains("/pokemon/") -> setResponseCode(200).setBody(readAsset("pokemon_bulbasaur.json"))
            else -> setResponseCode(404)
        }
    }


    private fun readAsset(name: String): String? {
        return try {
            val inputStream = InstrumentationRegistry.getInstrumentation().context.assets.open(name)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}
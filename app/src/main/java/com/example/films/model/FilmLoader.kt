package com.example.films.model

import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import com.example.films.model.server.FilmDTO
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

class FilmLoader(
    private val listener: FilmLoaderListener,
    private val id1: Int,
    private val id2: Int,
    private val apiKey: String
) {

    @RequiresApi(Build.VERSION_CODES.N)
    fun loadFilm(): FilmDTO? {
        val films: ArrayList<FilmDTO> = ArrayList()
        Looper.prepare()
        try {
            val handler = Handler()
            Thread(Runnable {
                for (id in id1 until id2) {
                    val uri = URL("https://api.themoviedb.org/3/movie/${id}?api_key=${apiKey}")
                    lateinit var urlConnection: HttpsURLConnection
                    try {
                        urlConnection = uri.openConnection() as HttpsURLConnection
                        urlConnection.requestMethod = "GET"
                        urlConnection.readTimeout = 10000
                        val bufferedReader =
                            BufferedReader(InputStreamReader(urlConnection.inputStream))
                        val filmDTO: FilmDTO =
                            Gson().fromJson(getLines(bufferedReader), FilmDTO::class.java)
                        films.add(filmDTO)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        listener.onFailed(e)
                    } finally {
                        urlConnection.disconnect()
                    }
                }
                handler.post { listener.onLoaded(films) }
            }).start()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            listener.onFailed(e)
        } finally {
            Looper.loop()
        }
        return null
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader: BufferedReader): String {
        return reader.lines().collect(Collectors.joining("\n"))
    }

    interface FilmLoaderListener {
        fun onLoaded(dtoList: ArrayList<FilmDTO>)
        fun onFailed(throwable: Throwable)
    }
}
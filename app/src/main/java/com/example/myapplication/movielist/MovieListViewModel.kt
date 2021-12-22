package com.example.myapplication.movielist

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.myapplication.network.Movies
import com.example.myapplication.network.MoviesApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel(application: Application) : AndroidViewModel(application) {

    val app = application


    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

    // The internal MutableLiveData String that stores the most recent response
    private val _movies = MutableLiveData<Movies>()

    // The external immutable LiveData for the response String
    val movies: LiveData<Movies>
        get() = _movies



    private fun getMovies() {

    viewModelScope.launch {
        try {
            val listResult = MoviesApi.retrofitService.getMostPopular()
            _movies.value = listResult
            _response.value = "Success : ${listResult.results.size} Movies retrieved"
            Log.v("View Model","${_response.value}" )
        }catch(e: Exception){
            _response.value = "Failure "+ e.message
            Log.v("View Model","${_response.value}" )
        }
    }

//       MoviesApi.retrofitService.getMostPopular().enqueue(object: Callback<Movies>{
//           override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
//               _response.value = "Success : ${response.body()} Movies retrieved"
//               Log.v("View Model","${_response.value}" )
//           }
//
//           override fun onFailure(call: Call<Movies>, t: Throwable) {
//            _response.value = "Failure "+ t.message
//               Log.v("View Model", "${_response.value}")
//           }
//
//
//       })

    }

    init {
        getMovies()
    }
}


    class MovieListViewModelFactory(private val application: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
                return MovieListViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

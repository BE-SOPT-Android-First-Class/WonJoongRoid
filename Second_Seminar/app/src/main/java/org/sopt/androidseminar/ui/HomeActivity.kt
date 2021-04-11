package org.sopt.androidseminar.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidseminar.R
import org.sopt.androidseminar.adapters.RepositoryAdapter
import org.sopt.androidseminar.data.RepositoryInfo
import org.sopt.androidseminar.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private val activityName = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(activityName, "onCreate")

        var repoList = mutableListOf<RepositoryInfo>()
        val repoAdapter = RepositoryAdapter()
        val repoRecyclerView = findViewById<RecyclerView>(R.id.rv_repository)
        repoList = repoDataInput(repoList)
        repoAdapter.data = repoList
        repoRecyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        repoRecyclerView.adapter = repoAdapter
        repoRecyclerView.setHasFixedSize(false)

        moreButtonClickedEvent()
    }

    private fun moreButtonClickedEvent(){
        binding.btMore.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }
    }

    private fun repoDataInput(repoList : MutableList<RepositoryInfo>) : MutableList<RepositoryInfo>{
        for(i in 1..10){
            repoList.add(RepositoryInfo("레포지토리 이름".plus(i), "레포지토리 설명".plus(i), "레포지토리 언어".plus(i)))
        }
        //Repository 이름이나 설명이 긴 경우 처리를 보여주기 위해 임시로 추가
        repoList.add(RepositoryInfo("레포지토리 이름레포지토리 이름레포지토리 이름레포지토리 이름레포지토리 이름레포지토리 이름레포지토리 이름", "레포지토리 설명레포지토리 설명레포지토리 설명레포지토리 설명레포지토리 설명", "레포지토리 언어"))
        return repoList
    }

    override fun onStart() {
        super.onStart()
        Log.d(activityName, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(activityName, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(activityName, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(activityName, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(activityName, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(activityName, "onDestroy")
    }

}
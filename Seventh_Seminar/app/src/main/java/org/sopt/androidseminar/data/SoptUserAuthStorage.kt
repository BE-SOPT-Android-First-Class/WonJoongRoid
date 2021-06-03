package org.sopt.androidseminar.data

import android.content.Context

object SoptUserAuthStorage {
    // 상수는 앞에 const를 붙인다.
    private const val STORAGE_KEY = "user_auth"
    private const val USER_ID = "id"
    private const val USER_PASSWORD = "password"

    fun saveUserId(context: Context, id: String) {
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY", Context.MODE_PRIVATE
        )
        sharedPreferences.edit()
            .putString(USER_ID, id)
            .apply()
    }

    fun saveUserPw(context: Context, pw: String) {
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY", Context.MODE_PRIVATE
        )
        sharedPreferences.edit()
            .putString(USER_PASSWORD, pw)
            .apply()
    }

    private fun getUserId(context: Context): String {
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(USER_ID, "") ?: ""
    }

    private fun getUserPw(context: Context): String {
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(USER_PASSWORD, "") ?: ""
    }

    fun clearAuthStorage(context: Context) {
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        sharedPreferences.edit().clear().apply()
    }

    fun hasUserData(context: Context) =
        getUserId(context).isNotEmpty() && getUserPw(context).isNotEmpty()
}
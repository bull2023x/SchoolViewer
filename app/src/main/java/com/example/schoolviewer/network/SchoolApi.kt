package com.example.schoolviewer.network

import com.example.schoolviewer.model.SchoolV2Dto
import com.example.schoolviewer.model.VersionDto
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolApi {
    @GET("api/version")
    suspend fun getVersion(): VersionDto

    @GET("schools-v2")
    suspend fun getSchools(): List<SchoolV2Dto>

    @GET("schools-v2")
    suspend fun searchByName(
        @Query("name") name: String
    ): List<SchoolV2Dto>
}

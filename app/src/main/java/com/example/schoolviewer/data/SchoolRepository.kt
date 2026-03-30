package com.example.schoolviewer.data

import com.example.schoolviewer.model.SchoolV2Dto
import com.example.schoolviewer.model.VersionDto
import com.example.schoolviewer.network.SchoolApi

class SchoolRepository(
    private val api: SchoolApi
) {
    suspend fun getVersion(): VersionDto {
        return api.getVersion()
    }

    suspend fun getSchools(): List<SchoolV2Dto> {
        return api.getSchools()
    }
}

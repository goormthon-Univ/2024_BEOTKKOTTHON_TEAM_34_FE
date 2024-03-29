package com.goorm.kkiri.data.remote

import com.goorm.kkiri.domain.model.base.BaseResponse
import com.goorm.kkiri.domain.model.request.Pageable
import com.goorm.kkiri.domain.model.response.BoardDetailDto
import com.goorm.kkiri.domain.model.response.BoardHomeDto
import com.goorm.kkiri.domain.model.response.BoardPageDto
import com.goorm.kkiri.domain.model.response.MyResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BoardService {

    @GET("/api/board/{type}")
    suspend fun getBoardByPage(
        @Path("type") type: String,
        @Query("page") page: Int
    ): BaseResponse<BoardPageDto>

    @GET("api/board/user/{userId}")
    suspend fun getMyWrittenByPage(
        @Path("userId") userId: Long,
        @Query("type") type: String,
        @Query("page") page: Int
    ): BaseResponse<MyResult>

    @GET("/api/board/detail/{boardId}")
    suspend fun getBoardDetail(
        @Path("boardId") boardId: Long
    ): BaseResponse<BoardDetailDto>

    @GET("/api/board/home/{type}")
    suspend fun getHomeBoard(
        @Path("type") type: String,
        @Query("page") page: Int
    ): BaseResponse<List<BoardHomeDto>>

    @GET("/api/board/search")
    suspend fun searchBoard(
        @Query("title") title: String,
        @Query("description") description: String,
        @Query("page") page: Int
    ): BaseResponse<BoardPageDto>
}
package com.goorm.kkiri.domain.repository

import com.goorm.kkiri.domain.model.base.BaseResponse
import com.goorm.kkiri.domain.model.response.ChatRoomDetailDto
import com.goorm.kkiri.domain.model.response.MessageDto
import kotlinx.coroutines.flow.Flow

interface ChattingRepository {
    suspend fun getChattingByRoomId(chatRoomId : String) : Flow<BaseResponse<MessageDto>>
    suspend fun getChatRoomByBoardId(boardId: Long, senderId: Long): Flow<BaseResponse<ChatRoomDetailDto>>
}
package com.chat.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class ChatMessage
{
    private String content;
    private String sender;
    private MessageType type;
}

package com.tchau.message.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Message extends BaseDomain {
    private String senderId;
    private String textMessage;
}
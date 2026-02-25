package com.example.demo.reply.model;

import com.example.demo.board.model.Board;
import com.example.demo.board.model.BoardDto;
import lombok.Builder;
import lombok.Getter;

public class ReplyDto {

    @Builder
    @Getter
    public static class ListRes {
        private String contents;
        private String userName;

        public static ListRes from(Reply entity) {
            return ListRes.builder()
                    .contents(entity.getContents())
                    .userName(entity.getUsers().getName())
                    .build();
        }
    }
}

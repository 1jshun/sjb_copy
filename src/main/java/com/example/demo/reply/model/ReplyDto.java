package com.example.demo.reply.model;

import com.example.demo.board.model.Board;
import com.example.demo.user.model.User;
import lombok.*;

public class ReplyDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Req {
        private String contents;
        private Long boardIdx;
        private Long userIdx;

        public Reply toEntity(Board board, User user) {
            return Reply.builder()
                    .contents(this.contents)
                    .board(board)
                    .users(user)
                    .build();
        }
    }

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

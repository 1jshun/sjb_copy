package com.example.demo.board.model;

import com.example.demo.reply.model.ReplyDto;
import com.example.demo.user.model.User;
import lombok.*;

import java.util.List;

public class BoardDto {
    @Getter
    public static class RegReq {
        private String title;
        private String contents;

        public Board toEntity() {
            return Board.builder()
                    .title(this.title)
                    .contents(this.contents)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class RegRes {
        private Long idx;
        private String title;
        private String contents;

        public static RegRes from(Board entity) {
            return RegRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String title;
        private String userName;
        private int count;

        public static ListRes from(Board entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .userName(entity.getUser().getName())
                    .count(entity.getList().size())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ReadRes {
        private Long idx;
        private String title;
        private String contents;
        private String userName;
        private List<ReplyDto.ListRes> replyList;

        public static ReadRes from(Board entity) {
            return ReadRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .userName(entity.getUser().getName())
                    .replyList(entity.getList().stream().map(ReplyDto.ListRes::from).toList())
                    .build();
        }
    }
}

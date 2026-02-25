package com.example.demo.reply;

import com.example.demo.reply.model.Reply;
import com.example.demo.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    public List<ReplyDto.ListRes> list() {
        List<Reply> replyList = replyRepository.findAll();
        return replyList.stream().map(ReplyDto.ListRes::from).toList();
    }
}

package com.example.demo.reply;

import com.example.demo.board.BoardRepository;
import com.example.demo.board.model.Board;
import com.example.demo.reply.model.Reply;
import com.example.demo.reply.model.ReplyDto;
import com.example.demo.user.UserRepository;
import com.example.demo.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public void register(ReplyDto.Req dto) {
        Board board = boardRepository.findById(dto.getBoardIdx()).orElseThrow();
        User user = userRepository.findById(dto.getUserIdx()).orElseThrow();
        Reply reply = dto.toEntity(board, user);
        replyRepository.save(reply);
    }

    public List<ReplyDto.ListRes> list() {
        List<Reply> replyList = replyRepository.findAll();
        return replyList.stream().map(ReplyDto.ListRes::from).toList();
    }
}

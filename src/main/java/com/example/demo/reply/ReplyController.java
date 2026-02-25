package com.example.demo.reply;

import com.example.demo.common.model.BaseResponse;
import com.example.demo.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/reply")
@RequiredArgsConstructor
@RestController
public class ReplyController {
    private final ReplyService replyService;

    @GetMapping("/list")
    public ResponseEntity list() {
        List<ReplyDto.ListRes> dto = replyService.list();
        return ResponseEntity.ok(BaseResponse.success(dto));
    }
}

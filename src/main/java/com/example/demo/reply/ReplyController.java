package com.example.demo.reply;

import com.example.demo.common.model.BaseResponse;
import com.example.demo.relation.model.B;
import com.example.demo.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reply")
@RequiredArgsConstructor
@RestController
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/write")
    public ResponseEntity write(@RequestBody ReplyDto.Req dto) {
        replyService.register(dto);
        return ResponseEntity.ok(BaseResponse.success("성공"));
    }
    @GetMapping("/list")
    public ResponseEntity list() {
        List<ReplyDto.ListRes> dto = replyService.list();
        return ResponseEntity.ok(BaseResponse.success(dto));
    }
}

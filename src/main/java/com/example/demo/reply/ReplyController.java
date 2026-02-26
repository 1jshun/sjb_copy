package com.example.demo.reply;

import com.example.demo.common.model.BaseResponse;
import com.example.demo.relation.model.B;
import com.example.demo.reply.model.ReplyDto;
import com.example.demo.user.model.AuthUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reply")
@RequiredArgsConstructor
@RestController
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/reg/{boardIdx}")
    public ResponseEntity reg(
            @AuthenticationPrincipal AuthUserDetails user,
            @PathVariable Long boardIdx) {

        System.out.println(user);

        return ResponseEntity.ok(
                BaseResponse.success("성공")
        );
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        List<ReplyDto.ListRes> dto = replyService.list();
        return ResponseEntity.ok(BaseResponse.success(dto));
    }
}

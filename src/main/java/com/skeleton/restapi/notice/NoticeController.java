package com.skeleton.restapi.notice;

import com.skeleton.restapi.common.CommonController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NoticeController extends CommonController {

    private final NoticeService noticeService;

    @GetMapping("/notices")
    public ResponseEntity<?> users(Pageable pageable) {
        return responseSuccess(noticeService.findAll(pageable));
    }

}

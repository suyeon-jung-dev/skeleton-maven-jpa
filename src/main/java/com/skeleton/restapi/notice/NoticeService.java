package com.skeleton.restapi.notice;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Transactional
@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public Page<Notice> findAll(Pageable pageable) {
        Assert.notNull(pageable, "Pageable must not be null!");
        return noticeRepository.findAll(pageable);
    }
}

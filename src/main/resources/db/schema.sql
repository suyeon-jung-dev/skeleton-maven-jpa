drop table skeleton.notice;

CREATE TABLE IF NOT EXISTS skeleton.notice
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '공지 번호',
    title       VARCHAR(255)                       NOT NULL COMMENT '공지 제목',
    description TEXT                               NULL COMMENT '공지 내용',
    cdate       DATETIME NULL COMMENT '생성일자',
    cuser       VARCHAR(30)                        NULL COMMENT '생성자',
    udate       DATETIME NULL COMMENT '수정일자',
    uuser       VARCHAR(30)                        NULL COMMENT '수정자'
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT '공지사항';

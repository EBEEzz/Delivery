--delivery
CREATE TABLE board(
    bno number(6)
        CONSTRAINT BOARD_BNO_PK PRIMARY KEY,
    bmno number(4)
        CONSTRAINT BOARD_BMNO_NN NOT NULL
        CONSTRAINT BOARD_BMNO_FK REFERENCES member(mno),
    title VARCHAR2(40 CHAR)
        CONSTRAINT BOARD_TITLE_NN NOT NULL,
    body VARCHAR2(4000)
        CONSTRAINT BOARD_BODY_NN NOT NULL,
    wdate DATE DEFAULT sysdate
        CONSTRAINT BOARD_WDATE_NN NOT NULL,
    click NUMBER(3) DEFAULT 0
        CONSTRAINT BOARD_CLICK_NN NOT NULL,
    larea VARCHAR2(10 CHAR)
        CONSTRAINT BOARD_BAREA_NN NOT NULL
        CONSTRAINT BOARD_BAREA_FK REFERENCES largearea(city),
    marea VARCHAR2(10 CHAR)
        CONSTRAINT BOARD_MAREA_NN NOT NULL
        CONSTRAINT BOARD_MAREA_FK REFERENCES middlearea(city),
    sarea VARCHAR2(10 CHAR)
        CONSTRAINT BOARD_SAREA_NN NOT NULL
        CONSTRAINT BOARD_SAREA_FK REFERENCES smallarea(city),
    end NUMBER(3)
        CONSTRAINT BOARD_END_NN NOT NULL,
    isshow CHAR(1) DEFAULT 'Y'
        CONSTRAINT BOARD_ISSHOW_NN NOT NULL
        CONSTRAINT BOARD_ISSHOW_CK CHECK(isshow IN('Y','N')),
    category VARCHAR2(10CHAR)
        CONSTRAINT BOARD_CATEGORY_NN NOT NULL
        CONSTRAINT BOARD_CATEGORY_FK REFERENCES menucategory(foodtype),
    rest NUMBER(6)
        CONSTRAINT BOARD_REST_FK REFERENCES restaurant(restno)
);


INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1001, '족발먹을사람', '족발먹을사람 구해요', '서울특별시', '종로구', '사직동', 8, '족발·보쌈'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1003, '치킨먹자', '오늘밤 치킨먹자', '서울특별시', '중구', '소공동', 4, '치킨'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1005, '오늘밤엔피맥해요', '배달료 비싼데 같이 피자 먹을사람 구해요', '서울특별시', '중구', '청구동', 2, '피자'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1002, '떡볶이순대튀김', '오늘같은 날엔 떡볶이와 순대와 튀김 아니겠어요 저희 같이 공동구매해서 배달료 아끼고 맛있게 먹어요', '서울특별시', '용산구', '후암동', 2, '분식'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1004, '갈비인가 통닭인가 수원 왕갈비 통닭', '영화보는데 너무 맛있어보여서 급히 생각나서 글 올려봐요 같이 시키실분 계신가요', '서울특별시', '중구', '신당동', 1, '치킨'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1006, '테스트입니다.', '무엇을 먹어야할지 생각하는 테스트입니다.', '서울특별시', '중구', '신당동', 1, '치킨'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1001, '먹자.', '밥먹자.', '서울특별시', '종로구', '사직동', 2, '치킨'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1003, '먹세먹세 젊어서 먹세.', '다먹자.', '서울특별시', '종로구', '삼청동', 2, '치킨'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1004, '배고파요', '파스타 시키실분 계신가요', '경기도', '강화군', '강화읍', 3, '양식'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1006, '피자먹자피자피자', '피자피자피피자피자', '경상도', '금정구', '서제1동', 3, '피자'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1002, '치킨이요', '치킨먹고싶어요', '경상도', '금정구', '서제1동', 3, '치킨'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1003, '삼겹살먹자', '삼겹살 고고', '경상도', '금정구', '서제1동', 3, '고기·구이'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1004, '스테이크', '빕스or아웃백', '경상도', '금정구', '서제1동', 3, '양식'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1004, '맛있는거 먹고싶지 않아요?.', '지금 딱히 생각나는 음식은 없지만 8시간 뒤 치킨이 먹고싶을거 같아요.', '서울특별시', '종로구', '사직동', 8, '치킨'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1005, '테스트용', '테스트 해보자 얼른.', '서울특별시', '종로구', '사직동', 6, '치킨'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1006, 'ㅋㅋㅋㅋㅋㅋㅋㅋ', '좀더 빨리 해라', '서울특별시', '종로구', '사직동', 2, '도시락'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1002, '이번엔 고기다', '고기먹자', '서울특별시', '종로구', '사직동', 1, '고기·구이'
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1001, '배고프다', '삼겹살 콜?', '서울특별시', '종로구', '사직동', 12, '고기·구이'
);



INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category, rest)
VALUES(
    777, 1001, '제발...','자고싶어..', '서울특별시','종로구','사직동', 12,'중식',3
);

commit;
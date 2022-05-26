--system에서 진행
CREATE USER delivery IDENTIFIED BY 12345 ACCOUNT UNLOCK;
GRANT resource, connect To delivery;
GRANT UNLIMITED TABLESPACE, CREATE SESSION, connect, resource TO delivery;
ALTER USER delivery DEFAULT TABLESPACE USERs;


--delivery에서 진행
CREATE TABLE member(
    mno NUMBER(4)
        CONSTRAINT MEMBER_MNO_PK PRIMARY KEY,
    name VARCHAR(20 CHAR)
        CONSTRAINT MEMBER_NAME_NN NOT NULL,
    id VARCHAR2(10 CHAR)
        CONSTRAINT MEMBER_ID_NN NOT NULL
        CONSTRAINT MEMBER_ID_UK UNIQUE,
    kakaoid VARCHAR2(50 CHAR)
        CONSTRAINT MEMBER_KAKAOID_UK UNIQUE,
    pw VARCHAR2(15 CHAR)
        CONSTRAINT MEMBER_PW_NN NOT NULL,
    mail VARCHAR2(50 CHAR)
        CONSTRAINT MEMBER_MAIL_NN NOT NULL
        CONSTRAINT MEMBER_MAIL_UK UNIQUE,
    tel VARCHAR2(13 CHAR)
        CONSTRAINT MEMBER_TEL_NN NOT NULL
        CONSTRAINT MEMBER_TEL_UK UNIQUE,
    avt NUMBER(2)
        CONSTRAINT MEMBER_AVT_NN NOT NULL,
    addr VARCHAR2(60 CHAR)
        CONSTRAINT MEMBER_ADDR_NN NOT NULL,
    jdate DATE DEFAULT sysdate
        CONSTRAINT MEMBER_JDATE_NN NOT NULL,
    isshow CHAR(1) DEFAULT 'Y'
        CONSTRAINT MEMBER_ISSHOW_NN NOT NULL
        CONSTRAINT MEMBER_ISSHOW_CK CHECK(isshow IN('Y','N')),
    esti NUMBER(3) DEFAULT 0
        CONSTRAINT MEMBER_ESTI_NN NOT NULL
);



CREATE TABLE largearea(
    city VARCHAR2(10 CHAR)
        CONSTRAINT LARGEAREA_CITY_PK PRIMARY KEY,
    code NUMBER(3)
        CONSTRAINT LARGEAREA_CODE_NN NOT NULL
        CONSTRAINT LARGEAREA_CODE_UK UNIQUE
);

CREATE TABLE middlearea(
    city VARCHAR2(10 CHAR)
        CONSTRAINT MIDDLEAREA_CITY_PK PRIMARY KEY,
    lcode NUMBER(3)
        CONSTRAINT MIDDLEAREA_LCODE_NN NOT NULL
        CONSTRAINT MIDDLEAREA_LCODE_FK REFERENCES largearea(code),
    code NUMBER(3)
        CONSTRAINT MIDDLEAREA_CODE_NN NOT NULL
        CONSTRAINT MIDDLEAREA_CODE_UK UNIQUE
);

CREATE TABLE smallarea(
    city VARCHAR2(10 CHAR)
        CONSTRAINT SMALLAREA_MCITY_PK PRIMARY KEY,
    lcode NUMBER(3)
        CONSTRAINT SMALLAREA_LCODE_NN NOT NULL
        CONSTRAINT SMALLAREA_LCODE_FK REFERENCES largearea(code),
    mcode NUMBER(3)
        CONSTRAINT SMALLAREA_MCODE_NN NOT NULL
        CONSTRAINT SMALLAREA_MCODE_FK REFERENCES middlearea(code),
    code NUMBER(4)
        CONSTRAINT SMALLAREA_CODE_NN NOT NULL
        CONSTRAINT SMALLAREA_CODE_UK UNIQUE
);

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
        CONSTRAINT BOARD_ISSHOW_CK CHECK(isshow IN('Y','N'))
);



INSERT INTO
    largearea
VALUES(
    '서울특별시', 1
);

INSERT INTO
    middlearea
VALUES(
    '종로구', 1, 1 
);
INSERT INTO
    middlearea
VALUES(
    '중구', 1, 2
);
INSERT INTO
    middlearea
VALUES(
    '용산구', 1, 3
);
INSERT INTO
    middlearea
VALUES(
    '성동구', 1, 4
);
INSERT INTO
    middlearea
VALUES(
    '광진구', 1, 5
);
INSERT INTO
    middlearea
VALUES(
    '동대문구', 1, 6
);
INSERT INTO
    middlearea
VALUES(
    '중랑구', 1, 7
);
INSERT INTO
    middlearea
VALUES(
    '성북구', 1, 8
);
INSERT INTO
    middlearea
VALUES(
    '강북구', 1, 9
);
INSERT INTO
    middlearea
VALUES(
    '도봉구', 1, 10 
);
INSERT INTO
    middlearea
VALUES(
    '노원구', 1, 11 
);
INSERT INTO
    middlearea
VALUES(
    '은평구', 1, 12
);
INSERT INTO
    middlearea
VALUES(
    '서대문구', 1, 13
);
INSERT INTO
    middlearea
VALUES(
    '마포구', 1, 14
);
INSERT INTO
    middlearea
VALUES(
    '양천구', 1, 15
);
INSERT INTO
    middlearea
VALUES(
    '강서구', 1, 16
);
INSERT INTO
    middlearea
VALUES(
    '구로구', 1, 17
);
INSERT INTO
    middlearea
VALUES(
    '금천구', 1, 18
);
INSERT INTO
    middlearea
VALUES(
    '영등포구', 1, 19
);
INSERT INTO
    middlearea
VALUES(
    '동작구', 1, 20
);
INSERT INTO
    middlearea
VALUES(
    '관악구', 1, 21
);
INSERT INTO
    middlearea
VALUES(
    '서초구', 1, 22
);
INSERT INTO
    middlearea
VALUES(
    '강남구', 1, 23
);
INSERT INTO
    middlearea
VALUES(
    '강동구', 1, 24
);
INSERT INTO
    middlearea
VALUES(
    '송파구', 1, 25
);


INSERT INTO
    smallarea
VALUES(
    '청운효자동', 1, 1, 1
);
INSERT INTO
    smallarea
VALUES(
    '사직동', 1, 1, 2
);
INSERT INTO
    smallarea
VALUES(
    '삼청동', 1, 1, 3
);
INSERT INTO
    smallarea
VALUES(
    '부암동', 1, 1, 4
);
INSERT INTO
    smallarea
VALUES(
    '평창동', 1, 1, 5
);
INSERT INTO
    smallarea
VALUES(
    '무악동', 1, 1, 6
);
INSERT INTO
    smallarea
VALUES(
    '교남동', 1, 1, 7
);
INSERT INTO
    smallarea
VALUES(
    '가회동', 1, 1, 8
);
INSERT INTO
    smallarea
VALUES(
    '종로 1, 2, 3, 4 가동', 1, 1, 9
);
INSERT INTO
    smallarea
VALUES(
    '종로 5, 6 가동', 1, 1, 10
);
INSERT INTO
    smallarea
VALUES(
    '이화동', 1, 1, 11
);
INSERT INTO
    smallarea
VALUES(
    '혜화동', 1, 1, 12
);
INSERT INTO
    smallarea
VALUES(
    '창신제1동', 1, 1, 13
);
INSERT INTO
    smallarea
VALUES(
    '창신제2동', 1, 1, 14
);
INSERT INTO
    smallarea
VALUES(
    '창신제3동', 1, 1, 15
);
INSERT INTO
    smallarea
VALUES(
    '숭인제1동', 1, 1, 16
);
INSERT INTO
    smallarea
VALUES(
    '숭인제2동', 1, 1, 17
);



INSERT INTO
    smallarea
VALUES(
    '소공동', 1, 2, 20
);
INSERT INTO
    smallarea
VALUES(
    '회현동', 1, 2, 21
);
INSERT INTO
    smallarea
VALUES(
    '명동', 1, 2, 22
);
INSERT INTO
    smallarea
VALUES(
    '필동', 1, 2, 23
);
INSERT INTO
    smallarea
VALUES(
    '장충동', 1, 2, 24
);
INSERT INTO
    smallarea
VALUES(
    '광희동', 1, 2, 25
);
INSERT INTO
    smallarea
VALUES(
    '을지동', 1, 2, 26
);
INSERT INTO
    smallarea
VALUES(
    '신당동', 1, 2, 27
);
INSERT INTO
    smallarea
VALUES(
    '다산동', 1, 2, 28
);
INSERT INTO
    smallarea
VALUES(
    '약수동', 1, 2, 29
);
INSERT INTO
    smallarea
VALUES(
    '청구동', 1, 2, 30
);
INSERT INTO
    smallarea
VALUES(
    '신당제5동', 1, 2, 31
);
INSERT INTO
    smallarea
VALUES(
    '동화동', 1, 2, 32
);
INSERT INTO
    smallarea
VALUES(
    '황학동', 1, 2, 33
);
INSERT INTO
    smallarea
VALUES(
    '중림동', 1, 2, 34
);



INSERT INTO
    smallarea
VALUES(
    '후암동', 1, 3, 40
);
INSERT INTO
    smallarea
VALUES(
    '용산2가동', 1, 3, 41
);
INSERT INTO
    smallarea
VALUES(
    '남영동', 1, 3, 42
);
INSERT INTO
    smallarea
VALUES(
    '청파동', 1, 3, 43
);
INSERT INTO
    smallarea
VALUES(
    '원효로제1동', 1, 3, 44
);
INSERT INTO
    smallarea
VALUES(
    '원효로제2동', 1, 3, 45
);
INSERT INTO
    smallarea
VALUES(
    '효창동', 1, 3, 46
);
INSERT INTO
    smallarea
VALUES(
    '용문동', 1, 3, 47
);
INSERT INTO
    smallarea
VALUES(
    '한강로동', 1, 3, 48
);
INSERT INTO
    smallarea
VALUES(
    '이촌제1동', 1, 3, 49
);
INSERT INTO
    smallarea
VALUES(
    '이촌제2동', 1, 3, 50
);
INSERT INTO
    smallarea
VALUES(
    '이태원제1동', 1, 3, 51
);
INSERT INTO
    smallarea
VALUES(
    '이태원제2동', 1, 3, 52
);
INSERT INTO
    smallarea
VALUES(
    '한남동', 1, 3, 53
);
INSERT INTO
    smallarea
VALUES(
    '서빙고동', 1, 3, 54
);
INSERT INTO
    smallarea
VALUES(
    '보광동', 1, 3, 55
);

commit;

-------------------------------------------------------------------------------
CREATE TABLE menu (
    foodtype VARCHAR2(10 CHAR)
        CONSTRAINT MENU_TYPE_PK PRIMARY KEY,
    code NUMBER(4)
        CONSTRAINT MENU_CODE_NN NOT NULL
        CONSTRAINT MENU_CODE_UK UNIQUE
);



ALTER TABLE board
ADD(
    category VARCHAR2(10CHAR)
        CONSTRAINT BOARD_CATEGORY_NN NOT NULL
        CONSTRAINT BOARD_CATEGORY_FK REFERENCES menu(foodtype)
);


INSERT INTO
    menu
VALUES(
    '돈까스·회·일식', 1001
);
INSERT INTO
    menu
VALUES(
    '중식', 1002
);
INSERT INTO
    menu
VALUES(
    '치킨', 1003
);
INSERT INTO
    menu
VALUES(
    '백반·죽·국수', 1004
);
INSERT INTO
    menu
VALUES(
    '카페·디저트', 1005
);
INSERT INTO
    menu
VALUES(
    '분식', 1006
);
INSERT INTO
    menu
VALUES(
    '찜·탕·찌개', 1007
);
INSERT INTO
    menu
VALUES(
    '피자', 1008
);
INSERT INTO
    menu
VALUES(
    '양식', 1009
);
INSERT INTO
    menu
VALUES(
    '고기·구이', 1010
);
INSERT INTO
    menu
VALUES(
    '족발·보쌈', 1011
);
INSERT INTO
    menu
VALUES(
    '아시안', 1012
);INSERT INTO
    menu
VALUES(
    '페스트푸드', 1013
);
INSERT INTO
    menu
VALUES(
    '도시락', 1014
);

ALTER TABLE menu
RENAME TO menucategory;

commit;
---------------------------------형준씨 작업 -------
CREATE TABLE restaurant(
    rno NUMBER(6)
        CONSTRAINT RS_NO_PK PRIMARY KEY,
    rname VARCHAR2(20 CHAR)
        CONSTRAINT RS_NAME_NN NOT NULL,
    cname VARCHAR2(20 CHAR)
        CONSTRAINT RS_CTG_FK REFERENCES menucategory(foodtype)
        CONSTRAINT RS_CTG_NN NOT NULL,
    addr VARCHAR2(60 CHAR)
        CONSTRAINT RS_ADDR_NN NOT NULL,
    tel VARCHAR2(13 CHAR)
        CONSTRAINT RS_TEL_UK UNIQUE
        CONSTRAINT RS_TEL_NN NOT NULL,
    rtime DATE
        CONSTRAINT RS_RTIME_NN NOT NULL,
    esti NUMBER(2, 1) DEFAULT 0
        CONSTRAINT RS_ESTI_NN NOT NULL,
    isshow CHAR(1) DEFAULT 'Y'
        CONSTRAINT RS_SHOW_CK CHECK (isshow IN('Y','N'))
        CONSTRAINT RS_SHOW_NN NOT NULL
);



CREATE TABLE menuimg(
    mino NUMBER(4)
        CONSTRAINT MI_NO_PK PRIMARY KEY,
    miname VARCHAR2(20CHAR)
        CONSTRAINT MI_INAME_NN NOT NULL,
    sname VARCHAR2(20 CHAR)
        CONSTRAINT MI_SNAME_NN NOT NULL,
    dir VARCHAR2(60 CHAR)
        CONSTRAINT MI_DIR_NN NOT NULL
);

CREATE TABLE menu(
    mno NUMBER(4)
        CONSTRAINT MN_MNO_PK PRIMARY KEY,
    rno NUMBER(4)
        CONSTRAINT MN_RNO_FK REFERENCES restaurant(rno)
        CONSTRAINT MN_RNO_NN NOT NULL,
    mname VARCHAR2(20CHAR)
        CONSTRAINT MN_MNAME_NN NOT NULL,
    mprice NUMBER(6)
        CONSTRAINT MN_PR_NN NOT NULL,
    mintro VARCHAR2(60 CHAR)
        CONSTRAINT MN_INTRO_NN NOT NULL,
    mimg NUMBER(4)
        CONSTRAINT MN_IMG_FK REFERENCES menuimg(mino)
        CONSTRAINT MN_IMG_NN NOT NULL,
    isshow CHAR(1) DEFAULT 'Y'
        CONSTRAINT MN_SHOW_CK CHECK (isshow IN('Y','N'))
        CONSTRAINT MN_SHOW_NN NOT NULL
);

CREATE TABLE ordertask(
    ono NUMBER(6)
        CONSTRAINT OD_ONO_PK PRIMARY KEY,
    mno NUMBER(4)
        CONSTRAINT OD_MNO_FK REFERENCES member(mno)
        CONSTRAINT OD_MNO_NN NOT NULL
);

CREATE TABLE orderlist(
    olno NUMBER(6)
        CONSTRAINT OL_OLNO_PK PRIMARY KEY,
    ono NUMBER(6)
        CONSTRAINT OL_ONO_FK REFERENCES ordertask(ono)
        CONSTRAINT OL_ONO_NN NOT NULL,
    rno NUMBER(4)
        CONSTRAINT OL_RNO_FK REFERENCES restaurant(rno)
        CONSTRAINT OL_MNO_NN NOT NULL,
    odate DATE DEFAULT sysdate
        CONSTRAINT OL_DATE_NN NOT NULL,
    oprice NUMBER(6)
        CONSTRAINT OL_PR_NN NOT NULL,
    paym VARCHAR2(10CHAR)
        CONSTRAINT OL_PM_NN NOT NULL,
    requests VARCHAR2(100CHAR)  
);

CREATE TABLE ordermenu(
    omno NUMBER(6)
        CONSTRAINT OM_OMNO_PK PRIMARY KEY,
    olno NUMBER(6)
        CONSTRAINT OM_ONO_FK REFERENCES orderlist(olno)
        CONSTRAINT OM_ONO_NN NOT NULL,
    omenu VARCHAR2(20 CHAR)
        CONSTRAINT OM_MENU_NN NOT NULL,
    omprice NUMBER(6)
        CONSTRAINT OM_OMPR_NN NOT NULL,
    quantity NUMBER(4)
        CONSTRAINT OM_QT_NN NOT NULL
);

INSERT INTO
    member(mno, name, id, kakaoid, pw, mail, tel, avt, addr)
VALUES(
    (SELECT NVL(MAX(mno) + 1, 1001) FROM member), '이용현', 'YHLEE', 'YHLEE12', '12345', 'YH@githrd.com', '010-0000-0000', '11', '서울시 영등포구 신길동'
);


INSERT INTO
    member(mno, name, id, kakaoid, pw, mail, tel, avt, addr)
VALUES(
    (SELECT NVL(MAX(mno) + 1, 1001) FROM member), '둘리', 'dool', 'dool12', '12345', 'dool@githrd.com', '010-1111-1111', '12', '서울시 종로구 사직동'
);
INSERT INTO
    member(mno, name, id, kakaoid, pw, mail, tel, avt, addr)
VALUES(
    (SELECT NVL(MAX(mno) + 1, 1001) FROM member), '희동이', 'hui', 'hui12', '12345', 'hui@githrd.com', '010-2222-2222', '13', '서울시 종로구 무악동'
);
INSERT INTO
    member(mno, name, id, kakaoid, pw, mail, tel, avt, addr)
VALUES(
    (SELECT NVL(MAX(mno) + 1, 1001) FROM member), '홍길동', 'HONG', 'HONG', '12345', 'HONG@githrd.com', '010-3333-3333', '12', '서울시 중구 소공동'
);
INSERT INTO
    member(mno, name, id, kakaoid, pw, mail, tel, avt, addr)
VALUES(
    (SELECT NVL(MAX(mno) + 1, 1001) FROM member), '마이콜', 'call', 'call12', '12345', 'call@githrd.com', '010-4444-4444', '14', '서울시 용산구 후암동'
);
INSERT INTO
    member(mno, name, id, kakaoid, pw, mail, tel, avt, addr)
VALUES(
    (SELECT NVL(MAX(mno) + 1, 1001) FROM member), '제니', 'jennie', 'jennie12', '12345', 'jennie@githrd.com', '010-5555-5555', '16', '서울시 중구 다산동'
);

-------------------------------------------------------게시글데이터
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
commit;

alter table delivery.restaurant drop constraint rs_ctg_fk;
alter table restaurant modify cname NUMBER(4);

alter table delivery.restaurant add constraint rs_ctg_fk FOREIGN KEY(cname) REFERENCES MENUCATEGORY(code) on delete cascade;

INSERT INTO
    largearea
VALUES(
    '경상도', 2
);

INSERT INTO
    largearea
VALUES(
    '경기도', 3
);




INSERT INTO
    middlearea
VALUES(
    '금정구', 2, 100
);


INSERT INTO
    middlearea
VALUES(
    '강화군', 3, 200
);


INSERT INTO
    smallarea
VALUES(
    '강화읍', 3, 200, 1000
);

INSERT INTO
    smallarea
VALUES(
    '서제1동', 2, 100, 500
);

INSERT INTO
    board(bno, bmno, title, body, larea, marea, sarea, end, category)
VALUES(
    (SELECT NVL(MAX(bno) + 1, 1) FROM board), 1006, '테스트입니다.', '무엇을 먹어야할지 생각하는 테스트입니다.', '서울특별시', '중구', '신당동', 1, '치킨'
);
commit;

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

alter table menu modify rno number(6);

INSERT INTO
    member(mno, name, id, kakaoid, pw, mail, tel, avt, addr)
VALUES(
    1007, '안은비', 'aeb320', '320aeb', 12345, 'dksdmsql320@gmail.com',
    010-3232-3232, 12, '서울시 영등포구 신길동'
);

commit;

alter table orderlist drop constraint ol_ono_fk;

alter table orderlist modify ono VARCHAR2(40CHAR);

alter table delivery.ordermenu drop constraint om_ono_fk;

alter table delivery.ordermenu add constraint om_olno_fk FOREIGN KEY(olno) REFERENCES orderlist(olno) on delete cascade;

alter table ordertask drop primary key;

alter table ordertask modify ono VARCHAR2(40CHAR);

alter table ordertask add constraint od_ono_pk primary key(ono);

alter table orderlist add constraint ol_ono_fk foreign key(ono) references ordertask(ono) on delete cascade;

alter table ordermenu add ono VARCHAR2(40CHAR) not null;

ALTER table ordermenu add constraint om_ono_fk foreign key(ono) references ordertask(ono) on delete cascade;

alter table ordermenu modify ono not null;

alter table ordermenu rename constraint om_ono_nn to om_olno_nn;

alter table ordermenu rename constraint sys_c007380 to om_ono_nn;

--  sys_c007103 은 임시로 정해진 not null 제약조건의 이름이라 수정했습니다.
--  rename 시 제약조건을 확인해 주세요

alter table restaurant add delpay number(6);

alter table restaurant modify delpay not null;

alter table restaurant rename constraint sys_c007381 to rs_del_nn;

--  sys_c007381 은 임시로 정해진 not null 제약조건의 이름이라 수정했습니다.
--  rename 시 제약조건을 확인해 주세요

commit;

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

CREATE TABLE avatar(
    ano NUMBER(5)
        CONSTRAINT AVATAT_FNO_PK PRIMARY KEY,
    aname VARCHAR2(100 CHAR)
        CONSTRAINT AVATAR_FNAME_NN NOT NULL,
    oriname VARCHAR2(20 CHAR)
        CONSTRAINT AVATAR_ANAME_NN NOT NULL,
    savename VARCHAR2(100 CHAR)
        CONSTRAINT AVATAR_SNAME_UK UNIQUE
        CONSTRAINT AVATAR_SNAME_NN NOT NULL,
    dir VARCHAR2(100 CHAR)
        CONSTRAINT AVATAR_DIR_NN NOT NULL,
    isShow CHAR(1) DEFAULT 'N'
        CONSTRAINT AVATAR_ISSHOW_NN NOT NULL
        CONSTRAINT AVATAR_ISSHOW_CK CHECK (isShow IN('Y', 'N'))
        
);


INSERT INTO
    avatar    
VALUES(
    10, 'noimage', 'noimage.jpg', 'noimage.jpg', '/img/avatar/', 'Y'
);

INSERT INTO
    avatar    
VALUES(
    11, 'man1', 'img_avatar1.png', 'img_avatar1.png', '/img/avatar/', 'Y'
);

INSERT INTO
    avatar    
VALUES(
    12, 'man2', 'img_avatar2.png', 'img_avatar2.png', '/img/avatar/', 'Y'
);

INSERT INTO
    avatar    
VALUES(
    13, 'man3', 'img_avatar3.png', 'img_avatar3.png', '/img/avatar/', 'Y'
);

INSERT INTO
    avatar    
VALUES(
    14, 'woman1', 'img_avatar4.png', 'img_avatar4.png', '/img/avatar/', 'Y'
);

INSERT INTO
    avatar    
VALUES(
    15, 'woman2', 'img_avatar5.png', 'img_avatar5.png', '/img/avatar/', 'Y'
);

INSERT INTO
    avatar    
VALUES(
    16, 'woman3', 'img_avatar6.png', 'img_avatar6.png', '/img/avatar/', 'Y'
);

CREATE TABLE regimem (
    abno NUMBER(4)
        CONSTRAINT REGIMEM_ABNO_NN NOT NULL
        CONSTRAINT REGIMEM_ABNO_FK REFERENCES board(bno),
    aid VARCHAR2(10 CHAR)
        CONSTRAINT REGIMEM_AID_NN NOT NULL
        CONSTRAINT REGIMEM_AID_FK REFERENCES member(id)
);

CREATE TABLE grouporder (
    gno NUMBER(6)
        CONSTRAINT GO_GNO_PK PRIMARY KEY
);

ALTER TABLE
    orderlist
ADD
    gorder NUMBER(6)
        CONSTRAINT OL_GR_FK REFERENCES grouporder(gno)
        CONSTRAINT OL_GR_NN NOT NULL
;

commit;
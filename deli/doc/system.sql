ALTER USER delivery IDENTIFIED BY 12345 ACCOUNT UNLOCK;
GRANT resource, connect To delivery;
GRANT UNLIMITED TABLESPACE, CREATE SESSION, connect, resource TO delivery;
ALTER USER delivery DEFAULT TABLESPACE USERs;


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
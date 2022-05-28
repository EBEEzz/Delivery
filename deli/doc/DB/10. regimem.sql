--delivery
CREATE TABLE regimem (
    abno NUMBER(4)
        CONSTRAINT REGIMEM_ABNO_NN NOT NULL
        CONSTRAINT REGIMEM_ABNO_FK REFERENCES board(bno),
    aid VARCHAR2(10 CHAR)
        CONSTRAINT REGIMEM_AID_NN NOT NULL
        CONSTRAINT REGIMEM_AID_FK REFERENCES member(id),
    wdate DATE DEFAULT sysdate
        CONSTRAINT REGIMEM_wdate_NN NOT NULL,
    ddate DATE DEFAULT sysdate
        CONSTRAINT REGIMEM_DDATE_NN NOT NULL,
    isshow CHAR(1) DEFAULT 'Y'
        CONSTRAINT REGIMEM_ISSHOW_NN NOT NULL
        CONSTRAINT REGIMEM_ISSHOW_CK CHECK(isshow IN('Y','N'))
);
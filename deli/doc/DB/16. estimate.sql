CREATE TABLE estimate(
    ebno NUMBER(6)
        CONSTRAINT ESTI_BNO_FK REFERENCES board(bno)
        CONSTRAINT ESTI_BNO_NN NOT NULL,
    eida VARCHAR2(10 CHAR)
        CONSTRAINT ESTI_IDA_NN NOT NULL,
    eidb VARCHAR2(10 CHAR)
        CONSTRAINT ESTI_IDB_NN NOT NULL,
    isshow CHAR(1) DEFAULT 'Y'
        CONSTRAINT ESTI_SHOW_NN NOT NULL
        CONSTRAINT ESTI_SHOW_CK CHECK(isshow IN('Y','N'))
);
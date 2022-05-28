CREATE TABLE estimate(
    ebno NUMBER(4)
        CONSTRAINT ESTI_BNO_FK REFERENCES board(bno)
        CONSTRAINT ESTI_BNO_NN NOT NULL,
    eida VARCHAR2(10 CHAR)
        CONSTRAINT ESTI_IDA_NN NOT NULL,
    eidb VARCHAR2(10 CHAR)
        CONSTRAINT ESTI_IDB_NN NOT NULL,
    epoint NUMBER(3,2)
        CONSTRAINT ESTI_PTS_NN NOT NULL,
    isshow CHAR(1) DEFAULT 'Y'
        CONSTRAINT ESTI_SHOW_NN NOT NULL
        CONSTRAINT ESTI_SHOW_CK CHECK(isshow IN('Y','N'))
);

SELECT
    spts, cpts
FROM
    estimate, (
        SELECT
            SUM(epoint) spts, count(epoint) cpts
        FROM
            estimate
        WHERE
            eidb = 'gildong'
            AND isshow = 'N'
    )
;
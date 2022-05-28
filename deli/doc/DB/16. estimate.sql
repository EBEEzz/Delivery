CREATE TABLE estimate(
    ebno NUMBER(4)
        CONSTRAINT ESTI_BNO_FK REFERENCES board(bno)
        CONSTRAINT ESTI_BNO_NN NOT NULL,
    eida VARCHAR2(10 CHAR)
        CONSTRAINT ESTI_IDA_NN NOT NULL
        CONSTRAINT ESTI_IDA_FK REFERENCES member(id),
    eidb VARCHAR2(10 CHAR)
        CONSTRAINT ESTI_IDB_NN NOT NULL
        CONSTRAINT ESTI_IDB_FK REFERENCES member(id),
    epoint NUMBER(3,2) DEFAULT 0
        CONSTRAINT ESTI_PTS_NN NOT NULL,
    isshow CHAR(1) DEFAULT 'Y'
        CONSTRAINT ESTI_SHOW_NN NOT NULL
        CONSTRAINT ESTI_SHOW_CK CHECK(isshow IN('Y','N'))
);

INSERT INTO
    estimate(ebno, eida, eidb)
VALUES(
    777, 'kcs001', 'gildong'
)
;

UPDATE
    estimate
SET
    epoint = 4,
    isshow = 'N'
;
    
SELECT
    abno, tle, r.wdate
FROM
    regimem r, board b, estimate e, (
        SELECT
            title tle
        FROM
            board
     )
WHERE
    r.abno = b.bno
    AND e.eida = r.aid
    AND r.isshow = 'Y'
    AND e.isshow = 'N'
    AND aid = 'kcs001'
;


SELECT
    abno, title, wd
FROM
    (
        SELECT
            abno, title, b.wdate wd
        FROM
            regimem r, board b
        WHERE
            r.abno = b.bno
            AND r.isshow = 'Y'
            AND aid = 'gildong'
    )
;

SELECT
    aid, esti, dir, savename
FROM
    regimem r, member m, imgfile i, estimate e
WHERE
    r.aid = m.id
    AND m.mno = i.amno
    AND e.ebno = r.abno
    AND r.isshow = 'Y'
    AND m.isshow = 'Y'
    AND e.isshow = 'Y'
    AND abno = 888
    AND aid != 'kcs001'
;
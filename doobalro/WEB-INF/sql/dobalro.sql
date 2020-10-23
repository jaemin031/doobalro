DROP TABLE replys;
DROP TABLE boards;
DROP TABLE users;
DROP TABLE LOCATION_W;
DROP TABLE BIKE_STATUS;

-- user
CREATE TABLE users (
	userNum		NUMBER(8)			PRIMARY KEY,
	userName	VARCHAR(40),
	userPhone	VARCHAR(40)			NOT NULL,
	userPw		VARCHAR(40)			NOT NULL,
	userBirth	VARCHAR(40)
);

-- board
CREATE TABLE boards (
	boardNum		NUMBER(8)		PRIMARY KEY,
	userNum			NUMBER(8)		REFERENCES users(userNum),
	boardWriter		VARCHAR(40),
	boardTitle		VARCHAR(200),
	boardContent		VARCHAR(2000),
	boardDate		VARCHAR(40),
	boardCnt		NUMBER(6)		default 0,
	boardRCnt		NUMBER(6)		default 0
);

-- reply
CREATE TABLE replys (
	replyNum		NUMBER(8)	PRIMARY KEY,
	boardNum		NUMBER(8)	REFERENCES boards(boardNum),
	replyContent		VARCHAR(500),
	replyWriter		VARCHAR(40),
	replyDate		VARCHAR(40)
);

CREATE TABLE "MUSO"."LOCATION_W"(   
   "LOCATION" VARCHAR2(26 BYTE), 
   "LAT" NUMBER(11,7), 
   "LON" NUMBER(12,7)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

CREATE TABLE "MUSO"."BIKE_STATUS" 
   (   "STATION_NAME" VARCHAR2(128 BYTE), 
   "ADDRESS" VARCHAR2(4000 BYTE), 
   "LAT" NUMBER(19,15), 
   "LON" NUMBER(19,14), 
   "TOTAL_BIKE" NUMBER(4,0), 
   "AVAILABLE_BIKE" NUMBER(5,0), 
   "LOCATION" VARCHAR2(26 BYTE), 
   "NOWDATE" NUMBER(14,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
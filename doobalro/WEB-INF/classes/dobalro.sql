DROP TABLE replys;
DROP TABLE boards;
DROP TABLE users;

-- user
CREATE TABLE users (
	userNum		NUMBER(8)			PRIMARY KEY,					-- �쑀��踰덊샇
	userName	VARCHAR(40)			UNIQUE,							-- �쑀�� �땳�꽕�엫
	userPhone	VARCHAR(40)			NOT NULL UNIQUE,				-- �쑀�� �룿踰덊샇(id���슜)
	userPw		VARCHAR(40)			NOT NULL,						-- �쑀�� 鍮꾨�踰덊샇
	userBirth	VARCHAR(40)			NOT NULL
);

-- board
CREATE TABLE boards (
	boardNum		NUMBER(8)		PRIMARY KEY,					-- 寃뚯떆�뙋 踰덊샇
	userNum			NUMBER(8)		REFERENCES users(userNum),		-- 寃뚯떆�뙋 湲� �벖 �쑀���쓽 踰덊샇
	boardWriter		VARCHAR(40),									-- 寃뚯떆�뙋 �옉�꽦�옄
	boardTitle		VARCHAR(200),									-- 寃뚯떆�뙋 �젣紐�
	boardContent	VARCHAR(2000),									-- 寃뚯떆�뙋 �궡�슜
	boardDate		VARCHAR(40),									-- 寃뚯떆�뙋 �옉�꽦�씪
	boardCnt		NUMBER(6)		default 0,						-- 寃뚯떆�뙋 議고쉶�닔
	boardRCnt		NUMBER(6)		default 0						-- �뙎湲� �닔
);

-- reply
CREATE TABLE replys (
	replyNum		NUMBER(8)	PRIMARY KEY,						-- �뙎湲� 踰덊샇
	boardNum		NUMBER(8)	REFERENCES boards(boardNum),		-- �뙎湲��씠 �떖由� 寃뚯떆�뙋�쓽 踰덊샇
	replyContent	VARCHAR(500),									-- �뙎湲� �궡�슜
	replyWriter		VARCHAR(40),									-- �뙎湲� �옉�꽦�옄
	replyDate		VARCHAR(40)										-- �뙎湲� �옉�꽦�씪
);


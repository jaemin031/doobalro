--현재 커서 있는 줄 동작시키려면 alt+s
--드래그 한 것만 동작시키려면 alt+x
--모두 다 동작시키려면 ctrl+alt+x

select * from users;

select * from boards;

select *from boards;

select *from replys;

select * from BIKE_STATUS;
select count(*) from BIKE_STATUS;

insert into users (userNum,userName,userPhone,userPw,userBirth) values((select nvl(max(userNum),0)+1 from users),'test','123456','1234','1234'))

insert into Boards (boardNum,userNum,boardWriter,boardTitle,boardContent,boardDate) values((select nvl(max(boardNum),0)+1 from boards),1,'test','title','content','1234')

update boards set boardCnt= boardCnt+1 where boardNum = 1

select * from weather;
select * from location_w;

select * from weather w, location_w loc where w.name = loc.location;












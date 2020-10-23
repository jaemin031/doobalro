import re
import urllib.parse
import urllib.request as req
from datetime import datetime

import requests

from bs4 import BeautifulSoup
from pyproj import Proj
from pyproj import transform
import ssl
ssl._create_default_https_context = ssl._create_unverified_context

urls = ['https://www.bikeseoul.com/app/station/moveStationSearchView.do',
        'http://www.tashu.or.kr/mapAction.do',
        'http://www.sejongbike.kr/status.do?process=userStatusView&menu=22',
        'http://www.fifteenlife.com/station/station_search.jsp',
        'http://www.pedalro.kr/station/station.do?method=stationState&menuIdx=st_01',
        'https://bike.siheung.go.kr/siheung/menu3_1.php',
        'https://bike.gongju.go.kr/current_state/current_state.aspx',
        'http://bike.gunsan.go.kr/main/bike/roadserv/bikekeep/',
        'http://www.greensing.kr/stn/stationState.do',
        'http://ubike.yangsan.go.kr/bike/stn/stationState.do',
        'http://bike.yeosu.go.kr/mapAction.do?process=statusMapView',
        'http://bike.suncheon.go.kr/stn/stationState.do']


# 출력폼 거치소명,주소,위도,경도,거치대,대여가능자전거 + 지역, 일시
time = str(datetime.now())[0:16].replace('-','').replace(' ','').replace(':','')


text = req.urlopen(urls[0]).read().decode('utf-8')
soup = BeautifulSoup(text, 'html.parser')
lastindex = soup.find("div", id="pagingWeb")
lastindex = str(lastindex).split("<a href=\"#\" onclick=\"pageSelect(")
lastindex=lastindex[8][:3]
req.urlopen(urls[0]).close()

# 서울)거치소명,주소,위도,경도,거치대,대여가능자전거
with open('Bike.csv', 'w', encoding='utf-8') as f:
    f.write('')
    f.close()
for count in range(1,int(lastindex)+1):
    params = {
        'currentPageNo' : count
    }
    query_strings = urllib.parse.urlencode(params)

    text = req.urlopen(urls[0] + '?' + query_strings).read().decode('utf-8')
    soup = BeautifulSoup(text, 'html.parser')
    boards = soup.select('tbody tr')
    for board in boards:
        writedata = ''
        temp = ''
        with open('Bike.csv', 'a', encoding='utf-8') as f:
            # if board.select_one('td a').text.index
            if '.' in board.select_one('td a').text:
                temp = board.select_one('td a').text.strip().replace(',','~')

                if 2 < len(temp.split('.')):
                    for i in range(1,len(temp.split('.'))):
                        if i == len(temp.split('.'))-1:
                            writedata += temp.split('.')[i]
                        elif i == 1:
                            writedata += temp.split('.')[i].strip() + '.'
                        else:
                            writedata += temp.split('.')[i] + '.'

                elif 2 == len(temp.split('.')):
                    writedata += temp.split('.')[1].strip()

                writedata += ',' + board.select_one('span').text.replace(',','~')
                writedata += ',' + board.select_one('td a')['param-data'].split(',')[0] + ','
                writedata += board.select_one('td a')['param-data'].split(',')[1] + ','
                writedata += board.select('td.tr')[0].text + ','
                writedata += board.select('td.tr')[1].text + ',서울,' + time + '\n'
                f.write(writedata)
            else:
                writedata += board.select_one('td a').text.strip().replace(',','~')
                writedata += ',' + board.select_one('span').text.replace(',', '~')
                writedata += ',' + '37.5652894,126.8494662,'
                writedata += board.select('td.tr')[0].text + ','
                writedata += board.select('td.tr')[1].text + ',서울,' + time + '\n'
                f.write(writedata)

req.urlopen(urls[0]).close()

#===============================================================================================================
#  대전광역시 타슈


params = {
    'process' : 'statusMapView'
}

query_strings = urllib.parse.urlencode(params)

text = req.urlopen(urls[1] + '?' + query_strings).read().decode('utf-8')
soup = BeautifulSoup(text,'html.parser')

data=str(soup).split(',')
#대전)거치소명,	   위도,경도,거치대,대여가능자전거
count = [3,9,7,11,8]
while count[3] < 3012:
    with open('Bike.csv', 'a', encoding='utf-8') as f:
        for i in range(0, 5):
            data2 = ""
            if i == 4:
                data2 = data[count[i]].split(':')[1]
                f.write(data2[1:len(data2)-1] + ',대전,' + time +'\n')
            elif i==3 and count[i] != 3011:
                data2 = data[count[i]].split(':')[1]
                f.write(data2[1:len(data2)-2] + ',')
            elif i==0 and count[i] != 3011:
                data2 = data[count[i]].split(':')[1]
                f.write(data2[1:len(data2)-1] + ',,')
            elif count[i] == 3011:
                data2 = data[count[i]].split(':')[1]
                f.write(data2[1:len(data2)-4] + ',')
            else:
                data2 = data[count[i]].split(':')[1]
                f.write(data2[1:len(data2) - 1] + ',')
            count[i] = count[i] + 12

req.urlopen(urls[1]).close()
#===============================================================================================================

text = req.urlopen(urls[2]).read().decode('utf-8')
soup = BeautifulSoup(text, 'html.parser')

boards = soup.select('script[type="text/javascript"]')[8]

data = str(boards).split('\n')
count = 163

#세종)거치소명,	   위도,경도,거치대,대여가능자전거
while count < 235:
    with open('Bike.csv', 'a', encoding='utf-8') as f:
        data2 = []
        str1 = ""
        #       0           1          2                                   (전체거치대)4   5
        # [36.482114, 127.259628,'1. 첫마을 1단지',['/html/images/sub/api_ico04.png','13','5','38%', '23908500000001']],
        data2 =data[count][1:-4].split(',')
        stationNm = data2[2].split('.')[1][1:-1]
        str1 += stationNm+',,'+data2[0]+','+data2[1][1:]+','+data2[4][1:-1]+','+data2[5][1:-1]+ ',세종,' + time +'\n'
        f.write(str1)
        count= count+1
req.urlopen(urls[2]).close()
#===============================================================================================================



text = req.urlopen(urls[3]).read().decode('utf-8')
soup = BeautifulSoup(text, 'html.parser')

boards = soup.select('script[type="text/javascript"]')[6]
data = str(boards).split('\n')
count = [45, 42, 43, 46, 47]

#고양)거치소명,	  ,위도,경도,거치대,대여가능자전거
while count[0] < 2564:
    with open('Bike.csv', 'a', encoding='utf-8') as f:
        for i in range(0, 5):
            data2 = ""
            data1 = ""
            if i == 4:
                data2 = data[count[i]].split('=')[1].split(';')[0]
                f.write(data2[1:].strip() + ',고양,' + time +'\n')
            elif i == 3:
                data2 = data[count[i]].split('=')[1].split(';')[0]
                data1 = data[count[i + 1]].split('=')[1].split(';')[0]
                result =int(data2.strip()) + int(data1.strip())
                f.write(str(result)+ ',')
            elif i == 0:
                data2 = data[count[i]].split('=')[1].split(';')[0]
                f.write(data[count[i]].split("=")[1].split(';')[0].strip()[1:len(data[count[i]].split("=")[1].split(';')[0].strip())-1] + ',,')
            elif i == 1:
                data2 = data[count[i]].split('=')[1].split(';')[0]
                f.write(data[count[i]].split("=")[1].split(';')[0].strip() + ',')
            else:
                data2 = data[count[i]].split('=')[1].split(';')[0]
                f.write(data[count[i]].split("=")[1].split(';')[0].strip() + ',')
            count[i] = count[i] + 17

req.urlopen(urls[3]).close()

#===============================================================================================================
#  안산 페달로


text = req.urlopen(urls[4]).read().decode('utf-8')
soup = BeautifulSoup(text,'html.parser')

boards = soup.select('td[height="40"]')[2].select('table tr td.style1')

# 거치소이름,위도,경도,거치대수,대여 가능 자전거 수 순서!!!
i=1
data=""
for board in boards:

    if i==1:
        data=""
        data += board.select('a')[0].text.strip() + ',,'
        data += board.select('a')[0]['onclick'].split('&')[6] + ','
        data += board.select('a')[0]['onclick'].split('&')[7] + ','
    elif i==2:
        data += board.text.strip() + ','
    elif i==3:
        data += board.text.strip()
    i=i+1
    if i==4:
        i=1
        with open('Bike.csv', 'a', encoding='utf-8') as f:
            f.write(data + ',안산,' + time +'\n')

req.urlopen(urls[4]).close()

#===============================================================================================================




params = {
    'process' : 'statusMapView'
}

query_strings = urllib.parse.urlencode(params)

text = req.urlopen(urls[5] + '?' + query_strings).read().decode('utf-8')
soup = BeautifulSoup(text,'html.parser')
tables=soup.find_all("button", {"class":"move_btn"})
datas=str(tables).split(',')

index=0
data="";
#시흥)거치소명,     위도,경도,거치대,대여가능자전거
with open('Bike.csv', 'a', encoding='utf-8') as f:
    while index < datas.__len__():
        data+=datas[index][54:][:datas[index][54:].find("\"")]+",,"
        data+=datas[index+1][2:][:datas[index+1][2:].find("\"")]+","
        data+=datas[index+2][2:][:datas[index+2][2:].find("\"")]+","
        data+=datas[index+3]+","
        data+=datas[index+4][:datas[index+4].find(")")]+ ',시흥,' + time + "\n"
        index=index+5
    f.write(data)

req.urlopen(urls[5]).close()
#===============================================================================================================


html = req.urlopen(urls[6]).read().decode('utf-8')
soup = BeautifulSoup(html,'html.parser')

table = soup.find('table', {'id': 'StatusGridView'})  # <table class="table_develop3">을 찾음
location = soup.find('SCRIPT')


datas=str(soup).split("var markerArray = [")[1]
datas=str(datas).split(", new google.maps.LatLng")


index=0
data2=""
#공주)거치소명,	   위도,경도,거치대,대여가능자전거
for tr in table.find_all('tr'):  # 모든 <tr> 태그를 찾아서 반복(각 지점의 데이터를 가져옴)
    tds = list(tr.find_all('td'))  # 모든 <td> 태그를 찾아서 리스트로 만듦
    data2+=tds[1].string.strip()+",,"

    data=datas[index]
    a=data.find("(")
    b=data.find(",")
    c=data.find(")")
    data2+=data[a+1:b+1]+data[b+1:c]+","

    data2+=tds[3].string+","
    data2+=tds[2].string + ',공주,' + time + "\n"

    index=index+1

with open('Bike.csv', 'a', encoding='utf-8') as f:
    f.write(data2)

req.urlopen(urls[6]).close()
#===============================================================================================================


#  군산시 자전거

count=1
#군산)거치소명,주소,위도,경도       ,대여가능자전거
for count in range(1, 9):
    params = {
        'u_page' : count
    }
    query_strings = urllib.parse.urlencode(params)

    text = req.urlopen(urls[7] + '?' + query_strings).read().decode('utf-8')

    soup = BeautifulSoup(text,'html.parser')

    boards = soup.select('tr.list_list')

    # 거치소이름,주소,위도,경도,대여 가능 자전거 수 순서!!!
    for board in boards:
        with open('Bike.csv', 'a', encoding='utf-8') as f:
            f.write(board.select_one('td.list_list_1').text.strip() + ',' + board.select_one('td.list_list_2').text.strip() + ',' + board.select_one('a')['href'].split('&')[1][4:] + ',' +  board.select_one('a')['href'].split('&')[2][4:] + ',,' + board.select_one('td.list_list_3').text + ',군산,' + time + '\n')

req.urlopen(urls[7]).close()
#===============================================================================================================



text = req.urlopen(urls[8]).read().decode('utf-8')
soup = BeautifulSoup(text, 'html.parser')

boards = soup.select('script[type="text/javascript"]')[11]

data = str(boards).split('\n')
count = 96
#거창)거치소명,    ,위도,경도,거치대,대여가능자전거
while count < 469:
    with open('Bike.csv', 'a', encoding='utf-8') as f:
        data2 = []
        str1 = ""
        data1 =data[count].split(':')[1]
        data2 = data1[2:-1].split("|");
        #       0  1 2 3        4           5       6
        # 거창군청|1|9|11|re_office.JPG|35.6861318|127.9094662
        sum = int(data2[2])+int(data2[3])
        result = str(sum)
        str1 += data2[0]+',,'+data2[5]+','+data2[6][0:len(data2[6])-1]+','+result+','+data2[2]+ ',거창,' + time + '\n'
        f.write(str1)
        count= count+31

req.urlopen(urls[8]).close()
#===============================================================================================================


html = requests.get(urls[9]).text

m = re.compile("var contentString = (.*);")
datas = m.findall(html)

l = re.compile("var point= (.*);")
location = l.findall(html)

index = 0
#양산)거치소명,    ,위도,경도,거치대,대여가능자전거
while index < int(datas.__len__()) - 1:
    with open('Bike.csv', 'a', encoding='utf-8') as f:
        str1 = ""
        data = datas[index].split(',')
        str1 += data[0][19:][:data[0][19:].find("'")] + ",,"
        pp = location[0][22:location[0].find(")")].split(',')
        str1 += pp[0].strip() + "," + pp[1].strip() + ","
        str1 += data[2][1:-1].strip() + ","
        str1 += data[3][1:-1] + ',양산,' + time + "\n"

        f.write(str1)
        index = index + 1

requests.get(urls[9]).close()
#===============================================================================================================

html = requests.get(urls[10]).text

m = re.compile("name.*")
datas = m.findall(html)


datas=str(datas).split(',')

index=0
data=""
#여수)거치소명,    ,위도,경도,거치대,대여가능자전거
while index < datas.__len__():
    data+=datas[index][datas[index].find(":\"")+2:datas[index].__len__()-1]+",,"
    data+=datas[index+5][7:datas[index+5].__len__()-1]+","
    data+=datas[index+3][7:datas[index+3].__len__()-1]+","
    data+=datas[index+7][15:datas[index+7].find("}")]+","
    data+=datas[index+4][14:]+ ',여수,' + time + "\n"
    index=index+10

with open('Bike.csv', 'a', encoding='utf-8') as f:
 f.write(data)


requests.get(urls[10]).close()
#===============================================================================================================



WGS84 = { 'proj':'latlong', 'datum':'WGS84', 'ellps':'WGS84', }

# naver
TM128 = { 'proj':'tmerc', 'lat_0':'38N', 'lon_0':'128E', 'ellps':'bessel',
   'x_0':'400000', 'y_0':'600000', 'k':'0.9999',
   'towgs84':'-146.43,507.89,681.46'}


def tm128_to_wgs84(monja):
   index=monja.find(",");
   x=monja[:index]
   y=monja[index+2:]

   return transform( Proj(**TM128), Proj(**WGS84), x, y )



html = requests.get(urls[11]).text

m = re.compile("var contentString = (.*);")
datas = m.findall(html)


l = re.compile("var point2= (.*);")
locations = l.findall(html)



index=0
data2=""
#순천)거치소명,    ,위도,경도,거치대,대여가능자전거
while index < int(datas.__len__())-1:
  data=datas[index].split(',')

  data2+=data[0][19:][:data[0][19:].find("'")]+",,"



  location=locations[index][21:locations[index].find(")")]
  location=tm128_to_wgs84(location)
  data2+=repr(location[1])+","+repr(location[0])+","

  data2+=repr(int(data[2][1:][:data[2][1:].find("'")]) + int(data[3][1:][:data[3][1:].find("'")]))+","
  data2+=data[2][1:][:data[2][1:].find("'")]+ ',순천,' + time + "\n"

  index=index+1


with open('Bike.csv', 'a', encoding='utf-8') as f:
 f.write(data2)

requests.get(urls[11]).close()
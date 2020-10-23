import urllib.request as req

import urllib.parse
from bs4 import BeautifulSoup

url = 'http://www.airkorea.or.kr/dustForecast/'

with open('Pmatter.csv','w',encoding='utf-8') as f:
    f.write('서울,인천,경기북부,경기남부,강원영서,강원영동,대전,세종,충북,충남,광주,전북,전남,부산,대구,울산,경북,경남,제주,time\n')
    f.close()

text = req.urlopen(url).read().decode('utf-8')

soup = BeautifulSoup(text, 'html.parser')

pms = soup.select('thead td')
date1 = soup.select('strong')
nowdate1 = date1[0].text.replace('-','')
nowdate2 = nowdate1.replace(' ','')
nowdate = nowdate2[0:-1]
# print(nowdate)

data = ""
for count in range(0, 20):
    if count != 19:
        data += (str(pms[count].text) + ",")
    else:
        data += (str(nowdate) + "\n")

with open('Pmatter.csv', 'a', encoding='utf-8') as f:
    f.write(data)

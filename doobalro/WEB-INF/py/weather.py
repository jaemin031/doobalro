import urllib.parse
import urllib.request as req

from bs4 import BeautifulSoup

# 지점별 날씨 현황
url = 'http://www.weather.go.kr/weather/observation/currentweather.jsp?type=t99&mode=0&stn=0&auto_man=a'



text = req.urlopen(url).read().decode('euc-kr')
soup = BeautifulSoup(text, 'html.parser')

# content_weather > table > tbody > tr:nth-child(1)
datas = soup.select('tbody tr')

with open('weather.csv','w',encoding='utf-8') as f:
    f.write('city,time,weather,temple,windy\n')
    f.close()

# 지점, 일시, 일기, 기온, 풍속
date = soup.select_one('p.table_topinfo').text[5:].replace('.','').replace(':','')
i = 0
str1 = ""
while i < datas.__len__():
    if i == 9 or i == 25 or i == 38 or i == 64 or i == 69:
        i = i + 1
        continue
    else:
        data2 = datas[i].select('td')
        name = data2[0].text
        str1 += name + ',' + date + ',' + data2[1].text + ',' + data2[5].text + ',' + data2[11].text + '\n'
        # print(str1)
        i = i + 1
with open('weather.csv', 'a', encoding='utf-8') as f:
    f.write(str1)

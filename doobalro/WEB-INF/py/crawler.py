from time import sleep

searchword = "자전거"

from selenium import webdriver
driver = webdriver.Chrome()
# driver = webdriver.PhantomJS()
driver.get("http://www.socialmetrics.co.kr/socialSearch.html?keyword="+searchword)
driver.implicitly_wait(3)

SCROLL_PAUSE_TIME = 1.0

clicktest = driver.find_elements_by_css_selector('div.moreTweet')
clicktest[0].click()
clicktest[2].click()
sleep(SCROLL_PAUSE_TIME)
clicktest[0].click()
clicktest[2].click()
sleep(SCROLL_PAUSE_TIME)
clicktest[0].click()
clicktest[2].click()
sleep(SCROLL_PAUSE_TIME)
clicktest[0].click()
clicktest[2].click()
sleep(SCROLL_PAUSE_TIME)
clicktest[0].click()
clicktest[2].click()
sleep(SCROLL_PAUSE_TIME)



# SCROLL_PAUSE_TIME = 1.0

# last_height = driver.execute_script("return document.body.scrollHeight")

test = driver.find_elements_by_css_selector('li.tweetText')
test2 = driver.find_elements_by_css_selector('li.blogText')
# links = []
# for l in range(0,len(test)):
#     links.append(test[l].find_element_by_css_selector('a').text)
#     test[l].find_element_by_css_selector('a').text

data = ""
data2 = ""
for l in range(0,len(test)):
    tmp = test[l].find_element_by_css_selector('a').text
    if tmp.find('http') != 0:
        data += tmp.split('http')[0]

for i in range(0,len(test2)):
    data2 += test2[i].text

# for l in range(0,len(test2)):
#     tmp = test2.text
#     if tmp.find('http') != 0:
#         data2 += tmp.split('http')[0]


with open('social.txt', 'a', encoding='utf-8') as f:
    f.write(data)
    f.write(data2)

    # words = data.split(' ')
    # word_counts = dict()
    # for word in words:
    #     word_counts[word] = word_counts.get(word,0)+1
    # for word, count in word_counts.items():
    #     print(word.count)


# while True:
#     driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
#     from time import sleep
#     sleep(SCROLL_PAUSE_TIME)
#     new_height = driver.execute_script("return document.body.scrollHeight")
#     tmps = driver.find_elements_by_css_selector('div._mck9w')
#     for l in range(0, len(tmps)):
#         links.append(tmps[l].find_element_by_css_selector('a').get_attribute('href'))
#     if new_height == last_height:
#         break
#     last_height = new_height
#
#
# linkset = set(links)


#내부 글 크롤링 시험용
# test = driver.find_element_by_css_selector('div._mck9w')
# test.click()
#
# #링크 돌면서 date에 작성일, context에 내용 박는 딕셔너리를 리스트에 담는 작업
# dicts = []
# for data in linkset:
#     words = ""
#     driver.get(data)
#     driver.implicitly_wait(3)
#     textDate = driver.find_element_by_css_selector('time._p29ma')
#     date = textDate.get_attribute('title')
#     context = driver.find_elements_by_css_selector('li._ezgzd')
#     for n in range(0,len(context)):
#         words = words + (context[n].text + '\m')
#     dicts.insert(0, { "date" : date , "context" : words })
#
# #csv 파일로 빼는 부분
# import csv
#
# with open('crwalerTest.csv', 'w', newline='',encoding='utf-8',delimiter='|') as csvfile:
#     fieldnames = ['date', 'context']
#     writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
#     writer.writeheader()
#     for lines in dicts:
#         writer.writerow(lines)
#
#
#
# # 날짜를 키값으로 하고 밸류에 글을 모조리 모아놓은 타입,delimiter='|'
# # dic = dict()
# # for data in linkset:
# #     words = ""
# #     driver.get(data)
# #     driver.implicitly_wait(3)
# #     textDate = driver.find_element_by_css_selector('time._p29ma')
# #     date = textDate.get_attribute('title')
# #     context = driver.find_elements_by_css_selector('li._ezgzd')
# #     for n in range(0,len(context)):
# #         words = words + (context[n].text + '\m')
# #     if date in dic:
# #         dic[date] = dic.get(date) + words
# #     else:
# #         dic[date] = words
#
# print(dic)

# for data in linkset:
#     driver.get(data)
#     driver.implicitly_wait(3)
#     context = driver.find_elements_by_css_selector('li._ezgzd')
#     for n in range(0,len(context)):
#         with open('testFile', 'a', encoding='utf-8') as f:
#             f.write(context[n].text + '\m')
#        context[n].text

# test2 = driver.find_elements_by_xpath(".//div[@class='_mck9w']")
# atag = test[1].find_elements_by_xpath(".//a")
# context2 = driver.find_element_by_xpath("li[@class='_ezgzd'/span")
# 인스타 내부 글 클래스 네임 _ezgzd
# 아래의 span 태그 안이 글
# 재밌는건 댓글도 클래스 네임이 같다.
# for a in driver.find_elements_by_xpath('.//a'):
#     print(a.get_attribute('href'))

# find_element_by_css_selector('a').get_attribute('href')

# links = []
# for l in range(0,len(test)):
#     links.append(test[l].find_element_by_css_selector('a').get_attribute('href'))
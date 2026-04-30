# 크롤링 : 네이버 뉴스 목록 가져오기
# https://finance.naver.com/news/news_list.nhn?mode=RANK

# pip install requests
# pip install bs4 -> beautifulSoup

import requests
import bs4

url = "https://finance.naver.com/news/news_list.nhn?mode=RANK"

response = requests.get(url)
print(response) # 200
# 크롤링한 코드가 그냥 문자이다
text = response.text

# 크롤링한 문자를 html로 파싱하기
tags = bs4.BeautifulSoup(text, 'html.parser')
print("태그=>",tags)

# 원하는 태그의 정보만 선택하기
# ul태그의 simpleNesList를 모두 선택하여 list타입으로 변환해준다. [[<ul>.....</ul>],[<ul>.....</ul>],[]]
ul_list = tags.select("ul.simpleNewsList")
#print(ul_list)

for ulTag in ul_list:
        # ul태그내의 li태그를 검색한다.
        li_list = ulTag.find_all('li')
        #print(li_list)
        for liTag in li_list:
                # a 태그의 title속성의 속성
                aTag = liTag.find("a") # a태그를 찾아준다.
                # a태그의 title속의 값을 뉴스제목으로 사용
                title = aTag.get("title")
                # a태그의 href속성의 값구하기
                href = aTag.get("href")
                print(title, '\n', href)
                # 언론사명
                name = liTag.find("span", class_="press").get_text(strip=True) # strip : 여백, Enter제거
                # 발해일
                date = liTag.find("span", class_="wdate").get_text()
                print(title, '\n', href, '\n', name, '\n', date)    
                print('-'*100)  
                


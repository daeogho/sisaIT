import requests as req
import bs4

url = "https://www.melon.com/chart/index.htm"

headers = {
        "User-Agent": (
                "Mozilla/5.0 (windows NT 10.0; win64; x64)"
                "AppleWebKit/537.36 (KHTML, like Gecko)"
                "Chrome/130.0.0.0 Safari/537.36"
        )
}
request = req.get(url, headers=headers)

# html로 파싱
melonTag = bs4.BeautifulSoup(request.text, 'html.parser')
# tr태그의 class=lst50, class=lst100
# 1~50위
rank1_50 = melonTag.select('tr.lst50')
rank51_100 = melonTag.select('tr.lst100')
for rank in rank1_50 + rank51_100:
        # 순위
        r = rank.find("span").get_text()
        
        # 곡명
        songname = rank.select("div.ellipsis.rank01 > span > a")[0].get_text()
        # 아티스트 이름
        artname = rank.select("div.ellipsis.rank02 > span > a")[0].get_text()
        # 앨범명
        albumname = rank.select("div.ellipsis.rank03 > a")[0].get_text()
        # 앨범주소
        albumlink = rank.select("div.ellipsis.rank03 > a")[0].get("href")
        
        songlist.append((r,songname, artname,albumname, albumlink))
        #print(f"{r},{songname}\n{artname}, {albumname},{albumlink}")
print(songlist)

# 시스템의 key값을 가져올 때 필요하다.
import os
# openai api를 사용하기 위해 필요하다.
from openai import OpenAI

api_key = os.getenv("OPENAI_API_KEY")

# 객체 생성
# 환경변수에 키가 있을 때

client = OpenAI(api_key="발급받은 키사용")

# 질문하기 [] () {} 
response = client.chat.completions.create(
        model="gpt-4.1-mini", #모델명
        messages=[
                {"role": "user", "content": "95년 2월 23일 생일 오늘 운세 알려줘"}
        ]
)

print(response)
print("*"*100)
print(response.choices[0].message.content)
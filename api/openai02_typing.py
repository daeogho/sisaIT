import os
from openai import OpenAI

import time

key = os.getenv("OPENAI_API_KEY")

client = OpenAI(api_key=key)

stream = client.chat.completions.create(
        model = "gpt-4.1-mini",
        messages=[
                {"role":"user", "content":"평범한 사람이 인생을 뒤집는 현실적인 방법 5가지"}       
        ],
        stream=True
)

# 스트림을 출력 : 타이핑 스타일
for chunk in stream:
        content = chunk.choices[0].delta.content
        #print(f"content=>{content}")
        
        if content:
                for char in content:
                        print(char, end="", flush=True)
                        time.sleep(0.04) #타이핑 속도
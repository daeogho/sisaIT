import os
from openai import OpenAI
import base64

key = os.getenv("OPENAI_API_KEY")

client = OpenAI(api_key=key)

print("이미지 생성중>>>>>>>>>")

result = client.images.generate(
        model="gpt-image-1",
        
        prompt="""
        롯데자이언츠가 시즌 우승했을때 사진 만들어줘
        """,
        
        size ="1024x1024"
)

image_base64 = result.data[0].b64_json
#파일로 저장
with open('openai_image.png', "wb") as f:
        f.write(base64.b64decode(image_base64))
        
print("이미지를 저장완료 하였습니다.")
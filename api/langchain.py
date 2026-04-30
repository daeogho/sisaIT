from langchain_openai import ChatOpenAI
from dotenv import load_dotenv
from langchain_core.prompts import PromptTemplate
from langchain_core.output_parsers import StrOutputParser

load_dotenv()

llm = ChatOpenAI(model="gpt-4.1-mini")

# PromptTemplate를 이용하여 프롬프트를 작성
# 문자열 템플릿을 기반으로 프롬프트를 자동으로 구성해준다.
prompt = PromptTemplate.from_template("{topic} 주제에 대한 한 문장으로 설명해줘")

# 응답 객체에서 텍스트(content)만 깔끔하게 추출해서 문자열로 변환해줌
output_str = StrOutputParser()

# LCEL 표현(프롬프트 -> LLM모델 -> 출력) 파이프라인 연결
chain = prompt | llm | output_str

# 랭체인을 이용해서 실행해보자
while True:
        inData = input("단어입력=>")
        response = chain.invoke({"topic":inData})
        print(response)

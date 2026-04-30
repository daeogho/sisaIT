# 가져올 노드 이미지 정의
FROM node:24

# 폴더를 생성하고 작업 디렉토리 설정
RUN mkdir /app
WORKDIR /app

COPY package*.json .
RUN npm install

COPY . .

EXPOSE 5173

CMD ["npm","run","dev", "--", "--host"]
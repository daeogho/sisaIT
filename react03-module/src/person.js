export const name = '세종대왕';
export const age = 40

const tel = '010-1234-5678';
const addr = '강남구 역삼동';

export{tel, addr}

// 함수를 이용하여 모듈작성하기
const message = ()=>{
        const name = '김연아';
        const age = 35;

        return name+ "의 나이는 " +age+ "세입니다."
}
export default message; // 한번만 가능하다.

// export default는 한번만 가능하다.
// 다른 export함수를 호출하더라도 export default함수가 호출 된다.
export const message2 = () =>{
        return "리엑트 모듈 함수 테스트 중....";
}
//export default message2;
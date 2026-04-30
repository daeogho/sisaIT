import p31_mysql_select as m_select
import p29_mysql_insert as m_insert
import p30_mysql_update as m_update
import p32_mysql_delete as m_delete
# 메뉴
menu = "1. 회원목록 2.회원등록 3.회원수정 4.회원탈퇴 5.종료"

if __name__ == '__main__':
        
        while True:
                selMenu = int(input(menu))
                
                if selMenu == 1: #회원목록
                        obj = m_select.MemberSelect()
                        obj.memberList()
                elif selMenu == 2: #회원등록
                        obj = m_insert.MysqlInsert()
                        #이름
                        name = input("이름을 입력하세요.?")
                        #연락처
                        tel = input("연락처를 입력하세요.?")
                        #이메일
                        email = input("이메일을 입력하세요.?")
                        
                        obj.memberInsert(name=name, tel=tel, email=email)
                
                elif selMenu == 3:
                        obj = m_update.MemberUpdate()
                        name = input("수정할 회원명=")
                        
                        tel = input("바뀐전화번호-->")
                        email = input("바뀐이메일-->")
                        
                        obj.memberUpdate(name=name, tel=tel, email=email)
                        
                elif selMenu == 4:
                        obj = m_delete.MemberDelete()
                        
                        name = input("탈퇴할 회원명-->")
                        obj.memberDel(name)
                        
                else: #종료
                        break
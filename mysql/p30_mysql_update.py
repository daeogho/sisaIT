import p27_mysql_connect as mysqld
class MemberUpdate:
        def __init__(self):
                pass 
        
        def memberUpdate(self, name, tel, email):
                conn = mysqld.dbConnect()
                
                sql = "update py_member set tel=%s, email=%s where name=%s"
                
                try:
                        with conn.cursor() as cursor:
                                cursor.execute(sql, (tel, email, name))
                                conn.commit()
                finally:
                        if cursor.rowcount>0:
                                print("회원정보가 수정되었습니다.")
if __name__=='__main__':
        update = MemberUpdate()
        
        name = input("수정할 회원명=")    
        tel = input("변경할 연락처=")
        email = input("변경할 이메일=")
        
        update.memberUpdate()
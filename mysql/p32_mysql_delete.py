import p27_mysql_connect as mysql

class MemberDelete:
        def __init__(self):
                pass
        
        def memberDel(self, name):
                conn = mysql.dbConnect()
                
                with conn.cursor() as cursor:
                        sql = 'delete from py_member where name=%s'
                        cursor.execute(sql, (name,))
                        conn.commit()
                        if cursor.rowcount>0:
                                print(f'{name}회원이 삭제되었습니다.')
                        else :
                                print(f"{name}회원 삭제 실패하였습니다.")
                                
if __name__ == '__main__':
        delete = MemberDelete()
        
        delName = input("삭제할 회원명 : ")
        
        delete.memberDel(name=delName)        
        
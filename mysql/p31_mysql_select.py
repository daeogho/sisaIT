import p27_mysql_connect as mysql

class MemberSelect:
        def __init__(self):
                pass

        def memberList(self):
                conn = mysql.dbConnect()
                
                sql = "select no, name, tel, email, writedate from py_member order by no"
                
                with conn.cursor() as cur:
                        cur.execute(sql)
                        
                        # 선택된 레코드 가지고 나오기
                        record = cur.fetchall()
                        print(record)
                        
                        for mem in record:
                                print(f"{mem[0]:<5d} {mem[1]:6s} {mem[2]:15s} {mem[3]:15s} {mem[4]:15s}")
                        
if __name__ == '__main__':
        select = MemberSelect()
        
        select.memberList()
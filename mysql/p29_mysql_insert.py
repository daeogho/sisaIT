import p27_mysql_connect as mysqldb

# insert 구현할 클래스
class MysqlInsert:
        def __init__(self):
                pass
        
        def memberInsert(self, name, tel, email):
                try:
                        sql = '''
                                insert into py_member(name, tel, email)
                                values(%s, %s, %s)
                        '''
                        # db연결
                        connect = mysqldb.dbConnect()
                        
                        cursor = connect.cursor()
                        #              쿼리문, 데이터를 tuple로 설정한다.
                        cursor.execute(sql, (name, tel, email))
                        # 자동 commit이 안되어 commit해줌
                        connect.commit()
                        print(str(cursor.rowcount) + "행이 추가됨")                     
                finally:
                        connect.close()
                        print(f"{name}회원을 등록하였습니다.")
        
# Start ------------------

if __name__ == '__main__':
        mInsert = MysqlInsert()
        #for i in itertools.count():
        while True:
                #이름
                name = input("이름을 입력하세요.?")
                #연락처
                tel = input("연락처를 입력하세요.?")
                #이메일
                email = input("이메일을 입력하세요.?")
                
                mInsert.memberInsert(name=name, tel=tel, email=email)
        
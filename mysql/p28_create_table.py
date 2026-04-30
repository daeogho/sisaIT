import p27_mysql_connect as db
# 테이블생성하기

# 클래스 생성 ------------------------
class CreateTable:
        #생성자 메소드
        def __init__(self):
                pass
                # 1. DB연결
        
        # 테이블생성하는 메소드
        def createTable(self):
                # 1. DB연결
                conn = db.dbConnect()
                
                sql='''
                create table py_member(
                        no int auto_increment primary key,
                        name varchar(3) not null,
                        tel varchar(15) not null,
                        email varchar(50) null,
                        writedate datetime default now()
                        )
                '''
                try:
                        #쿼리문을 실행하기 위해서는 cursor()를 생성한다.
                        with conn.cursor() as cursor:
                                #쿼리문 구현하기
                                cursor.execute(sql)
                finally:
                        print("테이블생성완료")
                        conn.close()
                        
                # 쿼리문을 실행하기 위해서는 cursor()를 생성한다.

# main--------------------------------
if __name__ =="__main__":
        # DB연결후 테이블생성하기
        table = CreateTable()
        table.createTable()
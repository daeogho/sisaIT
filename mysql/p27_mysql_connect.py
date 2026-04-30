import pymysql

# localhost, 127.0.0.1, 192.168.4.60
def dbConnect():
        return pymysql.connect(
                host="127.0.0.1",
                user="root",
                password="tiger1234",
                database="python_db",
                charset="utf8"
        )

print("DB연결성공")
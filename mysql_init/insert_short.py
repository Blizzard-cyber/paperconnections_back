import pymysql
import jsonlines
import json
from tqdm import tqdm
from prestool.Tool import Tool

d = []
tool = Tool()
with jsonlines.open("./data1.jl") as f:
    for line in f:
        d.append(line)

db = pymysql.connect(host='localhost',
                     user='debian-sys-maint',
                     password='tLIZjTSvJLwuaUQq',
                     database='p', charset="utf8")
cursor = db.cursor()
data = d[0]

for i in tqdm(range(651)):
    data = d[i]
    data = (data['title'], data['journal-ref'], data['update_date'], data['comments'],
            data['doi'], data['authors'], data['categories'], data['abstract'], data['id'])
    # data = list(map(lambda x: 'nulll' if x is None else x, data))
    sql = 'INSERT INTO paper' \
          '(title, journal, date, commit, doi, author, category, abstract, id)' \
          ' VALUES ("%s", "%s",  "%s",  "%s",  "%s", "%s", "%s", "%s", "%s")'
    try:
        # 执行sql语句
        cursor.execute(sql, data)
        # 提交到数据库执行
        db.commit()
    except Exception as e:
        # 如果发生错误则回滚
        print(e.with_traceback())
        db.rollback()
        exit()

user_user = [0, 0, 0]
user_pwd = [0, 0, 0]
user_md5 = [0, 0, 0]
for i in range(3):
        user_ = tool.random_string(3)
        pwd_row = tool.random_string(3)
        pwd_md5 = tool.to_md5(pwd_row)
        user_user[i] = user_
        user_pwd[i] = pwd_row
        user_md5[i] = pwd_md5
        sql = "INSERT INTO user(name, pwd) VALUES ('%s', '%s')" % \
              (user_, pwd_md5)
        try:
            # 执行sql语句
            cursor.execute(sql)
            # 提交到数据库执行
            db.commit()
            print(1)
        except Exception as e:
            # 如果发生错误则回滚
            # print(e.with_traceback())
            db.rollback()
with jsonlines.open('user_pwd.jl', 'w') as f:
    f.write(user_user)
    f.write(user_pwd)
    f.write(user_md5)

tag_row = ['cs.AI', 'cs.AR', 'cs.CC', 'cs.CE', 'cs.CG']
tag_xx = ['Artificial Intelligence', 'Hardware Architecture', 'Computational Complexity',
          'Computational Engineering, Finance, and Science', 'Computational Geometry']
for i in range(5):
    sql = f"INSERT INTO tag(content, categories) VALUES (%s, %s)"
    param = (tag_xx[i], tag_row[i])
    try:
        # 执行sql语句
        cursor.execute(sql, param)
        # 提交到数据库执行
        db.commit()
        print(1)
    except Exception as e:
        # 如果发生错误则回滚
        print(e.with_traceback())
        exit()
        db.rollback()

db.close()

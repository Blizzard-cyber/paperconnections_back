import pymysql
import jsonlines
import json
from tqdm import tqdm

d = []

with jsonlines.open("./data.jl") as f:
    for line in f:
        d.append(line)

db = pymysql.connect(host='localhost',
                     user='/',
                     password='/',
                     database='p')
cursor = db.cursor()
data = d[0]

for i in tqdm(range(200)):
    data = d[i]
    data = [data['title'], data['journal-ref'], data['update_date'], data['comments'],
            data['doi'], data['authors'], data['categories'], data['abstract'], data['id']]
    # data = list(map(lambda x: 'nulll' if x is None else x, data))
    sql = "INSERT INTO paper(title, \
         journal, date, commit, doi, author, category, abstract, id) \
           VALUES ('%s', '%s',  '%s',  '%s',  '%s', '%s', '%s', '%s', '%s')" % \
          (data[0], data[1], data[2], data[3],
           data[4], data[5], data[6], data[7], data[8])
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

db.close()

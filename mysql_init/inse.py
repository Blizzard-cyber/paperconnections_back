import pymysql
import jsonlines
import json
from tqdm import tqdm

d = []
with open('./arxiv.json', 'r', encoding='utf-8') as f:
    for lines in f:
        t = json.loads(lines)
        d.append(t)

print(len(d))
with jsonlines.open('data.jl', 'w') as f:
    for i in tqdm(range(200)):
        f.write(d[i])
# db = pymysql.connect(host='localhost',
#                      user='debian-sys-maint',
#                      password='tLIZjTSvJLwuaUQq',
#                      database='p')
# cursor = db.cursor()
# for i in tqdm(range(100)):
#     data = d[i]
#     # sql = f"""INSERT INTO paper(title,
#     #      journal, date, commit, doi, author, category, abstract)
#     #      VALUES ({d['title']}, {d['journal-ref']}, {d['update-date']},
#     #       {d['commits']}, {d['doi']}, {d['authors']}, {d['categories']}, {d['abstract']})"""
#     # try:
#     #     # 执行sql语句
#     #     cursor.execute(sql)
#     #     # 提交到数据库执行
#     #     db.commit()
#     # except Exception as e:
#     #     # 如果发生错误则回滚
#     #     db.rollback()
#
#     with jsonlines.open('data.jl', 'w') as f:
#         f.write(d[i])

# 关闭数据库连接
# db.close()

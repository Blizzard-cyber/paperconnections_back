import pymysql
import jsonlines
import json
from tqdm import tqdm

d = []
numw = 0
with open('./arxiv.json', 'r', encoding='utf-8') as f:
    for lines in f:
        t = json.loads(lines)
        d.append(t)
        numw += 1
        if numw > 50000:
            break

tag_row = ['cs.AI', 'cs.AR', 'cs.CC', 'cs.CE', 'cs.CG']
num = [0, 0, 0, 0, 0]
with jsonlines.open('data1.jl', 'w') as f:
    for i in range(len(d)):
        for j in range(5):
            if tag_row[j] in d[i]['categories']:
                f.write(d[i])
                num[j] += 1
print(num)


# PaperConnection

[![](https://img.shields.io/badge/status-buliding-brightgreen.svg)]({linkUrl})

PaperConnection项目的数据库与后端部份,前端部分见[[web]](https://github.com/Blizzard-cyber/paperconnections_front)

该项目受ConnectedPapers启发，实现以文献知识图谱为核心的功能构建。

PaperConnection的主要功能如下：

- [ ] 生成给定文献的相关图谱
- [ ] 用户注册与登录
- [ ] 主页用户个性化推荐
- [ ] 用户个人中心
- [ ] 其他用户搜索

PaperConnection的主要技术如下：

- 前端框架：Vue
- 后端框架：SSM
- 数据库：mysql
- 前后端通信：Axios（基于Ajax）

## FolderExplanation

```
PaerConnection/
|──mysql_init/:各种数据库文件
|──java_spring/:各种java文件
	|──PaperConnections:后端java项目
|──utils/：一些工具目录
	|──aboutGit.md:git使用和更新说明
	|──aboutTabular.md:建立数据库表格的说明
	|──Paper Connections.rp:设计原型图
	|──img/:工具所要使用的一些图片
|──LICENSE:MIT LICENSE
|──REAMD.md
```

## Denpendancy

- mysql
- spring-boot
- vue3

## Usage

1. 下载arxiv数据集至./mysql_init，[链接在此](https://www.kaggle.com/datasets/Cornell-University/arxiv/download?datasetVersionNumber=105)

2.  运行mysql_init/tabula_init.sql

3.  python inse.py

   > 生成包含前200条数据的试运行数据文件data.jl

4. python insert_short.py

   > 插入前200条数据

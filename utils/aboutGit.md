# 2022秋季软件工程课程实验Spingboot+VUE项目——PaperConnections后端部分

> 提供一种协同开发方法，便于维护代码的一致性

## git基础

### 提交指南

![push](./img/push.png)

### 合并指南

![merge](./img/merge.png)

###  Setup

``` bash
#拉取远端仓库代码
git clone https://github.com/Blizzard-cyber/paperconnections_back.git

#拉取到本地后查看master分支（主分支）内容为模板内容
.....
#编写代码
.....
#编写代码完成

#创建自己的分支
git checkout -b <yourBranchName>

#提交过程
#提交所有更改
git add .

#commit
git commit -m "提交说明"

#push
git push origin <yourBranchName>

#合并代码到master分支
#切换到master分支
git  checkout main

#pull master分支的状态
git pull origin main

#合并自己分支到master
git  merge test

#可检查状态
git status

#push到远端
git push origin main
```

## Gitui

- [提供git的ui操作](https://github.com/extrawurst/gitui)

## Others

- 每当新建二级或三级目录时，请更新README中的FolderExplanation
- 为了保证目录的可理解性和精简性，至少为三级目录留下一个README

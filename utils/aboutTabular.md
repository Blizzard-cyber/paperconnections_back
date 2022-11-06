# Tabular

## 功能

PaperConnection的主要功能如下：

- 生成给定文献的相关图谱
  - 显示图谱（引用文章）
  - 被引用文章展示
  - 相似文章（根据引用计算）

- 用户注册与登录
  - 注册页面
  - 登录页面

- 主页用户个性化推荐
  - 转载 or 链接

- 用户个人中心
  - 用户标签展示
  - 用户关注、被关注展示
  - 用户收藏文章
  - 用户收藏推送

- 其他用户搜索
  - 根据名字/标签

- 搜索推送
  - 根绝名字/标签


## 建表

### 方案1

> auto INC表示自增id,具有唯一性
>
> 操作等级分为root与user，user只有读取权限，root具有全部权限
>
> 为了速率不设置外键，无外键返回为空

- paper(存储文章的标题)
  - paperID(auto INC)
  - name:文章标题
  - year:文章年份
  - others:发表期刊（可选）
  
- link（存储文章的链接）
  - linkID(auto INC)
  - paperID：文章对应的paper表ID
  - link_addr:文章链接（一篇文章可能对应多个网站）
- author（存储作者信息）
  - authorID(auto INC)
  - name:作者名称
- a_p_link:存储作者和文章对应的信息
  - apID(auto INC)
  - paperID：文章ID
  - authorID:作者ID
- cited:存储引用与被引用信息
  - citeID(auto INC)
  - paperID：引用文章信息
  - citePaperID：被引用文章信息

- user：存储用户信息
  - userID(auto INC)
  - name：用户名称
- tag：存储标签信息
  - tagID(autoID)
  - tag_content：标签内容
- u_t_link:存储用户和标签对应信息
  - utlinkID(auto INC)
  - userID：用户ID
  - tagID:标签ID
- u_p_link:存储用户和文章对应信息
  - uplinkID(auto INC)
  - userID:用户ID
  - paperID:文章ID
- u_u_link：用户之间的关注和被关注信息
  - uulinkID(auto INC)
  - user1ID：关注着信息
  - user2ID：被关注者信息
- msg：推送信息
  - msgID(auto INC)
  - content：推送内容
- m_t_link：推送与tag对应信息
  - mtlinkID(auto INC)
  - tagID：tag信息
  - msgID：推送信息

- u_m_link:存储用户和推送对应信息

  - umlinkID(auto INC)

  - userID:用户ID

  - msgID:推送ID